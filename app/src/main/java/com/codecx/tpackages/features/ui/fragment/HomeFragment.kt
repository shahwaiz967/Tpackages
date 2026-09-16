package com.codecx.tpackages.features.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codecx.tpackages.R
import com.codecx.tpackages.data.utils.safeNavigate
import com.codecx.tpackages.databinding.FragmentHomeBinding
import com.codecx.tpackages.features.base.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun binLayout(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.callOffers.setOnClickListener{
            safeNavigate(R.id.offerFragment, args = Bundle().apply {
                putInt(OfferFragment.PACKAGE_KEY, 1)
            })
        }
        binding.smsOffers.setOnClickListener {
            safeNavigate(R.id.offerFragment, args = Bundle().apply {
                putInt(OfferFragment.PACKAGE_KEY, 2)
            })
        }
        binding.internetOffers.setOnClickListener {
            safeNavigate(R.id.offerFragment, args = Bundle().apply {
                putInt(OfferFragment.PACKAGE_KEY, 3)
            })
        }
        binding.deviceOffers.setOnClickListener {
            safeNavigate(R.id.deviceFragment)
        }

    }

}