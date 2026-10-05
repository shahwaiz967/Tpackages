package com.codecx.tpackages.features.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codecx.tpackages.R
import com.codecx.tpackages.data.ads.googleads.InterstitialAdHelper
import com.codecx.tpackages.data.ads.utils.bindNative
import com.codecx.tpackages.data.ads.utils.showInter
import com.codecx.tpackages.data.ads.utils.showInterWithCounter
import com.codecx.tpackages.data.utils.RemoteConfigHelper
import com.codecx.tpackages.data.utils.safeNavigate
import com.codecx.tpackages.databinding.FragmentHomeBinding
import com.codecx.tpackages.features.base.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val interstitialHelper = InterstitialAdHelper.InterstitialHelper()
    private var isFirstAction = false
    override fun binLayout(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadAds()

        binding.callOffers.setOnClickListener{
            showInterstitial {

                safeNavigate(R.id.offerFragment, args = Bundle().apply {
                    putInt(OfferFragment.PACKAGE_KEY, 1)
                })
            }
        }
        binding.smsOffers.setOnClickListener {
            showInterstitial {

                safeNavigate(R.id.offerFragment, args = Bundle().apply {
                    putInt(OfferFragment.PACKAGE_KEY, 2)
                })
            }
        }
        binding.internetOffers.setOnClickListener {
            showInterstitial {

                safeNavigate(R.id.offerFragment, args = Bundle().apply {
                    putInt(OfferFragment.PACKAGE_KEY, 3)
                })
            }
        }
        binding.allTopOffers.setOnClickListener {
            showInterstitial {

                safeNavigate(R.id.offerFragment, args = Bundle().apply {
                    putInt(OfferFragment.PACKAGE_KEY, 4)
                })
            }
        }
        binding.easyCardOffers.setOnClickListener {
            showInterstitial {

                safeNavigate(R.id.offerFragment, args = Bundle().apply {
                    putInt(OfferFragment.PACKAGE_KEY, 5)
                })
            }
        }
        binding.allInOneBtn.setOnClickListener {
            showInterstitial {

                safeNavigate(R.id.offerFragment, args = Bundle().apply {
                    putInt(OfferFragment.PACKAGE_KEY, 6)
                })
            }
        }
        binding.internationalOffers.setOnClickListener {
            showInterstitial {

                safeNavigate(R.id.offerFragment, args = Bundle().apply {
                    putInt(OfferFragment.PACKAGE_KEY, 7)
                })
            }
        }
        binding.deviceOffers.setOnClickListener {
            showInterstitial {

                safeNavigate(R.id.deviceFragment)
            }
        }

        binding.enjoyFourGInternet.setOnClickListener {
            showInterstitial {

                safeNavigate(R.id.fourGHomeFragment)
            }
        }

        binding.balanceCheckBtn.setOnClickListener {
            showInterstitial {

                safeNavigate(R.id.quickToolFragment, args = Bundle().apply {
                    putInt(QuickToolsFragment.QUICK_TOOL_KEY, 1)
                })
            }
        }

        binding.advanceBalanceBtn.setOnClickListener {
            showInterstitial {

                safeNavigate(R.id.quickToolFragment, args = Bundle().apply {
                    putInt(QuickToolsFragment.QUICK_TOOL_KEY, 2)
                })
            }
        }
        binding.mbCheckBtn.setOnClickListener {
            showInterstitial {

                safeNavigate(R.id.quickToolFragment, args = Bundle().apply {
                    putInt(QuickToolsFragment.QUICK_TOOL_KEY, 3)
                })
            }
        }
        binding.freeMbBtn.setOnClickListener {
            showInterstitial {

                safeNavigate(R.id.quickToolFragment, args = Bundle().apply {
                    putInt(QuickToolsFragment.QUICK_TOOL_KEY, 4)
                })
            }
        }

    }

    private fun loadAds(){
        bindNative(
            RemoteConfigHelper.adIds.homeTopNative,
            false,
            binding.adTopLayout
        )
        bindNative(
            RemoteConfigHelper.adIds.homeBottomBanner,
            false,
            binding.adBottomLayout
        )
    }

    private fun showInterstitial(onAction: () -> Unit) {
        if (!isFirstAction&& RemoteConfigHelper.adIds.homeFirstClick){
            isFirstAction = true
            showInter(
                interstitialHelper = interstitialHelper,
                stringId = RemoteConfigHelper.adIds.homeInter.adId,
                adAllowed = RemoteConfigHelper.adIds.homeInter.isAdEnable,
                onDismiss = onAction,
                onFail = onAction
            )
        }else{
            showInterWithCounter(
                interstitialHelper = interstitialHelper,
                adItem = RemoteConfigHelper.adIds.homeInter,
                onComplete = onAction
            )
        }
    }

}