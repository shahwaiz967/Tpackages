package com.codecx.tpackages.features.ui.customViews

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.withStyledAttributes
import androidx.core.graphics.toColorInt
import com.codecx.tpackages.R
import com.codecx.tpackages.databinding.ItemHomeThirldBinding
import com.google.android.material.card.MaterialCardView

class HomeQuickToolButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(
    context,
    attrs,
    defStyleAttr
) {

    private val binding: ItemHomeThirldBinding =
        ItemHomeThirldBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        orientation = VERTICAL

        context.withStyledAttributes(
            attrs,
            R.styleable.HomeQuickToolButton,
            defStyleAttr,
            R.style.Theme_TPackages
        ) {
            binding.title.text = getString(R.styleable.HomeQuickToolButton_title)
            binding.icon.setImageResource(
                getResourceId(
                    R.styleable.HomeQuickToolButton_icon,
                    R.drawable.ic_balance_check
                )
            )
            binding.iconContainer.strokeColor =
                getColor(R.styleable.HomeQuickToolButton_strokeColor, "#BAE6FD99".toColorInt())

            val startColor =
                getColor(R.styleable.HomeQuickToolButton_startColor, "#F0F9FF".toColorInt())
            val endColor =
                getColor(R.styleable.HomeQuickToolButton_endColor, "#DBEAFEB3".toColorInt())

            val gradientDrawable = GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(startColor, endColor)
            )

            binding.gradientBackground.background = gradientDrawable
        }

    }
}

