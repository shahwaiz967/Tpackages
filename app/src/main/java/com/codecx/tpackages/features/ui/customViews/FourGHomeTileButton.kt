package com.codecx.tpackages.features.ui.customViews

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.core.content.withStyledAttributes
import androidx.core.graphics.toColorInt
import com.codecx.tpackages.R
import com.codecx.tpackages.data.utils.toDp
import com.codecx.tpackages.databinding.FourgHomeTileItemBinding
import com.google.android.material.card.MaterialCardView

class FourGHomeTileButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {
    private val binding : FourgHomeTileItemBinding =
        FourgHomeTileItemBinding.inflate(LayoutInflater.from(context), this, true)

    init {

        cardElevation = 0f
        setCardBackgroundColor(Color.TRANSPARENT)
        strokeWidth = 2.toDp(context)
        radius = 24.toDp(context).toFloat()
        context.withStyledAttributes(
            attrs,
            R.styleable.FourGHomeTileButton,
            defStyleAttr,
            R.style.Theme_TPackages
        ) {
            binding.itemTitle.text = getString(R.styleable.FourGHomeTileButton_fourG_title)
            binding.itemDes.text = getString(R.styleable.FourGHomeTileButton_fourG_des)
            binding.imageView.setImageResource(
                getResourceId(
                    R.styleable.FourGHomeTileButton_fourG_icon,
                    R.drawable.icon_signal_strength
                )
            )
            val sColor = getColor(R.styleable.FourGHomeTileButton_fourG_strokeColor, "#FCE7F3".toColorInt())
            setStrokeColor(ColorStateList.valueOf(sColor))

            val iconBackColour = getColor(R.styleable.FourGHomeTileButton_icon_background_color, Color.WHITE)
            binding.imageView.backgroundTintList = ColorStateList.valueOf(iconBackColour)


            val backColor = getColor(R.styleable.FourGHomeTileButton_fourG_backColor, Color.WHITE)
            binding.root.backgroundTintList = ColorStateList.valueOf(backColor)

            val arrowBackColor = getColor(R.styleable.FourGHomeTileButton_arrow_back_color, 0)
            binding.arrowContainer.backgroundTintList = ColorStateList.valueOf(arrowBackColor)

            val arrowColor = getColor(R.styleable.FourGHomeTileButton_arrow_color,0)
            binding.arrowContainer.foregroundTintList = ColorStateList.valueOf(arrowColor)
        }
    }
}