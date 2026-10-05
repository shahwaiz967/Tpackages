package com.codecx.tpackages.features.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.codecx.tpackages.data.ads.utils.bindNative
import com.codecx.tpackages.data.utils.RemoteConfigHelper
import com.codecx.tpackages.databinding.FragmentSpeetTestBinding
import com.codecx.tpackages.features.base.BaseFragment
import com.codecx.tpackages.features.viewModel.SpeedTestViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Locale

class SpeedTestFragment : BaseFragment<FragmentSpeetTestBinding>() {
    private val viewModel : SpeedTestViewModel by viewModel()
    override fun binLayout(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSpeetTestBinding {
        return FragmentSpeetTestBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageView2.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnStartTest.setOnClickListener {
            viewModel.startSpeedTest()
        }
        observeViewModel()
        bindNative(
            RemoteConfigHelper.adIds.speedTestNative,
            false,
            binding.adBottomLayout
        )
    }

    private fun observeViewModel(){
        viewModel.currentSpeed.observe(viewLifecycleOwner) { speed ->
            binding.speedTestView.setValue(speed,true)
        }

        viewModel.downloadSpeed.observe(viewLifecycleOwner) { speed ->
            binding.txtDownloadSpeed.text = String.format(Locale.getDefault(), "%.1f", speed)
        }

        viewModel.uploadSpeed.observe(viewLifecycleOwner) { speed ->
            binding.textUploadSpeed.text = String.format(Locale.getDefault(), "%.1f", speed)
        }

        viewModel.isTesting.observe(viewLifecycleOwner) { isTesting ->
            binding.btnStartTest.isEnabled = !isTesting
            binding.btnStartTest.text = if (isTesting) "Testing..." else "Start Test"
        }
    }

}