package com.example.farmbuddy.ui.marketmode

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.farmbuddy.R
import com.example.farmbuddy.databinding.MarketModeSubitemBinding

class ProduceAdapter(private val produceModel: List<ProduceModel>) : RecyclerView.Adapter<ProduceAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = MarketModeSubitemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.market_mode_subitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            produceTitle.text = produceModel[position].produceTitle
            produceQuantity.text =  produceModel[position].produceQuantity.toString() + " lbs"
            produceCost.text = "$" + produceModel[position].produceCost.toString()
        }
    }

    override fun getItemCount() = produceModel.size
}