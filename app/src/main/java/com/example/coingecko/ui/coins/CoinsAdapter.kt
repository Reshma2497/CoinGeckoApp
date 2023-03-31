package com.example.coingecko.ui.coins

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coingecko.R
import com.example.coingecko.data.model.coins.CoinsItemModel
import com.example.coingecko.data.model.coins.CoinsModel
import com.example.coingecko.databinding.ItemCoinsBinding


class CoinsAdapter(val coin: CoinsModel) :
    RecyclerView.Adapter<CoinsAdapter.ViewHolder>() {

    var onItemClick: ((CoinsItemModel) -> Unit)? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding=ItemCoinsBinding.bind(view)

        fun handleData(item: CoinsItemModel?) {
            item?.let {
                binding.textView1.text = item.id
                binding.textView2.text = item.name
                binding.textView3.text= item.symbol
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CoinsAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_coins, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinsAdapter.ViewHolder, position: Int) {
        holder.handleData(coin?.get(position))
        holder.itemView.setOnClickListener {
            coin?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }
    }

    override fun getItemCount(): Int = coin.size ?: 0

}
