package com.codecx.tpackages.features.adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.graphics.toColorInt
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codecx.tpackages.data.model.DeviceOffersModel
import com.codecx.tpackages.data.utils.handleActivation
import com.codecx.tpackages.databinding.ItemDeviceFragmentBinding

class DevicePackageAdapter : ListAdapter<DeviceOffersModel, DevicePackageAdapter.ViewHolder>(DiffCallback()) {
    
private val buttonColors = listOf(
    "#22C55E".toColorInt(),
    "#0084DE".toColorInt(),
    "#4CAF50".toColorInt(),
    "#FF9800".toColorInt(),
    "#9C27B0".toColorInt()
)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemDeviceFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemDeviceFragmentBinding)
        : RecyclerView.ViewHolder(binding.root){
            fun bind(item: DeviceOffersModel){
                binding.apply {
                    tvTitle.text = item.title
                    tvCode.text = item.code
                    
                    if (!item.description.isNullOrEmpty()) {
                        tvDes.text = item.description
                        tvDes.isVisible = true
                    } else {
                        tvDes.isVisible = false
                    }

                    val color = buttonColors[bindingAdapterPosition % buttonColors.size]
                    btnDial.backgroundTintList = ColorStateList.valueOf(color)

                    btnDial.setOnClickListener { handleActivation(root.context,item.code) }

                    copyBtn.setOnClickListener {
                        val clipboard = root.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                        val clip = ClipData.newPlainText("Code", item.code)
                        clipboard.setPrimaryClip(clip)
                        Toast.makeText(root.context, "Code Copied", Toast.LENGTH_SHORT).show()
                    }
                    shareBtn.setOnClickListener {
                        val intent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_TEXT, item.code)
                        }
                        root.context.startActivity(Intent.createChooser(intent, "Share Via"))
                    }
                }
            }
        }

    

    class DiffCallback : DiffUtil.ItemCallback<DeviceOffersModel>() {
        override fun areItemsTheSame(oldItem: DeviceOffersModel, newItem: DeviceOffersModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DeviceOffersModel, newItem: DeviceOffersModel): Boolean {
            return oldItem == newItem
        }
    }
}
