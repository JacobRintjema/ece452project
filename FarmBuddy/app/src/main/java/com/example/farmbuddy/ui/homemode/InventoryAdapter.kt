package com.example.farmbuddy.ui.homemode

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.farmbuddy.R
import com.example.farmbuddy.databinding.HomeModeItemBinding

class InventoryAdapter(private val collections: List<InventoryModel>) : RecyclerView.Adapter<InventoryAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val binding = HomeModeItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_mode_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            val collection = collections[position]
            inventoryTitle.text = collection.inventoryTitle
            val produceAdapter = ProduceAdapter(collection.produceModelsHome)
            recyclerProduce.adapter = produceAdapter

            inventoryTitle.setOnClickListener {
                recyclerProduce.visibility = if(recyclerProduce.isShown) View.GONE else View.VISIBLE
            }

            dropdown.setOnClickListener {
                recyclerProduce.visibility = if(recyclerProduce.isShown) View.GONE else View.VISIBLE
            }
        }
    }

    override fun getItemCount() = collections.size
}