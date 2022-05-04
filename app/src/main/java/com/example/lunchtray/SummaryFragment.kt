package com.example.lunchtray

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.lunchtray.databinding.FragmentSummaryBinding
import com.example.lunchtray.model.LunchViewModel


class SummaryFragment : Fragment() {

    private var binding: FragmentSummaryBinding? = null
    private val sharedViewModel: LunchViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentSummaryBinding.inflate(inflater,container,true)
        binding = fragmentBinding
        return  fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            viewModel = sharedViewModel
            summaryFragment = this@SummaryFragment
            lifecycleOwner = viewLifecycleOwner
        }
    }
}