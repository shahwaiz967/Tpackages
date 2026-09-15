package com.codecx.tpackages.features.ui.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import com.codecx.tpackages.R
import com.codecx.tpackages.data.utils.safeNavigate
import com.codecx.tpackages.databinding.FragmentSplashBinding
import com.codecx.tpackages.features.base.BaseFragment


class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    private var progress = 0
    private var progressComplete = false
    override fun binLayout(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startAnimation()
    }

    private fun startAnimation(){
        val handler = Handler()
        val intervalMs = 6000L / 100

        val progressRunnable = object : Runnable {
            override fun run() {
                if (progress <= 100) {
                    binding.progressBar.progress = progress
                    progress++
                    handler.postDelayed(this, intervalMs)

                } else {
                    progressComplete = true
                    safeNavigate(R.id.homeFragment, navOptions = NavOptions.Builder().apply {
                        setPopUpTo(R.id.splashFragment, inclusive = true)
                    }.build())
                }
            }

        }

        handler.post(progressRunnable)
    }

}