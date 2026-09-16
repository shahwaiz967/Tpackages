package com.codecx.tpackages.features.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codecx.tpackages.data.model.DataUsageModel
import com.codecx.tpackages.databinding.ItemDataUsageBinding

class DataUsageAdapter(private var list: List<DataUsageModel>) : RecyclerView.Adapter<DataUsageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(ItemDataUsageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val item = list[position]
        with(holder.binding) {
            tvDate.text = item.date
            tvMobile.text = "${item.mobileData} MB"
            tvWifi.text = "${item.wifiData} MB"
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(newList: List<DataUsageModel>) {
        list = newList
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemDataUsageBinding) : RecyclerView.ViewHolder(binding.root)
}
