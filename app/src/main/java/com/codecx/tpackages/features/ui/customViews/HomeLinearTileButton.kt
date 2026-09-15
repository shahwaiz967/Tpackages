package com.codecx.tpackages.features.ui.customViews

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.core.content.withStyledAttributes
import androidx.core.graphics.toColorInt
import com.codecx.tpackages.R

import com.codecx.tpackages.data.utils.toDp
import com.codecx.tpackages.databinding.ItemHomeSecondBinding
import com.google.android.material.card.MaterialCardView

class HomeLinearTileButton @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : MaterialCardView(context, attrs, defStyleAttr) {

        private val binding : ItemHomeSecondBinding =
            ItemHomeSecondBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        cardElevation = 0f
        setCardBackgroundColor(Color.WHITE)
        strokeWidth = 0
        radius = 16.toDp(context).toFloat()

        context.withStyledAttributes(
            attrs,
            R.styleable.HomeLinearTileButton,
            defStyleAttr,
            R.style.Theme_TPackages
        ){
            binding.tvTitle.text = getString(R.styleable.HomeLinearTileButton_linear_tile_title)
            binding.ivMainIcon.setImageResource(getResourceId(R.styleable.HomeLinearTileButton_linear_tile_icon,
                R.drawable.ic_alltop))
            
            if (hasValue(R.styleable.HomeLinearTileButton_icon_tint)) {
                val iconTint = getColor(R.styleable.HomeLinearTileButton_icon_tint, Color.WHITE)
                binding.ivMainIcon.imageTintList = ColorStateList.valueOf(iconTint)
            }

            val startColor = getColor(R.styleable.HomeLinearTileButton_tile_StartColor, "#D946EF".toColorInt())
            val endColor = getColor(R.styleable.HomeLinearTileButton_tile_EndColor,"#EC4899".toColorInt())
            val angle = getInteger(R.styleable.HomeLinearTileButton_tile_angle, GradientDrawable.Orientation.TOP_BOTTOM.ordinal)

            val gradientDrawable =
                GradientDrawable(
                    GradientDrawable.Orientation.values()[angle],
                    intArrayOf(startColor, endColor)
                )
            binding.vGradientBackground.background = gradientDrawable
        }
    }
}