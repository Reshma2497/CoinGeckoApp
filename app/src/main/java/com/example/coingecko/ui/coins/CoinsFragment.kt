package com.example.coingecko.ui.coins

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coingecko.data.model.coins.CoinsModel
import com.example.coingecko.databinding.FragmentCoinsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinsFragment : Fragment() {

    private val viewModel by viewModels<CoinsViewModel>()
    private var _binding: FragmentCoinsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCoinsBinding.inflate(inflater, container, false)
        val userId=arguments?.getSerializable("userid") as String
        binding.tvemail.text=userId
        viewModel.coinsModel.observe(viewLifecycleOwner) {
            it.let {
                setupUI(it)
            }
        }

        viewModel.getCoins()
        return binding.root

    }

    fun setupUI(coins: CoinsModel) {
        val coinsAdapter= CoinsAdapter(coins)
        binding.rvCoins.apply {
            layoutManager=LinearLayoutManager(context)
            adapter= coinsAdapter
        }
        coinsAdapter.onItemClick = {
            val bundle = Bundle().apply {
                putSerializable("CoinsId", it.id)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}