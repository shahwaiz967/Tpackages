package com.codecx.tpackages.features.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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
    }

}