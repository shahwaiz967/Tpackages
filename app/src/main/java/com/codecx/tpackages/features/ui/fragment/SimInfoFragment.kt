package com.codecx.tpackages.features.ui.fragment

import android.Manifest
import android.content.Context.TELEPHONY_SUBSCRIPTION_SERVICE
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.telephony.SubscriptionInfo
import android.telephony.SubscriptionManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.codecx.tpackages.R
import com.codecx.tpackages.databinding.FragmentSimInfoBinding
import com.codecx.tpackages.features.base.BaseFragment

class SimInfoFragment : BaseFragment<FragmentSimInfoBinding>() {
    private val phoneStatePermissionCode = 101
    override fun binLayout(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSimInfoBinding {
        return FragmentSimInfoBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageView2.setOnClickListener {
            findNavController().popBackStack()
        }
        checkPermission()
    }

    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_PHONE_STATE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.READ_PHONE_STATE),
                phoneStatePermissionCode
            )
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                getSimDetails()
            }
        }
    }

    private fun getSimDetails() {

        try {
            val subscriptionManager =
                requireContext().getSystemService(TELEPHONY_SUBSCRIPTION_SERVICE) as SubscriptionManager

            var sim1Loaded = false
            var sim2Loaded = false

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                if (ContextCompat.checkSelfPermission(
                        requireContext(),
                        Manifest.permission.READ_PHONE_STATE
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    val subscriptionInfoList: List<SubscriptionInfo>? =
                        subscriptionManager.activeSubscriptionInfoList
                    if (subscriptionInfoList != null) {
                        for (subscriptionInfo in subscriptionInfoList) {
                            val carrierName = subscriptionInfo.carrierName.toString()
                            val displayName = subscriptionInfo.displayName.toString()
                            val countryIso = subscriptionInfo.countryIso.toString()
                            val mnc = subscriptionInfo.mnc.toString()
                            val slotIndex = subscriptionInfo.simSlotIndex
                            when (slotIndex) {
                                0 -> { // SIM one
                                    sim1Loaded = true
                                    binding.tvCarrierName.text = carrierName
                                    binding.tvDisplayName.text = displayName
                                    binding.tvCountryCode.text = countryIso
                                    binding.tvMNC.text = mnc

                                }

                                1 -> { // SIM two
                                    sim2Loaded = true
                                    binding.sim2Card.visibility = View.VISIBLE
                                    binding.tvCarrierName2.text = carrierName
                                    binding.tvDisplayName2.text = displayName
                                    binding.tvCountryCode2.text = countryIso
                                    binding.tvMNC2.text = mnc
                                }
                            }
                        }
                    }
                } else {
                    println("Permission not granted")
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == phoneStatePermissionCode && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            getSimDetails()
        }
    }

}