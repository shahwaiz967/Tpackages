package com.codecx.tpackages.features.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.fadeIn
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.codecx.tpackages.R
import com.codecx.tpackages.data.utils.OfferPackages
import com.codecx.tpackages.databinding.FragmentDeviceBinding
import com.codecx.tpackages.features.adapter.DevicePackageAdapter
import com.codecx.tpackages.features.base.BaseFragment


class DeviceFragment : BaseFragment<FragmentDeviceBinding>() {
    private val adapter by lazy {
        DevicePackageAdapter()
    }
    override fun binLayout(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentDeviceBinding {
        return FragmentDeviceBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageView2.setOnClickListener {
            findNavController().popBackStack()
        }

        adapter.submitList(OfferPackages.deviceOffers())
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

}