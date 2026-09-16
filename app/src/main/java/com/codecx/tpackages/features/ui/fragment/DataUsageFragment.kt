package com.codecx.tpackages.features.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.codecx.tpackages.R
import com.codecx.tpackages.databinding.FragmentDataUsageBinding
import com.codecx.tpackages.features.adapter.DataUsageAdapter
import com.codecx.tpackages.features.base.BaseFragment
import com.codecx.tpackages.features.viewModel.DataUsageViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class DataUsageFragment : BaseFragment<FragmentDataUsageBinding>() {
    private val viewModel: DataUsageViewModel by viewModel()
    private val adapter by lazy { DataUsageAdapter(emptyList()) }
    override fun binLayout(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentDataUsageBinding {
        return FragmentDataUsageBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        viewModel.dataUsage.observe( viewLifecycleOwner) { list ->
            adapter.updateList(list)
            val totalMobileData = list.sumOf{it.mobileData}
            val totalWifiData = list.sumOf { it.wifiData }
            binding.tvTotalMobile.text = "$totalMobileData MB"
            binding.tvTotalWifi.text = "$totalWifiData MB"
        }
        viewModel.fetchDataUsage()
    }

}