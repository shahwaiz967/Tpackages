package com.codecx.tpackages.features.ui.customViews

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.graphics.SweepGradient
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.core.content.res.ResourcesCompat
import com.codecx.tpackages.R
import java.util.Locale
import kotlin.math.cos
import kotlin.math.sin

class SpeedTestSpeedView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    // --- Variables Configuration ---
    private var currentValue: Float = 0.0f      // Final target speed value
    private var animatedValue: Float = 0.0f    // Current value jab animation chal rahi ho
    private var minValue: Float = 0f           // Gauge ki minimum speed limit
    private var maxValue: Float = 100.0f       // Gauge ki maximum speed limit

    // Gauge Semi-Circle (270 Degrees) angles
    private val startAngle: Float = 144f       // Bottom-left start
    private val sweepAngle: Float = 253f // 270 degree sweep


    private var animator: ValueAnimator? = null
    private var customTypeface: Typeface? = null

    // --- Paint Objects (Paints draw karne mein madad karte hain) ---

    // Main multi-color Gradient Arc paint
    private val arcPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE            // Sirf border draw karega, solid fill nahi
        strokeCap = Paint.Cap.ROUND           // Ends rounded hongay
    }

    // Arc ko sections me divide karne wali white gap lines
    private val gapPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
        color = Color.WHITE
    }

    // Blue Needle (Sui) paint
    private val needlePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.parseColor("#007AFF")    // Bright Blue
    }

    // Center Pivot: Outer light gray ring
    private val outerPivotPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.parseColor("#E9EFF5")
    }

    // Center Pivot: Inner dark gray circle
    private val innerPivotPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.parseColor("#212121")
    }

    // Speed digits text ("0.0") paint
    private val speedValuePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        textAlign = Paint.Align.CENTER
    }

    // "Mbps" sub-text paint
    private val unitTextPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#9E9E9E")
        textAlign = Paint.Align.CENTER
    }

    // Bottom labels ("0" & "100") paint
    private val labelTextPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#424242")
        textAlign = Paint.Align.CENTER
    }

    private val needlePath = Path()
    private val arcBounds = RectF()

    init {
        // Custom font load karne ki koshish (Fallback to system bold font)
        customTypeface = try {
            ResourcesCompat.getFont(context, R.font.plus_jakarta_sans_bold)
        } catch (_: Exception) {
            Typeface.DEFAULT_BOLD
        }

        val tf = customTypeface ?: Typeface.DEFAULT_BOLD
        speedValuePaint.typeface = tf
        unitTextPaint.typeface = Typeface.DEFAULT_BOLD
        labelTextPaint.typeface = tf
    }

    // External function: Jab aap speed pass kareinge (e.g. `speedView.setValue(45.5f)`)
    fun setValue(value: Float, animated: Boolean = true) {
        currentValue = value.coerceIn(minValue, maxValue) // Range check 0 se 100 tak

        if (animated) {
            // Smooth Animation logic
            animator?.cancel()
            animator = ValueAnimator.ofFloat(animatedValue, currentValue).apply {
                duration = 800 // Animation duration (ms)
                interpolator = DecelerateInterpolator(1.5f) // Smooth slowing end effect
                addUpdateListener {
                    this@SpeedTestSpeedView.animatedValue = it.animatedValue as Float
                    invalidate() // View ko dubara redraw karne ki command (onDraw call hota hai)
                }
                start()
            }
        } else {
            animatedValue = currentValue
            invalidate()
        }
    }

    // View ka size measure karna
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val size = if (width > 0) width else dpToPx(280f).toInt()
        val height = (size * 0.9f).toInt() // Adjusted for 270 degree arc
        setMeasuredDimension(size, height)
    }

    // --- Main Drawing Area ---
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = width.toFloat()
        val height = height.toFloat()
        val cx = width / 2f
        val cy = height * 0.48f               // Adjusted Center
        val radius = width * 0.36f            // Gauge Arc Radius

        val strokeWidth = dpToPx(38f)
        arcPaint.strokeWidth = strokeWidth
        gapPaint.strokeWidth = dpToPx(3f)

        // STEP 1: Gradient Colors Setup (Vibrant Gradient)
        val colors = intArrayOf(
            Color.parseColor("#00C853"), // Vibrant Green
            Color.parseColor("#64DD17"), // Light Green
            Color.parseColor("#FFD600"), // Yellow
            Color.parseColor("#FF6D00"), // Orange
            Color.parseColor("#FF1744"), // Red
            Color.parseColor("#00C853")  // Green (Added to fix red color at the start due to rounded cap)
        )
        // Adjust positions: last color (Green) at 1.0f ensures the rounded cap at start is Green
        val colorPositions = floatArrayOf(0f, 0.12f, 0.28f, 0.45f, 0.65f, 1.0f)
        val gradient = SweepGradient(cx, cy, colors, colorPositions)

        val matrix = android.graphics.Matrix()
        matrix.postRotate(startAngle, cx, cy)
        gradient.setLocalMatrix(matrix)
        arcPaint.shader = gradient

        // STEP 2: Main Arc Draw
        arcBounds.set(cx - radius, cy - radius, cx + radius, cy + radius)
        canvas.drawArc(arcBounds, startAngle, sweepAngle, false, arcPaint)
        arcPaint.shader = null

        // STEP 3: Divider Lines
        // STEP 3: Divider Lines
        val segments = 8

