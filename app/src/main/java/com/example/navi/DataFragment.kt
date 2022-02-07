package com.example.navi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.navi.databinding.FragmentDataBinding


class DataFragment : Fragment(R.layout.fragment_home) {
private lateinit var binding: FragmentDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDataBinding.inflate(inflater)
        binding.btndata.setOnClickListener { view: View->
            Navigation.findNavController(view).navigate(R.id.action_dataFragment_to_homeFragment)
        }
        return binding.root
    }


}