package com.example.coingecko.ui.Exchange

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coingecko.R
import com.example.coingecko.data.model.exchanges.ExchangesModel
import com.example.coingecko.databinding.FragmentExchangeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExchangeFragment : Fragment() {

    companion object {
        fun newInstance() = ExchangeFragment()
    }

    private var _binding: FragmentExchangeBinding?=null
    private val binding get()=_binding!!
    private lateinit var viewModel: ExchangeViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       viewModel=ViewModelProvider(this).get(ExchangeViewModel::class.java)

        _binding= FragmentExchangeBinding.inflate(inflater, container, false)


        viewModel.exchanges.observe(viewLifecycleOwner){
            it.let {
                setupUI(it)
            }

        }

        viewModel.getExchanges()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ExchangeViewModel::class.java)
        // TODO: Use the ViewModel
    }


    fun setupUI(exchanges: ExchangesModel) {
        val exchangesAdapter= ExchangesAdapter(exchanges)
        binding.rvExchanges.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = exchangesAdapter
        }
        exchangesAdapter.onItemClick = {
            val bundle=Bundle().apply{
                putSerializable("ExchangeId",it.id)
            }
       findNavController().navigate(
            R.id.action_exchangeFragment_to_exchangeDetailFragment,bundle
         )
        }
    }


}