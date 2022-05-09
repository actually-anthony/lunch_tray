package com.example.lunchtray

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lunchtray.databinding.FragmentAccompanimentBinding
import com.example.lunchtray.databinding.FragmentSideBinding
import com.example.lunchtray.model.LunchViewModel
import kotlin.properties.ReadOnlyProperty


class AccompanimentFragment : Fragment() {

    private var binding: FragmentAccompanimentBinding? = null
    private val sharedViewModel: LunchViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentAccompanimentBinding.inflate(inflater,container,false)
        binding = fragmentBinding
        return fragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            accompanimentFragment = this@AccompanimentFragment
        }


    }

    fun cancelOrder() {
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_accompanimentFragment_to_startFragment)
    }

    fun goToNextScreen() {
        sharedViewModel.updateTax()
        sharedViewModel.updateTotal()
        findNavController().navigate(R.id.action_accompanimentFragment_to_summaryFragment)
    }
}


