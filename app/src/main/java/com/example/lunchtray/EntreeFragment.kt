package com.example.lunchtray

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
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

        binding?.apply {
            // used to update UI
            lifecycleOwner = viewLifecycleOwner

            // used for data binding
            viewModel = sharedViewModel
            // this = binding instance
            // @EntreeFragment = literally this class
            entreeFragment = this@EntreeFragment

        }
    }


}