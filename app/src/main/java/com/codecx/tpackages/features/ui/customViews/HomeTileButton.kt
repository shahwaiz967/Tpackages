package com.codecx.tpackages.features.ui.customViews

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import com.codecx.tpackages.R
import com.codecx.tpackages.data.utils.toDp
import com.codecx.tpackages.databinding.HomeTileItemBinding
import com.google.android.material.card.MaterialCardView

class HomeTileButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    private val binding: HomeTileItemBinding =
        HomeTileItemBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        cardElevation = 0f
        setCardBackgroundColor(Color.TRANSPARENT)
        radius = 24.toDp(context).toFloat()
        strokeWidth = 0

        context.withStyledAttributes(
            attrs,
            R.styleable.HomeTileButton,
            defStyleAttr,
            R.style.Theme_TPackages
        ) {
            binding.itemTitle.text = getString(R.styleable.HomeTileButton_tile_title)
            binding.itemDes.text = getString(R.styleable.HomeTileButton_tile_des)
            
            val iconResId = getResourceId(R.styleable.HomeTileButton_tile_icon, R.drawable.icon_call)
            binding.imageView.setImageResource(iconResId)

            val accentColor = getColor(
                R.styleable.HomeTileButton_tile_lip_color,
                ContextCompat.getColor(context, R.color.card_green_accent)
            )

            binding.imageView.imageTintList = ColorStateList.valueOf(accentColor)

            // Update the lip color in the background layer-list
            val background = binding.root.background
            if (background is LayerDrawable) {
                val shape = background.getDrawable(0) as? GradientDrawable
                shape?.setColor(accentColor)
            }

            val iconBgColor = getColor(
                R.styleable.HomeTileButton_tile_icon_background_color,
                ContextCompat.getColor(context, R.color.icon_bg_green_light)
            )
            binding.iconContainer.backgroundTintList = ColorStateList.valueOf(iconBgColor)
        }
    }
}
