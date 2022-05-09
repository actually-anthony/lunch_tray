package com.example.lunchtray

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lunchtray.databinding.FragmentAccompanimentBinding
import com.example.lunchtray.databinding.FragmentSummaryBinding
import com.example.lunchtray.model.LunchViewModel

// TODO: Rename parameter arguments, choose names that match

class SummaryFragment : Fragment() {
    private var binding: FragmentSummaryBinding? = null
    private val sharedViewModel: LunchViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentSummaryBinding.inflate(inflater,container,false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            summaryFragment = this@SummaryFragment
        }
    }

    fun submitOrder() {
        val toast = Toast.makeText(context, "Order Submitted", Toast.LENGTH_LONG)
        toast.show()
        findNavController().navigate(R.id.action_summaryFragment_to_startFragment)
    }

    fun goToStart() {
        findNavController().navigate(R.id.action_summaryFragment_to_startFragment)
    }
}