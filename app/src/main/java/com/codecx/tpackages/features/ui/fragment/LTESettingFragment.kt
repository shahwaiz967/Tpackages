package com.codecx.tpackages.features.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.codecx.tpackages.databinding.FragmentLTESettingBinding
import com.codecx.tpackages.features.base.BaseFragment
import com.codecx.tpackages.features.viewModel.FourGOnlyViewModel
import com.codecx.tpackages.features.viewModel.SpeedUiState
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LTESettingFragment : BaseFragment<FragmentLTESettingBinding>() {
    private val viewModel: FourGOnlyViewModel by viewModel()
    override fun binLayout(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentLTESettingBinding {
        return FragmentLTESettingBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        viewModel.toggleOrStartMonitoring()

        binding.cvBelowAndroid.setOnClickListener {
            openRadioInfo()
        }
        binding.cvAboveAndroid.setOnClickListener {
            openRadioInfo()
        }
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    renderUiState(state)
                }
            }
        }
    }

    private fun renderUiState(state: SpeedUiState) {
        binding.incomingSpeed.text = state.incomingSpeed
        binding.outGoingSpeed.text = state.outgoingSpeed
    }

    private fun openRadioInfo() {
        try {
            val intent = Intent("android.intent.action.MAIN")
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.setClassName("com.android.settings", "com.android.settings.RadioInfo")
            startActivity(intent)
            return
        } catch (e: Exception) {
            try {
                val intent = Intent("android.intent.action.MAIN")
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.setClassName("com.android.phone", "com.android.phone.settings.RadioInfo")
                startActivity(intent)
                return
            } catch (e2: Exception) {
                Toast.makeText(
                    requireContext(),
                    "Sorry! It seems your device doesn't support direct radio info settings",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}