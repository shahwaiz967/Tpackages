package com.codecx.tpackages.features.ui.fragment

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.telephony.CellInfoGsm
import android.telephony.CellInfoLte
import android.telephony.CellInfoNr
import android.telephony.CellInfoWcdma
import android.telephony.CellSignalStrengthNr
import android.telephony.SubscriptionInfo
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresPermission
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.codecx.tpackages.R
import com.codecx.tpackages.databinding.FragmentSimSignalStrengthBinding
import com.codecx.tpackages.features.base.BaseFragment


class SimSignalStrengthFragment : BaseFragment<FragmentSimSignalStrengthBinding>() {
    override fun binLayout(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSimSignalStrengthBinding {
        return FragmentSimSignalStrengthBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView.text = Html.fromHtml(getString(R.string.signal_strength_of_sim), Html.FROM_HTML_MODE_LEGACY)

        binding.imageView2.setOnClickListener {
            findNavController().popBackStack()
        }
        checkAndRequestPermissions()

    }

    private val permissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions())
        { permissions ->
            val phoneGranted =
                permissions[Manifest.permission.READ_PHONE_STATE] == true

            val locationGranted =
                permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
                        permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true

            if (phoneGranted && locationGranted) {

                loadSimSignalData()
            } else {
                loadSimSignalData()
            }
        }

    private fun checkAndRequestPermissions() {

        val permissionsToRequest = mutableListOf<String>()

        // READ_PHONE_STATE
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_PHONE_STATE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            permissionsToRequest.add(Manifest.permission.READ_PHONE_STATE)
        }

        // Location permission is required to get CellInfo
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            permissionsToRequest.add(Manifest.permission.ACCESS_FINE_LOCATION)
            permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }

        if (permissionsToRequest.isNotEmpty()) {
            permissionLauncher.launch(permissionsToRequest.toTypedArray())
        } else {
            // Already granted
            loadSimSignalData()
        }
    }

    private fun loadSimSignalData() {
        val hasPhonePermission = ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.READ_PHONE_STATE
        ) == PackageManager.PERMISSION_GRANTED

        val hasLocationPermission = ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        var sim1Loaded = false
        var sim2Loaded = false

        if (hasPhonePermission) {
            try {
                val subscriptionManager = requireContext().getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE) as? SubscriptionManager
                val subList: List<SubscriptionInfo>? = subscriptionManager?.activeSubscriptionInfoList

                if (!subList.isNullOrEmpty()) {
                    for (sub in subList) {
                        val slotIndex = sub.simSlotIndex
                        val carrierName = sub.carrierName?.toString()?.takeIf { it.isNotBlank() }
                            ?: sub.displayName?.toString()?.takeIf { it.isNotBlank() }
                            ?: getString(R.string.ufone)

                        val signalDbm = getSignalDbm(sub.subscriptionId, hasLocationPermission) ?: -102
                        val asuOrValue = calculateGaugeValue(signalDbm)

                        if (slotIndex == 0) {
                            sim1Loaded = true
                            binding.simName.text = getString(R.string.sim_1_, carrierName)
                            binding.simSignalStrength.text =
                                getString(R.string.signal_strength_dbm, signalDbm)
                            binding.sim1GaugeView.setActive(true)
                            binding.sim1GaugeView.setValue(
                                value = asuOrValue,
                                text = String.format(java.util.Locale.US, "%.3f", asuOrValue),
                                animated = true
                            )
                        } else if (slotIndex == 1) {
                            sim2Loaded = true
                            binding.sim2Name.text = getString(R.string.sim_2_, carrierName)
                            binding.sim2SignalStrength.text = getString(R.string.signal_strength_dbm, signalDbm)
                            binding.sim2GaugeView.setActive(true)
                            binding.sim2GaugeView.setValue(
                                value = asuOrValue,
                                text = String.format(java.util.Locale.US, "%.3f", asuOrValue),
                                animated = true
                            )
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        // Fallback default states if not loaded from real hardware (matches provided design)
        if (!sim1Loaded) {
            binding.simName.text = getString(R.string.sim_1)
            binding.simSignalStrength.text = getString(R.string.no_sim_available)
            binding.sim1GaugeView.setActive(false)
            binding.sim1GaugeView.setValue(
                value = 0f,
                text = "0.000",
                animated = false
            )
        }

        if (!sim2Loaded) {

            binding.sim2Name.text = getString(R.string.sim_2)
            binding.sim2SignalStrength.text = getString(R.string.no_sim_available)
            binding.sim2GaugeView.setActive(false)
            binding.sim2GaugeView.setValue(
                value = 0f,
                text = "0.000",
                animated = false
            )
        }
    }

    @RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    private fun getSignalDbm(subId: Int, hasLocationPermission: Boolean): Int? {
        try {
            val telephonyManager = requireContext().getSystemService(Context.TELEPHONY_SERVICE) as? TelephonyManager
            val subTelephony = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && subId != SubscriptionManager.INVALID_SUBSCRIPTION_ID) {
                telephonyManager?.createForSubscriptionId(subId) ?: telephonyManager
            } else {
                telephonyManager
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val signalStrength = subTelephony?.signalStrength
                if (signalStrength != null) {
                    val cellSignals = signalStrength.cellSignalStrengths
                    for (cell in cellSignals) {
                        val dbm = cell.dbm
                        if (dbm in -150..-30) {
                            return dbm
                        }
                    }
                }
            }

            if (hasLocationPermission) {
                val cellInfos = subTelephony?.allCellInfo
                if (!cellInfos.isNullOrEmpty()) {
                    for (cell in cellInfos) {
                        if (cell.isRegistered) {
                            when (cell) {
                                is CellInfoLte -> return cell.cellSignalStrength.dbm
                                is CellInfoGsm -> return cell.cellSignalStrength.dbm
                                is CellInfoWcdma -> return cell.cellSignalStrength.dbm
                                else -> {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && cell is CellInfoNr) {
                                        return (cell.cellSignalStrength as? CellSignalStrengthNr)?.dbm
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    private fun calculateGaugeValue(dbm: Int): Float {
        // Map dBm (-120 dBm to -60 dBm) to gauge scale (0 to 100) or default to 15.0f
        return if (dbm < 0) {
            val normalized = ((dbm - (-120)) / (-60f - (-120f)) * 100f).coerceIn(0f, 100f)
            if (normalized > 0f) normalized else 15.0f
        } else {
            15.0f
        }
    }

}