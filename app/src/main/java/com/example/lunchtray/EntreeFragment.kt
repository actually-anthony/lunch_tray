package com.example.lunchtray

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lunchtray.databinding.FragmentEntreeBinding
import com.example.lunchtray.model.LunchViewModel


class EntreeFragment : Fragment() {

    private var binding: FragmentEntreeBinding? = null
    private val sharedViewModel: LunchViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // used for data binding
        val fragmentBinding = FragmentEntreeBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Used for data binding in the XML file. Check variables in the XML.
        binding?.apply {
            // used to update UI
            lifecycleOwner = viewLifecycleOwner

            viewModel = sharedViewModel
            // this = binding instance
            // @EntreeFragment = literally this class
            entreeFragment = this@EntreeFragment

        }
    }

    fun cancelOrder() {
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_entreeFragment_to_startFragment)
    }

    fun goToNextScreen() {
        findNavController().navigate(R.id.action_entreeFragment_to_sideFragment)
    }


}