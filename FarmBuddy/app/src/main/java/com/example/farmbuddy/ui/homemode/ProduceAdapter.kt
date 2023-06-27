package com.example.farmbuddy.ui.homemode

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.farmbuddy.R
import com.example.farmbuddy.databinding.HomeModeSubitemBinding

class ProduceAdapter(private val produceModel: List<ProduceModelHome>) :
    RecyclerView.Adapter<ProduceAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = HomeModeSubitemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.home_mode_subitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            produceTitle.text = produceModel[position].produceTitle
            produceQuantity.text = produceModel[position].produceQuantity.toString() + " lbs"
        }
    }

    override fun getItemCount() = produceModel.size

}