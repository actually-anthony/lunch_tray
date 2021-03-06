package com.example.lunchtray

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lunchtray.databinding.FragmentStartBinding
import com.example.lunchtray.model.LunchViewModel

class StartFragment : Fragment() {

    // change constaintlayout -> layout then you'll get FragmentStartBinding
    private var binding: FragmentStartBinding? = null
    private val sharedViewModel: LunchViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // used for data binding in fragment_start.xml
        binding?.startFragment = this
    }

    fun startOrder() {
        if (sharedViewModel.noFoodSelected()) {
            sharedViewModel.setEntree(getString(R.string.cauliflower))
            sharedViewModel.setSide(getString(R.string.summer_salad))
            sharedViewModel.setAccompaniment(getString(R.string.lunch_roll))
        }

        findNavController().navigate(R.id.action_startFragment_to_entreeFragment)

    }




}