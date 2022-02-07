package com.example.navi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.navi.databinding.FragmentResultsBinding

class ResultFragment : Fragment(R.layout.fragment_results) {
    private lateinit var binding: FragmentResultsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultsBinding.inflate(inflater)
        val args = ResultFragmentArgs.fromBundle(requireArguments())
       Toast.makeText(context,"cash sent ${args.cash}",Toast.LENGTH_LONG).show()
         binding.textView3.text = args.cash.toString()

       binding.btnBack.setOnClickListener { view : View ->
           Navigation.findNavController(view).navigate(ResultFragmentDirections.actionResultFragmentToCashFragment())

       }
        setHasOptionsMenu(true)
binding.btnClear.setOnClickListener { view : View ->
    binding.textView3.text = " "
}


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_share,menu)
        if(null == getShareIntent().resolveActivity(requireActivity().packageManager)){
            menu.findItem(R.id.share).isVisible = false
        }
    }
    @SuppressLint("StringFormatInvalid")
    private fun getShareIntent(): Intent{
        val args = ResultFragmentArgs.fromBundle(requireArguments())
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT,getString(R.string.share,args.cash))
        return shareIntent

    }
    private fun shareSucess(){
        startActivity(getShareIntent())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share -> shareSucess()
        }
        return super.onOptionsItemSelected(item)
    }
}