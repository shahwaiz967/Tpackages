package com.codecx.tpackages.features.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.codecx.tpackages.R
import com.codecx.tpackages.databinding.FragmentOfferBinding
import com.codecx.tpackages.features.base.BaseFragment


import androidx.recyclerview.widget.LinearLayoutManager
import com.codecx.tpackages.data.ads.googleads.InterstitialAdHelper
import com.codecx.tpackages.data.ads.utils.bindNative
import com.codecx.tpackages.data.ads.utils.showInter
import com.codecx.tpackages.data.utils.OfferPackages
import com.codecx.tpackages.data.utils.RemoteConfigHelper
import com.codecx.tpackages.data.utils.handleActivation
import com.codecx.tpackages.features.adapter.OffersAdapter
import kotlin.collections.forEach

class OfferFragment : BaseFragment<FragmentOfferBinding>() {
    private val interstitialHelper = InterstitialAdHelper.InterstitialHelper()

    companion object {
        const val PACKAGE_KEY = "package_key"
    }
    private val packageFor get() = arguments?.getInt(PACKAGE_KEY, 1) ?: 1


    private val offersAdapter by lazy {
        OffersAdapter { action, item ->
            val code = when (action) {
                OffersAdapter.Action.ACTIVATE -> item.activate
                OffersAdapter.Action.DEACTIVATE -> item.deactivate
                OffersAdapter.Action.STATUS -> item.status
            }
            code?.let { handleActivation(requireContext(), it) }
        }
    }

    override fun binLayout(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentOfferBinding {
        return FragmentOfferBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        binding.imageView2.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.textView.text = when(packageFor){
            1 -> "Call Offers"
            2 -> "SMS Offers"
            3 -> "Internet Offers"
            4 -> "All Top Offers"
            5 -> "Easy Card Offers"
            6 -> "All In One Offers"
            else -> "International Offers"
        }
        setupTabs()

        bindNative(
            RemoteConfigHelper.adIds.offerBanner,
            false,
            binding.adBottomLayout
        )
    }

    private fun setupRecyclerView() {
        binding.rvOffers.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = offersAdapter
        }
    }


    private fun setupTabs() {

         val tabsMapping = mapOf(
            binding.tvDaily to 1,
            binding.tvWeekly to 7,
            binding.tvMonthly to 30
        )
        tabsMapping.forEach { (tab, validity) ->
            tab.setOnClickListener {
                showInter(
                    interstitialHelper,
                    RemoteConfigHelper.adIds.offerInter.adId,
                    RemoteConfigHelper.adIds.offerInter.isAdEnable,
                    onDismiss = {
                        updateTabs(tab, tabsMapping.keys.toList())
                        filterOffers(validity)
                    },
                    onFail = {
                        updateTabs(tab, tabsMapping.keys.toList())
                        filterOffers(validity)
                    }
                )
            }
                /*tab.setOnClickListener {
                    updateTabs(tab, tabsMapping.keys.toList())
                    filterOffers(validity)
                }*/
        }

        // Auto-select the first tab that actually has offers
        val allOffers = OfferPackages.getOffers(packageFor)
        val defaultTabEntry = tabsMapping.entries.firstOrNull { (_, validity) ->
            allOffers.any { it.validity == validity }
        } ?: tabsMapping.entries.first()

        updateTabs(defaultTabEntry.key, tabsMapping.keys.toList())
        filterOffers(defaultTabEntry.value)
    }

    private fun filterOffers(validity: Int) {
        val filteredList = OfferPackages.getOffers(packageFor).filter { item ->
            item.validity == validity
        }
        offersAdapter.submitOffers(filteredList)
        binding.tvNoOffers.visibility = if (filteredList.isEmpty()) View.VISIBLE else View.GONE
    }
    private fun updateTabs(selectedTab: TextView, allTabs: List<TextView>) {
        allTabs.forEach { tab ->
            if (tab.id == selectedTab.id) {
                tab.setBackgroundResource(R.drawable.bg_tab_selected)
                tab.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            } else {
                tab.background = null
                tab.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            }
        }
    }

}