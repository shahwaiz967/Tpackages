package com.codecx.tpackages.features.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.codecx.tpackages.R
import com.codecx.tpackages.data.ads.utils.bindNative
import com.codecx.tpackages.data.utils.OfferPackages
import com.codecx.tpackages.data.utils.RemoteConfigHelper
import com.codecx.tpackages.databinding.FragmentQuickToolsBinding
import com.codecx.tpackages.features.adapter.DevicePackageAdapter
import com.codecx.tpackages.features.base.BaseFragment
import com.codecx.tpackages.features.ui.fragment.OfferFragment.Companion.PACKAGE_KEY

class QuickToolsFragment : BaseFragment<FragmentQuickToolsBinding>() {
    companion object {
        const val QUICK_TOOL_KEY = "quick_tool_keya"
    }

    private val toolAdapter by lazy {
        DevicePackageAdapter()
    }

    private val quickTool get() = arguments?.getInt(QUICK_TOOL_KEY, 1) ?: 1
    override fun binLayout(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentQuickToolsBinding {
        return FragmentQuickToolsBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageView2.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.textView.text = when(quickTool){
            1 -> "Balance Check"
            2 -> "Advance Balance"
            3 -> "MB Check"
            else -> "Free MB"
        }

        binding.rvQuickTool.layoutManager = LinearLayoutManager(requireContext())
        binding.rvQuickTool.adapter = toolAdapter

       toolAdapter.submitList(OfferPackages.getQuickTools(quickTool))

        bindNative(
            RemoteConfigHelper.adIds.quickToolNative,
            false,
            binding.adBottomLayout
        )
    }

}