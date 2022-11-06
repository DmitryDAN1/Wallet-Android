package com.kirodan.uikit.components.button

import androidx.compose.animation.core.*
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import com.kirodan.wallet_theme.WalletTheme
import com.kirodan.wallet_theme.common.AdvancedShadow

@Stable
interface ShadowSpec {
    fun incoming(interaction: Interaction): AnimationSpec<AdvancedShadow>?
    fun outgoing(interaction: Interaction): AnimationSpec<AdvancedShadow>?
}

/**
 * Analog of material ButtonElevation but for AdvancedShadow
 */
@Stable
interface KRDButtonShadow {
    @Composable
    fun shadow(
        isEnabled: Boolean,
        interactionSource: InteractionSource,
        shadowSpec: ShadowSpec,
    ): State<AdvancedShadow>
}

fun advancedShadowAnimation(
    target: AdvancedShadow,
): Animatable<AdvancedShadow, AnimationVector4D> {
    return Animatable(
        target,
        typeConverter = TwoWayConverter(
            convertToVector = { value ->
                AnimationVector4D(
                    value.offsetX.value,
                    value.offsetY.value,
                    value.shadowBlurRadius.value,
                    value.spread.value,
                )
            },
            convertFromVector = { vector ->
                AdvancedShadow(
                    vector.v1.dp,
                    vector.v2.dp,
                    vector.v3.dp,
                    vector.v4.dp,
                    target.color,
                )
            }
        )
    )
}

@Stable
private class DefaultShadowButton(
    private val defaultShadow: AdvancedShadow,
    private val pressedShadow: AdvancedShadow,
    private val disabledShadow: AdvancedShadow,
) : KRDButtonShadow {
    @Composable
    override fun shadow(
        isEnabled: Boolean,
        interactionSource: InteractionSource,
        shadowSpec: ShadowSpec,
    ): State<AdvancedShadow> {
        val interactions = remember { mutableStateListOf<Interaction>() }
        LaunchedEffect(interactionSource) {
            interactionSource.interactions.collect { interaction ->
                when (interaction) {
                    is PressInteraction.Press -> {
                        interactions.add(interaction)
                    }
                    is PressInteraction.Release -> {
                        interactions.remove(interaction.press)
                    }
                    is PressInteraction.Cancel -> {
                        interactions.remove(interaction.press)
                    }
                }
            }
        }

        val interaction = interactions.lastOrNull()

        val target = if (!isEnabled) {
            disabledShadow
        } else {
            when (interaction) {
                is PressInteraction.Press -> pressedShadow
                else -> defaultShadow
            }
        }

        val animatedShadow = remember { advancedShadowAnimation(target) }

        if (!isEnabled) {
            // No transition when moving to a disabled state
            LaunchedEffect(target) {
                animatedShadow.snapTo(target)
            }
        } else {
            LaunchedEffect(target) {
                val lastInteraction = when (animatedShadow.targetValue) {
                    pressedShadow -> PressInteraction.Press(Offset.Zero)
                    else -> null
                }
                animatedShadow.animateShadow(
                    from = lastInteraction,
                    to = interaction,
                    target = target,
                    spec = shadowSpec,
                )
            }
        }

        return animatedShadow.asState()
    }
}

@Composable
fun shadowButton(
    defaultShadow: AdvancedShadow = WalletTheme.shadows.zero,
    pressedShadow: AdvancedShadow = WalletTheme.shadows.zero,
    disabledShadow: AdvancedShadow = WalletTheme.shadows.zero,
): KRDButtonShadow {
    return remember(defaultShadow, pressedShadow, disabledShadow) {
        DefaultShadowButton(
            defaultShadow = defaultShadow,
            pressedShadow = pressedShadow,
            disabledShadow = disabledShadow,
        )
    }
}

class DefaultShadowSpec(
    durationMillis: Int,
) : ShadowSpec {
    private val incomingSpec = TweenSpec<AdvancedShadow>(
        durationMillis = durationMillis,
        easing = FastOutSlowInEasing,
    )

    private val outgoingSpec = TweenSpec<AdvancedShadow>(
        durationMillis = durationMillis,
        easing = CubicBezierEasing(0.40f, 0.00f, 0.60f, 1.00f),
    )

    override fun incoming(interaction: Interaction): AnimationSpec<AdvancedShadow>? {
        return when (interaction) {
            is PressInteraction.Press -> incomingSpec
            is DragInteraction.Start -> incomingSpec
            else -> null
        }
    }

    override fun outgoing(interaction: Interaction): AnimationSpec<AdvancedShadow>? {
        return when (interaction) {
            is PressInteraction.Press -> outgoingSpec
            is DragInteraction.Start -> outgoingSpec
            else -> null
        }
    }
}

internal suspend fun Animatable<AdvancedShadow, *>.animateShadow(
    target: AdvancedShadow,
    from: Interaction? = null,
    to: Interaction? = null,
    spec: ShadowSpec,
) {
    val next = when {
        to != null -> spec.incoming(to)
        from != null -> spec.outgoing(from)
        else -> null
    }
    if (next != null) animateTo(target, next) else snapTo(target)
}
