package com.example.navi


import android.os.Bundle
import android.view.*

import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.navi.R.id.action_homeFragment_to_dataFragment
import com.example.navi.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        binding.btnhome.setOnClickListener { view : View ->
         Navigation.findNavController(view).navigate(action_homeFragment_to_dataFragment)
        }
        binding.btnhomenext.setOnClickListener { view : View ->
           // Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_cashFragment)
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_cashFragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_resource,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,requireView().findNavController()) || super.onOptionsItemSelected(item)
    }
}