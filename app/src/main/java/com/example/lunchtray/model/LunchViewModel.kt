package com.example.lunchtray.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.text.NumberFormat

class LunchViewModel: ViewModel() {

    private val _entree = MutableLiveData<String>()
    val entree: LiveData<String> = _entree

    private val _entreePrice = MutableLiveData<Double>()
    val entreePrice = _entreePrice

    private val _side = MutableLiveData<String>()
    val side: LiveData<String> = _side

    private val _sidePrice = MutableLiveData<Double>()
    val sidePrice = _sidePrice

    private val _accompaniment = MutableLiveData<String>()
    val accompaniment: LiveData<String> = _accompaniment

    private val _accompanimentPrice = MutableLiveData<Double>()
    val accompanimentPrice = _accompanimentPrice

    private val _price = MutableLiveData<Double>()

    // formats price to $xx.xx
    val price: LiveData<String> = Transformations.map(_price) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    init {
        resetOrder()
    }

    fun resetOrder() {
        _entree.value = ""
        _side.value = ""
        _accompaniment.value = ""
        _price.value =  0.0
        _entreePrice.value = 0.0
        _sidePrice.value = 0.0
        _accompanimentPrice.value = 0.0
    }

    fun setEntree(name: String, price: Double) {
        _entree.value = name
        _entreePrice.value = price
        updatePrice()
    }

    fun setSide(name: String, price: Double) {
        _side.value = name
        _sidePrice.value = price
        updatePrice()
    }

    fun setAccompaniment(name: String, price: Double) {
        _accompaniment.value = name
        _accompanimentPrice.value = price
        updatePrice()
    }


    private fun updatePrice() {
        // None carry a null value due to resetOrder()
        _price.value = sidePrice.value!!.plus(entreePrice.value!!).plus(accompanimentPrice.value!!)
    }

}