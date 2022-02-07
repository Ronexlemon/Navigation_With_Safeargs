package com.example.navi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.navi.databinding.FragmentCashBinding

class CashFragment : Fragment(R.layout.fragment_cash) {
    private lateinit var binding: FragmentCashBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentCashBinding.inflate(inflater)


        binding.cashsend.setOnClickListener { view: View ->
            val edit  :EditText= requireView().findViewById(R.id.editsend)
            val cash = edit.text.toString()
            val action = CashFragmentDirections.actionCashFragmentToResultFragment(cash.toFloat())
            Navigation.findNavController(view).navigate(action)
        }
        return binding.root

    }
}