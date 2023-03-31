package com.example.coingecko.ui.Exchange

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coingecko.R
import com.example.coingecko.data.model.exchanges.ExchangesItemModel
import com.example.coingecko.data.model.exchanges.ExchangesModel
import com.example.coingecko.databinding.ItemExchangeBinding

class ExchangesAdapter (val exchanges: ExchangesModel):
    RecyclerView.Adapter<ExchangesAdapter.ViewHolder>(){
    var onItemClick: ((ExchangesItemModel)-> Unit)?= null

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val binding= ItemExchangeBinding.bind(view)

        fun handleData(item: ExchangesItemModel?,  clickFn: (ExchangesItemModel) -> Unit){
            item?.let {
                binding.textView.text = item.id
                binding.textView1.text = item.name
                // binding.textView2.text = item?.image
//                val imgView: ImageView = binding.itemImage
                Glide.with(view).load(it.image).placeholder(R.drawable.ic_launcher_foreground)
                    .into(binding.itemImage)

                //Sets the Listener to navigate to Details page.
                //Refer to the onItemClick definition in HomeFragment
                //clickFn is to invoke the definition
                itemView.setOnClickListener { ui ->
                    clickFn(it)
                }
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExchangesAdapter.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_exchange, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExchangesAdapter.ViewHolder, position: Int) {
        val resultModel= exchanges.get(position)
        holder.handleData(resultModel){
            em: ExchangesItemModel -> onItemClick?.invoke(em)
        }


    }

    override fun getItemCount(): Int = exchanges.size?:0


}