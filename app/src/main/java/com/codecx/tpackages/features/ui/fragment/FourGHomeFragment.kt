package com.codecx.tpackages.features.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.codecx.tpackages.R
import com.codecx.tpackages.data.utils.safeNavigate
import com.codecx.tpackages.databinding.FragmentFougHomeBinding
import com.codecx.tpackages.features.base.BaseFragment

class FourGHomeFragment : BaseFragment<FragmentFougHomeBinding>() {
    override fun binLayout(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentFougHomeBinding {
        return FragmentFougHomeBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageView2.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.simSignalStrength.setOnClickListener {
            safeNavigate(R.id.simSignalFragment)
        }
        binding.simInfo.setOnClickListener {
            safeNavigate(R.id.simInfoFragment)
        }
        binding.dataUsage.setOnClickListener {
            safeNavigate(R.id.dataUsageFragment)
        }
        binding.btnLTESetting.setOnClickListener {
            safeNavigate(R.id.lteSettingFragment)
        }

    }

}