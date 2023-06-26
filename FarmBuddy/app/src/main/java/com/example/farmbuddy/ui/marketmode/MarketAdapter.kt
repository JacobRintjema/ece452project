package com.example.farmbuddy.ui.marketmode

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.farmbuddy.R
import com.example.farmbuddy.databinding.MarketModeItemBinding

class MarketAdapter(private val collections: List<MarketModel>) : RecyclerView.Adapter<MarketAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val binding = MarketModeItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.market_mode_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            val collection = collections[position]
            marketTitle.text = collection.marketTitle
            val produceAdapter = ProduceAdapter(collection.produceModels)
            recyclerProduce.adapter = produceAdapter

            marketTitle.setOnClickListener {
                recyclerProduce.visibility = if(recyclerProduce.isShown) View.GONE else View.VISIBLE
            }

            dropdown.setOnClickListener {
                recyclerProduce.visibility = if(recyclerProduce.isShown) View.GONE else View.VISIBLE
            }
        }
    }

    override fun getItemCount() = collections.size
}