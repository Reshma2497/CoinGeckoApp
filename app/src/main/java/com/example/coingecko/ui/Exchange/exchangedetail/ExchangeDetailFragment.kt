package com.example.coingecko.ui.Exchange.exchangedetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coingecko.R
import com.example.coingecko.databinding.FragmentExchangeDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import com.example.coingecko.data.model.exchangedetail.ExchangeDetailModel as ExchangeDetailModel1
@AndroidEntryPoint
class ExchangeDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ExchangeDetailFragment()
    }

    private lateinit var viewModel: ExchangeDetailViewModel
    private var _binding: FragmentExchangeDetailBinding? = null
    private val binding get() = _binding!!
    private var exchangeId: String="asset id placeholder"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[ExchangeDetailViewModel::class.java]
        _binding = FragmentExchangeDetailBinding.inflate(inflater, container, false)

        viewModel.exchangeDetails.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)
            }
        }

         exchangeId = arguments?.getSerializable("ExchangeId") as String
        viewModel.getExchangeDetails(exchangeId)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ExchangeDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }
    fun setupUI(details: ExchangeDetailModel1) {
        binding.textView2.text="Exchange Id : "+details.name
        binding.textView3.text="Exchange name : "+details.yearEstablished
        binding.textView4.text="rank: "+details.country
        binding.textView5.text="updated: "+details.trustScore


    }

}




//companion object {
//    fun newInstance(id: String) = ExchangeDetailsFragment()
//        .apply {
//            arguments=Bundle().apply {
//                exchangeId=id
//
//            }
//        }
//}




