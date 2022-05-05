package com.example.lunchtray

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lunchtray.databinding.FragmentEntreeBinding
import com.example.lunchtray.databinding.FragmentSideBinding
import com.example.lunchtray.model.LunchViewModel


class SideFragment : Fragment() {

    private var binding: FragmentSideBinding? = null
    private val sharedViewModel: LunchViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentSideBinding.inflate(inflater,container,false)
        binding = fragmentBinding
        return fragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            // used to update UI
            lifecycleOwner = viewLifecycleOwner

            // used for data binding in xml
            viewModel = sharedViewModel
            // this = binding instance
            // @EntreeFragment = literally this class
            sideFragment = this@SideFragment

        }
    }

    fun cancelOrder() {
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_sideFragment_to_startFragment)
    }

    fun goToNextScreen() {
        findNavController().navigate(R.id.action_sideFragment_to_accompanimentFragment)
    }
}