// Arc stroke ke center se line ki length control karne ke liye
        val tickInnerRadius = radius - strokeWidth / 5f + dpToPx(2f)
        val tickOuterRadius = radius + strokeWidth / 2f - dpToPx(2f)

        for (i in 1 until segments) {

            val angleDeg =
                startAngle + (i.toFloat() / segments) * sweepAngle

            val angleRad =
                Math.toRadians(angleDeg.toDouble())

            val x1 =
                (cx + tickInnerRadius * cos(angleRad)).toFloat()

            val y1 =
                (cy + tickInnerRadius * sin(angleRad)).toFloat()

            val x2 =
                (cx + tickOuterRadius * cos(angleRad)).toFloat()

            val y2 =
                (cy + tickOuterRadius * sin(angleRad)).toFloat()

            canvas.drawLine(
                x1,
                y1,
                x2,
                y2,
                gapPaint
            )
        }

        // STEP 4: Needle Angle
        val fraction = ((animatedValue - minValue) / (maxValue - minValue)).coerceIn(0f, 1f)
        val needleAngleDeg = startAngle + fraction * sweepAngle
        val needleAngleRad = Math.toRadians(needleAngleDeg.toDouble())

        // STEP 5: Needle Draw
        val needleLength = radius - strokeWidth / 2f - dpToPx(4f)
        val baseWidth = dpToPx(12f)

        val perpRad1 = needleAngleRad + Math.PI / 2.0
        val perpRad2 = needleAngleRad - Math.PI / 2.0

        val b1x = (cx + baseWidth * cos(perpRad1)).toFloat()
        val b1y = (cy + baseWidth * sin(perpRad1)).toFloat()
        val b2x = (cx + baseWidth * cos(perpRad2)).toFloat()
        val b2y = (cy + baseWidth * sin(perpRad2)).toFloat()

        val tipX = (cx + needleLength * cos(needleAngleRad)).toFloat()
        val tipY = (cy + needleLength * sin(needleAngleRad)).toFloat()

        needlePath.reset()
        needlePath.moveTo(b1x, b1y)
        needlePath.lineTo(tipX, tipY)
        needlePath.lineTo(b2x, b2y)
        needlePath.close()

        canvas.drawPath(needlePath, needlePaint)

        // STEP 6: Center Pivot
        val outerPivotRadius = dpToPx(26f)
        val innerPivotRadius = dpToPx(20f)
        canvas.drawCircle(cx, cy, outerPivotRadius, outerPivotPaint)
        canvas.drawCircle(cx, cy, innerPivotRadius, innerPivotPaint)

        // STEP 7: Labels "0" and "100"
        labelTextPaint.textSize = spToPx(18f)
        val labelRadius = radius + strokeWidth / 2f + dpToPx(20f)

        // Left Label "0"
        val zeroRad = Math.toRadians(startAngle.toDouble())
        val zeroX = (cx + labelRadius * cos(zeroRad)).toFloat() + dpToPx(40f)
        val zeroY = (cy + labelRadius * sin(zeroRad)).toFloat() + dpToPx(20f)
        canvas.drawText("0", zeroX, zeroY, labelTextPaint)

        // Right Label "100"
        val endAngle = startAngle + sweepAngle
        val maxRad = Math.toRadians(endAngle.toDouble())
        val maxX = (cx + labelRadius * cos(maxRad)).toFloat() + dpToPx(-40f)
        val maxY = (cy + labelRadius * sin(maxRad)).toFloat() + dpToPx(20f)
        canvas.drawText("100", maxX, maxY, labelTextPaint)

        // STEP 8: Speed Digits & "Mbps"
        speedValuePaint.textSize = spToPx(42f)
        unitTextPaint.textSize = spToPx(14f)

        val formattedValue = String.format(Locale.US, "%.1f", animatedValue)
        val valueY = cy + outerPivotRadius + dpToPx(90f)
        canvas.drawText(formattedValue, cx, valueY, speedValuePaint)

        val unitY = valueY + dpToPx(20f)
        canvas.drawText("Mbps", cx, unitY, unitTextPaint)
    }

    // Helper functions for Pixel conversions
    private fun dpToPx(dp: Float): Float {
        return dp * context.resources.displayMetrics.density
    }

    private fun spToPx(sp: Float): Float {
        return sp * context.resources.displayMetrics.scaledDensity
    }
}