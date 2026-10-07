package com.codecx.tpackages.features.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codecx.tpackages.R
import com.codecx.tpackages.data.ads.nativeAds.NativeAdsUtil
import com.codecx.tpackages.data.model.AdItem
import com.codecx.tpackages.data.model.OffersPackage
import com.codecx.tpackages.data.utils.RemoteConfigHelper
import com.codecx.tpackages.data.utils.handleSafeClick
import com.codecx.tpackages.databinding.ItemCallOffersBinding

sealed class OfferAdapterItem {
    data class OfferItem(val offer: OffersPackage) : OfferAdapterItem()
    data class Ad(val adItem: AdItem = RemoteConfigHelper.adIds.offerNative) : OfferAdapterItem()
}

class OffersAdapter(
    private val onAction: (Action, OffersPackage) -> Unit
) : ListAdapter<OfferAdapterItem, RecyclerView.ViewHolder>(DiffCallback()) {

    companion object {
        const val TYPE_VIEW = 0
        const val TYPE_AD_VIEW = 1
    }

    enum class Action {
        ACTIVATE, DEACTIVATE, STATUS
    }

    fun getAdControllerValue(): Int {
        return when {
            RemoteConfigHelper.adIds.offerNativeFrequency > 0 -> RemoteConfigHelper.adIds.offerNativeFrequency
            else -> RemoteConfigHelper.adIds.adFrequency
        }
    }

    fun submitOffers(offersList: List<OffersPackage>?) {
        if (offersList.isNullOrEmpty()) {
            submitList(emptyList())
            return
        }

        val adConfig = RemoteConfigHelper.adIds.offerNative
        val frequency = getAdControllerValue()
        val adapterItems = mutableListOf<OfferAdapterItem>()

        offersList.forEachIndexed { index, offer ->
            adapterItems.add(OfferAdapterItem.OfferItem(offer))
            if (adConfig.isAdEnable && frequency > 0 && (index + 1) % frequency == 0) {
                adapterItems.add(OfferAdapterItem.Ad(adConfig))
            }
        }

        submitList(adapterItems)
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is OfferAdapterItem.OfferItem -> TYPE_VIEW
            is OfferAdapterItem.Ad -> TYPE_AD_VIEW
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_AD_VIEW) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video_ad, parent, false)
            AdViewHolder(view)
        } else {
            val binding = ItemCallOffersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is OfferAdapterItem.OfferItem -> (holder as? ViewHolder)?.bind(item.offer)
            is OfferAdapterItem.Ad -> (holder as? AdViewHolder)?.bind(item.adItem)
        }
    }

    class AdViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val adContainer: FrameLayout? = view.findViewById(R.id.adContainer)

        fun bind(adItem: AdItem) {
            val activity = itemView.context as? Activity ?: return
            if (adItem.isAdEnable && adContainer != null) {
                NativeAdsUtil.populateNativeAd(
                    isAdAllowed = true,
                    loadingAdView = R.layout.native_banner_shimmer,
                    nativeAdView = R.layout.native_banner,
                    adContainerView = adContainer,
                    nativeId = adItem.adId,
                    context = activity
                )
            } else {
                adContainer?.removeAllViews()
            }
        }
    }

    inner class ViewHolder(private val binding: ItemCallOffersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: OffersPackage) {
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

                val desc = item.desc ?: item.description
                if (!desc.isNullOrEmpty()) {
                    tvDescription.text = desc
                    cvDescription.isVisible = true
                } else {
                    cvDescription.isVisible = false
                }

                btnActivate.handleSafeClick { onAction(Action.ACTIVATE, item) }
                btnDeactivate.handleSafeClick { onAction(Action.DEACTIVATE, item) }
                btnStatus.handleSafeClick { onAction(Action.STATUS, item) }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<OfferAdapterItem>() {
        override fun areItemsTheSame(oldItem: OfferAdapterItem, newItem: OfferAdapterItem): Boolean {
            return when (oldItem) {
                is OfferAdapterItem.OfferItem -> newItem is OfferAdapterItem.OfferItem && oldItem.offer.id == newItem.offer.id
                is OfferAdapterItem.Ad -> newItem is OfferAdapterItem.Ad && oldItem.adItem.adId == newItem.adItem.adId
            }
        }

        override fun areContentsTheSame(oldItem: OfferAdapterItem, newItem: OfferAdapterItem): Boolean {
            return oldItem == newItem
        }
    }
}
