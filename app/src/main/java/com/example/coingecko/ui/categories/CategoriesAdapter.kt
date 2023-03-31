package com.example.coingecko.ui.categories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coingecko.R
import com.example.coingecko.data.model.categories.CategoriesModel
import com.example.coingecko.data.model.categories.CategoriesItemModel
import com.example.coingecko.databinding.ItemCategoriesBinding

class CategoriesAdapter (val category: CategoriesModel):
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>(){
    var onItemClick: ((CategoriesItemModel)-> Unit)?= null

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding= ItemCategoriesBinding.bind(view)

        fun handleData(item: CategoriesItemModel?){
            item?.let {
                binding.textView1.text = item?.categoryId
                binding.textView2.text = item?.name

            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_categories, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.ViewHolder, position: Int) {
        holder.handleData(category?.get(position))
        holder.itemView.setOnClickListener{
           category?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }
    }

    override fun getItemCount(): Int = category?.size?:0


}