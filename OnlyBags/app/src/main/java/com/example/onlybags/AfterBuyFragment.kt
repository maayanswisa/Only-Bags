package com.example.onlybags

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.onlybags.ViewModelExample.Companion.DOLLAR_TO_SHEKEL_RATE
import com.example.onlybags.databinding.AllItemsLayoutBinding
import com.example.onlybags.databinding.FragmentAfterBuyBinding


class AfterBuyFragment : Fragment() { //view model - live data

    private var _binding: FragmentAfterBuyBinding? = null
    private val binding get() = _binding!!

    private val viewModel1: SumViewModel by activityViewModels()

    private  val viewModel:ViewModelExample by viewModels()





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAfterBuyBinding.inflate(inflater, container, false)

        viewModel1.sum.observe(viewLifecycleOwner){
            binding.sum.text = "${it} $"
        }

        viewModel.result.observe(viewLifecycleOwner){
            binding.resultText.text="${viewModel.result.value} Shekels"
        }

        binding.button.setOnClickListener{
            val input=binding.dollarInput.text.toString().toDouble()
            viewModel.setValue(input)
        }

        return binding.root
    }


}