package com.example.coingecko.ui.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coingecko.data.model.categories.CategoriesModel
import com.example.coingecko.databinding.FragmentCategoriesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoriesFragment : Fragment() {
    private var _binding: FragmentCategoriesBinding?=null
    private val binding get()=_binding!!
    private val viewModel by viewModels<CategoriesViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //viewModel=ViewModelProvider(this).get(CategoriesViewModel::class.java)

        _binding= FragmentCategoriesBinding.inflate(inflater, container, false)


        viewModel.categories.observe(viewLifecycleOwner){
            it.let {
                setupUI(it)
            }

        }

        viewModel.getCategory()
        return binding.root
    }
    fun setupUI(category: CategoriesModel) {
        val categoryAdapter= CategoriesAdapter(category)
        binding.rvCategories.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = categoryAdapter
        }
        categoryAdapter.onItemClick = {
            val bundle=Bundle().apply{
                putSerializable("CategoriesId",it.categoryId)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}
