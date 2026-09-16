package com.codecx.tpackages.features.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codecx.tpackages.data.model.Package
import com.codecx.tpackages.data.utils.handleSafeClick
import com.codecx.tpackages.databinding.ItemCallOffersBinding

class OffersAdapter(
    private val onAction: (Action, Package) -> Unit
) : ListAdapter<Package, OffersAdapter.ViewHolder>(DiffCallback()) {

    enum class Action {
        ACTIVATE, DEACTIVATE, STATUS
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCallOffersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemCallOffersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Package) {
            binding.apply {
                tvTitle.text = item.title
                tvSubtitle.text = if (item.validity != null) "${item.validity} Days" else ""
                tvPriceTop.text = "PKR, ${item.price}"

                itemOnNet.setValue(item.onNet ?: "-")
                itemOffNet.setValue(item.offNet ?: "-")
                itemSms.setValue(item.sms ?: "-")
                itemInternet.setValue(item.internet ?: "-")
                itemValidity.setValue(if (item.validity != null) "${item.validity} Days" else "-")
                itemPrice.setValue(item.price ?: "-")
                itemActivateCode.setValue(item.activate ?: "-")
                itemDeactivateCode.setValue(item.deactivate ?: "-")
                itemStatusCode.setValue(item.status ?: "-")

                tvDescription.text = item.desc ?: item.description ?: ""

                btnActivate.handleSafeClick { onAction(Action.ACTIVATE, item) }
                btnDeactivate.handleSafeClick { onAction(Action.DEACTIVATE, item) }
                btnStatus.handleSafeClick { onAction(Action.STATUS, item) }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Package>() {
        override fun areItemsTheSame(oldItem: Package, newItem: Package): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Package, newItem: Package): Boolean =
            oldItem == newItem
    }
}
