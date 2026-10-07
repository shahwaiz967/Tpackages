package com.codecx.tpackages.features.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.codecx.tpackages.R
import com.codecx.tpackages.data.ads.googleads.InterstitialAdHelper
import com.codecx.tpackages.data.ads.utils.bindNative
import com.codecx.tpackages.data.ads.utils.showInter
import com.codecx.tpackages.data.utils.RemoteConfigHelper
import com.codecx.tpackages.data.utils.safeNavigate
import com.codecx.tpackages.databinding.FragmentFougHomeBinding
import com.codecx.tpackages.features.base.BaseFragment

class FourGHomeFragment : BaseFragment<FragmentFougHomeBinding>() {
    private val interstitialHelper = InterstitialAdHelper.InterstitialHelper()
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
            showInterstitial {

                safeNavigate(R.id.simSignalFragment)
            }

        }
        binding.simInfo.setOnClickListener {
            showInterstitial {

                safeNavigate(R.id.simInfoFragment)
            }
        }
        binding.dataUsage.setOnClickListener {

            showInterstitial {
                safeNavigate(R.id.dataUsageFragment)
            }
        }
        binding.btnLTESetting.setOnClickListener {
            showInterstitial {

                safeNavigate(R.id.lteSettingFragment)
            }
        }
        binding.speedTest.setOnClickListener {
            showInterstitial {

                safeNavigate(R.id.speedTestFragment)
            }
        }
        bindNative(
            RemoteConfigHelper.adIds.fourGNative,
            false,
            binding.adBottomLayout
        )

    }

    private fun showInterstitial(onDone: () -> Unit){
        showInter(
            interstitialHelper,
            RemoteConfigHelper.adIds.fourGInter.adId,
            RemoteConfigHelper.adIds.fourGInter.isAdEnable,
            onDismiss ={
                onDone()
            },
            onFail = {
                onDone()
            }
        )
    }

}