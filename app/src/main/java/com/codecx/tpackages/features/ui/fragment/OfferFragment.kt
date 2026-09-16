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
import com.codecx.tpackages.data.utils.OfferPackages
import com.codecx.tpackages.data.utils.handleActivation
import com.codecx.tpackages.features.adapter.OffersAdapter
import kotlin.collections.forEach

class OfferFragment : BaseFragment<FragmentOfferBinding>() {

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
            else -> "Easy Card Offers"
        }
        setupTabs()
        updateTabs(
            selectedTab = binding.tvDaily,
            allTabs = listOf(binding.tvDaily, binding.tvWeekly, binding.tvMonthly)
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
                updateTabs(tab, tabsMapping.keys.toList())
                filterOffers(validity)
            }
        }
        filterOffers(1)
    }

    private fun filterOffers(validity: Int) {
        val filteredList = OfferPackages.getOffers(packageFor).filter { item ->
            item.validity == validity
        }
        offersAdapter.submitList(filteredList)
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