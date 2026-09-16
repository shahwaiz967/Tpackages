package com.codecx.tpackages.features.ui.customViews

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RadialGradient
import android.graphics.Shader
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.core.content.res.ResourcesCompat
import com.codecx.tpackages.R
import java.util.Locale
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

class SimSignalGaugeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var isActive: Boolean = true
    private var currentValue: Float = 15.0f
    private var animatedValue: Float = 15.0f
    private var minValue: Float = 0f
    private var maxValue: Float = 100.0f
    private var displayText: String = "15.000"

    private val startAngle: Float = 140f
    private val sweepAngle: Float = 260f

    private var animator: ValueAnimator? = null

    private var customTypeface: Typeface? = null


    private val outerBorderPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        color = Color.parseColor("#FF2D7A")
    }

    private val innerBorderPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        color = Color.parseColor("#FFA7C3")
    }

    private val innerFillPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }

    private val concentricArcPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        color = Color.argb(130, 255, 255, 255)
    }

    private val tickPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
        color = Color.WHITE
    }

    private val haloPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        color = Color.WHITE
        // The glow color (can be translucent)
        maskFilter = BlurMaskFilter(15f, BlurMaskFilter.Blur.NORMAL)
    }

    private val haloFillPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.parseColor("#44FFFFFF") // Fill the inside
    }

    private val haloDotPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.WHITE
    }

    private val needlePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.WHITE
    }

    private val needlePivotPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.WHITE
    }
    private val needlePivotShadowPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.parseColor("#66FFFFFF")
    }

    private val zeroTextPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        textAlign = Paint.Align.CENTER
    }

    private val valueTextMainPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        textAlign = Paint.Align.RIGHT
    }

    private val valueTextSubPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        textAlign = Paint.Align.LEFT
    }


    private val inactiveBorderPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        color = Color.parseColor("#FFD1DC")
    }

    private val inactiveNeedlePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.argb(180, 255, 245, 248)
    }

    private val inactivePivotPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.argb(220, 255, 255, 255)
    }

    private val inactiveShadowPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.argb(25, 230, 0, 126)
    }

    private val needlePath = Path()

    init {
        // We'll calculate the shadow radius and blur mask filter size dynamically in dp
        // It's also recommended to use setLayerType(LAYER_TYPE_SOFTWARE, null) for consistent blur rendering across different Android versions,
        // especially when using BlurMaskFilter. However, note that software rendering can be slower.
        // Let's add it for safety:
        setLayerType(LAYER_TYPE_SOFTWARE, null)

        try {
            customTypeface = ResourcesCompat.getFont(context, R.font.plus_jakarta_sans_bold)
        } catch (_: Exception) {
            customTypeface = Typeface.DEFAULT_BOLD
        }

        val tf = customTypeface ?: Typeface.DEFAULT_BOLD
        zeroTextPaint.typeface = tf
        valueTextMainPaint.typeface = tf
        valueTextSubPaint.typeface = tf

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.SimSignalGaugeView, defStyleAttr, 0)
            isActive = typedArray.getBoolean(R.styleable.SimSignalGaugeView_gauge_active, true)
            currentValue = typedArray.getFloat(R.styleable.SimSignalGaugeView_gauge_value, 15.0f)
            animatedValue = currentValue
            maxValue = typedArray.getFloat(R.styleable.SimSignalGaugeView_gauge_max_value, 100.0f)
            typedArray.getString(R.styleable.SimSignalGaugeView_gauge_display_text)?.let { text ->
                displayText = text
            }
            typedArray.recycle()
        }
    }

    fun setActive(active: Boolean) {
        if (isActive != active) {
            isActive = active
            invalidate()
        }
    }

    fun setValue(value: Float, text: String? = null, animated: Boolean = true) {
        currentValue = value.coerceIn(minValue, maxValue)
        displayText = text ?: String.format(Locale.US, "%.3f", currentValue)

        if (animated) {
            animator?.cancel()
            animator = ValueAnimator.ofFloat(animatedValue, currentValue).apply {
                duration = 900
                interpolator = DecelerateInterpolator(1.5f)
                addUpdateListener {
                    this@SimSignalGaugeView.animatedValue = it.animatedValue as Float
                    invalidate()
                }
                start()
            }
        } else {
            animatedValue = currentValue
            invalidate()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        val size = if (width > 0 && height > 0) min(width, height) else dpToPx(180f).toInt()
        setMeasuredDimension(size, size)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = width.toFloat()
        val height = height.toFloat()
        val cx = width / 2f
        val cy = height / 2f
        val radius = min(width, height) / 2f

        if (isActive) {
            drawActiveGauge(canvas, cx, cy, radius)
        } else {
            drawInactiveGauge(canvas, cx, cy, radius)
        }
    }

    private fun drawActiveGauge(canvas: Canvas, cx: Float, cy: Float, radius: Float) {
        val outerBorderWidth = dpToPx(7f)
        val innerBorderWidth = dpToPx(4f)
        val dialRadius = radius - outerBorderWidth / 2f
        val innerDialRadius = radius - outerBorderWidth - innerBorderWidth / 2f

        // 1. Inner Circle Gradient Fill
        val innerFillRadius = radius - outerBorderWidth - innerBorderWidth
        innerFillPaint.shader = RadialGradient(
            cx, cy - innerFillRadius * 0.2f,
            innerFillRadius * 1.15f,
            Color.parseColor("#FF7CA3"),
            Color.parseColor("#F43F6E"),
            Shader.TileMode.CLAMP
        )
        canvas.drawCircle(cx, cy, innerFillRadius, innerFillPaint)

        // 2. Outer Hot-Pink Border Ring
        outerBorderPaint.strokeWidth = outerBorderWidth
        canvas.drawCircle(cx, cy, dialRadius, outerBorderPaint)

        // 2b. Secondary Inner Border Ring
        innerBorderPaint.strokeWidth = innerBorderWidth
        canvas.drawCircle(cx, cy, innerDialRadius, innerBorderPaint)

        // 3. Subtle Inner Concentric Track
        val trackRadius = radius * 0.77f
        concentricArcPaint.strokeWidth = dpToPx(1.5f)
        canvas.drawCircle(cx, cy, trackRadius, concentricArcPaint)

        // 4. Tick Marks
        val tickCount = 9
        val tickInnerRadius = radius * 0.75f
        val tickOuterRadius = radius * 0.70f
        tickPaint.strokeWidth = dpToPx(2.2f)

        for (i in 0 until tickCount) {
            val angleDeg = startAngle + (i.toFloat() / (tickCount - 1)) * sweepAngle
            val angleDegPnt = angleDeg
            val angleRad = Math.toRadians(angleDeg.toDouble())

            val x1 = (cx + tickInnerRadius * cos(angleRad)).toFloat()
            val y1 = (cy + tickInnerRadius * sin(angleRad)).toFloat()
            val x2 = (cx + tickOuterRadius * cos(angleRad)).toFloat()
            val y2 = (cy + tickOuterRadius * sin(angleRad)).toFloat()

            canvas.drawLine(x1, y1, x2, y2, tickPaint)
        }

        // Calculate Needle Angle
        val fraction = ((animatedValue - minValue) / (maxValue - minValue)).coerceIn(0f, 1f)
        val needleAngleDeg = startAngle + fraction * sweepAngle
        val needleAngleRad = Math.toRadians(needleAngleDeg.toDouble())

        // 5. Active Glowing Halo & Dot at Indicator Track
        val indicatorRadius = radius * 0.77f
        val haloX = (cx + indicatorRadius * cos(needleAngleRad)).toFloat()
        val haloY = (cy + indicatorRadius * sin(needleAngleRad)).toFloat()

        // 5a. Draw filled glowing inner circle
        canvas.drawCircle(haloX, haloY, dpToPx(12f), haloFillPaint) // Fills inside of halo

        // 5b. Draw large halo outline with blur (glow effect)
        haloPaint.strokeWidth = dpToPx(3.5f) // Adjust thickness of halo ring
        canvas.drawCircle(haloX, haloY, dpToPx(12f), haloPaint)

        // 5c. Draw smaller solid white dot on top
        canvas.drawCircle(haloX, haloY, dpToPx(5f), haloDotPaint)

        // 6. Needle Pointer
        val pivotRadius = radius * 0.14f
        val pivotShadowRadius = radius * 0.22f
        val needleLength = radius * 0.70f

        needlePath.reset()
        val perpRad1 = needleAngleRad + Math.PI / 2.0
        val perpRad2 = needleAngleRad - Math.PI / 2.0

        val baseWidth = pivotRadius * 0.65f
        val b1x = (cx + baseWidth * cos(perpRad1)).toFloat()
        val b1y = (cy + baseWidth * sin(perpRad1)).toFloat()
        val b2x = (cx + baseWidth * cos(perpRad2)).toFloat()
        val b2y = (cy + baseWidth * sin(perpRad2)).toFloat()

        val tipX = (cx + needleLength * cos(needleAngleRad)).toFloat()
        val tipY = (cy + needleLength * sin(needleAngleRad)).toFloat()

        needlePath.moveTo(b1x, b1y)
        needlePath.lineTo(tipX, tipY)
        needlePath.lineTo(b2x, b2y)
        needlePath.close()

        canvas.drawPath(needlePath, needlePaint)

        // 7. Center Pivot Circle
        canvas.drawCircle(cx, cy, pivotRadius, needlePivotPaint)
        canvas.drawCircle(cx ,cy,pivotShadowRadius,needlePivotShadowPaint)

        // 8. "0" Label (Bottom Left)
        zeroTextPaint.textSize = spToPx(13f)
        val zeroX = cx - radius * 0.32f
        val zeroY = cy + radius * 0.58f
        canvas.drawText("0", zeroX, zeroY, zeroTextPaint)

        // 9. Formatted Signal Value (Bottom Right)
        // Render main part (e.g. "15.0") in larger bold and sub part (e.g. "00") in smaller bold
        val mainText: String
        val subText: String
        if (displayText.contains(".")) {
            val parts = displayText.split(".")
            mainText = "${parts[0]}.${parts.getOrNull(1)?.take(1) ?: "0"}"
            subText = parts.getOrNull(1)?.drop(1) ?: "00"
        } else {
            mainText = displayText
            subText = ""
        }

        valueTextMainPaint.textSize = spToPx(21f)
        valueTextSubPaint.textSize = spToPx(13f)

        val textBaselineY = cy + radius * 0.60f
        val subBaselineY = textBaselineY - dpToPx(3f)

        // Calculate positions
        val anchorX = cx + radius * 0.30f
        canvas.drawText(mainText, anchorX, textBaselineY, valueTextMainPaint)
        if (subText.isNotEmpty()) {
            canvas.drawText(subText, anchorX + dpToPx(1.5f), subBaselineY, valueTextSubPaint)
        }
    }

    private fun drawInactiveGauge(canvas: Canvas, cx: Float, cy: Float, radius: Float) {
        val borderWidth = dpToPx(3.5f)
        val dialRadius = radius - borderWidth / 2f

        // 1. Outer Inactive Light Pink Stroke
        inactiveBorderPaint.strokeWidth = borderWidth
        canvas.drawCircle(cx, cy, dialRadius, inactiveBorderPaint)

        // 2. Faint Pointer pointing downwards-left (~220°)
        val angleDeg = 220.0
        val angleRad = Math.toRadians(angleDeg)
        val pivotRadius = radius * 0.16f
        val needleLength = radius * 0.65f

        // Subtle soft shadow underneath pointer
        val shadowOffsetX = dpToPx(2f)
        val shadowOffsetY = dpToPx(2f)

        needlePath.reset()
        val perpRad1 = angleRad + Math.PI / 2.0
        val perpRad2 = angleRad - Math.PI / 2.0
        val baseWidth = pivotRadius * 0.60f

        val b1x = (cx + baseWidth * cos(perpRad1)).toFloat()
        val b1y = (cy + baseWidth * sin(perpRad1)).toFloat()
        val b2x = (cx + baseWidth * cos(perpRad2)).toFloat()
        val b2y = (cy + baseWidth * sin(perpRad2)).toFloat()
        val tipX = (cx + needleLength * cos(angleRad)).toFloat()
        val tipY = (cy + needleLength * sin(angleRad)).toFloat()

        needlePath.moveTo(b1x + shadowOffsetX, b1y + shadowOffsetY)
        needlePath.lineTo(tipX + shadowOffsetX, tipY + shadowOffsetY)
        needlePath.lineTo(b2x + shadowOffsetX, b2y + shadowOffsetY)
        needlePath.close()
        canvas.drawPath(needlePath, inactiveShadowPaint)

        needlePath.reset()
        needlePath.moveTo(b1x, b1y)
        needlePath.lineTo(tipX, tipY)
        needlePath.lineTo(b2x, b2y)
        needlePath.close()
        canvas.drawPath(needlePath, inactiveNeedlePaint)

        // Pivot cap
        canvas.drawCircle(cx + shadowOffsetX, cy + shadowOffsetY, pivotRadius, inactiveShadowPaint)
        canvas.drawCircle(cx, cy, pivotRadius, inactivePivotPaint)
    }

    private fun dpToPx(dp: Float): Float {
        return dp * context.resources.displayMetrics.density
    }

    private fun spToPx(sp: Float): Float {
        return sp * context.resources.displayMetrics.scaledDensity
    }
}