package com.codecx.tpackages.features.ui.customViews

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.core.content.withStyledAttributes
import com.codecx.tpackages.R
import com.codecx.tpackages.databinding.LayoutOfferGridItemBinding
import com.google.android.material.card.MaterialCardView

class OfferGridItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    private val binding: LayoutOfferGridItemBinding =
        LayoutOfferGridItemBinding.inflate(LayoutInflater.from(context), this)

    init {
        cardElevation = 0f
        radius = context.resources.getDimension(com.intuit.sdp.R.dimen._10sdp)
        strokeWidth = context.resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._1sdp)

        context.withStyledAttributes(attrs, R.styleable.OfferGridItem, defStyleAttr, 0) {
            binding.tvLabel.text = getString(R.styleable.OfferGridItem_grid_label)
            binding.tvValue.text = getString(R.styleable.OfferGridItem_grid_value)
            
            val bgColor = getColor(R.styleable.OfferGridItem_grid_bg_color, Color.WHITE)
            setCardBackgroundColor(bgColor)
            
            val strokeCol = getColor(R.styleable.OfferGridItem_grid_stroke_color, Color.TRANSPARENT)
            strokeColor = strokeCol
        }
    }
    
    fun setLabel(label: String) {
        binding.tvLabel.text = label
    }
    
    fun setValue(value: String) {
        binding.tvValue.text = value
    }
}
