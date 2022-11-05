package com.kirodan.wallet_theme.common

import androidx.compose.runtime.Immutable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.*
import kotlin.math.*

/**
 * Draws linear gradient with given [Angle]
 */
@Immutable
data class AngledLinearGradient(
    private val colors: List<Color>,
    private val stops: List<Float>? = null,
    private val start: Offset = Offset.Zero,
    private val end: Offset = Offset.Infinite,
    private val tileMode: TileMode = TileMode.Clamp,
    private val angle: Float = 0.0f
) : ShaderBrush() {
    override fun createShader(size: Size): Shader {
        val angleRad = angle / 180 * PI
        val x = cos(angleRad).toFloat()
        val y = sin(angleRad).toFloat()
        val radius = sqrt(size.width.pow(2) + size.height.pow(2)) / 2f
        val offset = size.center + Offset(x = x * radius, y = y * radius)
        val exactOffset = Offset(
            x = min(offset.x.coerceAtLeast(0f), size.width),
            y = size.height - min(offset.y.coerceAtLeast(0f), size.height)
        )
        return LinearGradientShader(
            colors = colors,
            colorStops = stops,
            from = Offset(size.width, size.height) - exactOffset,
            to = exactOffset,
            tileMode = tileMode
        )
    }
}
