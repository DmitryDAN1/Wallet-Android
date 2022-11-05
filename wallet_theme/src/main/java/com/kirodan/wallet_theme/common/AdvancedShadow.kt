package com.kirodan.wallet_theme.common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import kotlin.math.max

data class AdvancedShadow(
    val offsetX: Dp,
    val offsetY: Dp,
    val shadowBlurRadius: Dp,
    val spread: Dp,
    val color: Color
) {
    operator fun div(other: Int): AdvancedShadow {
        return AdvancedShadow(
            offsetX = this.offsetX / other,
            offsetY = this.offsetY / other,
            shadowBlurRadius = this.shadowBlurRadius / other,
            spread = this.spread / other,
            color = this.color
        )
    }

    operator fun times(other: Int): AdvancedShadow {
        return AdvancedShadow(
            offsetX = this.offsetX * other,
            offsetY = this.offsetY * other,
            shadowBlurRadius = this.shadowBlurRadius * other,
            spread = this.spread * other,
            color = this.color
        )
    }

    operator fun times(other: Float): AdvancedShadow {
        return AdvancedShadow(
            offsetX = this.offsetX * other,
            offsetY = this.offsetY * other,
            shadowBlurRadius = this.shadowBlurRadius * other,
            spread = this.spread * other,
            color = this.color
        )
    }
}

fun roundedShapeToRadius(shape: RoundedCornerShape, size: Size, density: Density): Float {
    val radiusBottom = max(shape.bottomStart.toPx(size, density), shape.bottomEnd.toPx(size, density))
    val radiusTop = max(shape.topStart.toPx(size, density), shape.topEnd.toPx(size, density))
    return max(radiusTop, radiusBottom)
}

fun Modifier.advancedShadow(
    shadow: AdvancedShadow,
    shape: RoundedCornerShape = RoundedCornerShape(0)
) = drawBehind {
    val shadowColor = shadow.color.copy(alpha = shadow.color.alpha.coerceAtMost(0.99f)).toArgb()
    val transparentColor = shadow.color.copy(alpha = 0f).toArgb()

    drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        frameworkPaint.setShadowLayer(
            shadow.shadowBlurRadius.toPx(),
            shadow.offsetX.toPx(),
            shadow.offsetY.toPx(),
            shadowColor
        )
        val diff = -(shadow.spread.toPx())
        val radius = roundedShapeToRadius(
            shape = shape,
            size = size,
            density = Density(this.density)
        )

        it.drawRoundRect(
            diff,
            diff,
            this.size.width - diff,
            this.size.height - diff,
            radius,
            radius,
            paint
        )
    }
}

fun Modifier.advancedShadow(
    shadow: AdvancedShadow,
    cornersRadius: Dp
) = advancedShadow(shadow, RoundedCornerShape(cornersRadius))

fun Modifier.advancedShadow(
    shadow: AdvancedShadow,
    cornersRadiusPercent: Int
) = advancedShadow(shadow, RoundedCornerShape(cornersRadiusPercent))
