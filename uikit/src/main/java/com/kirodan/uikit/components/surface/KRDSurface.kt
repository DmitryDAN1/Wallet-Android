package com.kirodan.uikit.components.surface

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kirodan.wallet_theme.WalletTheme
import com.kirodan.wallet_theme.common.AdvancedShadow
import com.kirodan.wallet_theme.common.advancedShadow

@Composable
fun KRDSurface(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    shape: RoundedCornerShape = WalletTheme.shapes.zero,
    color: Color = WalletTheme.colors.mainWhite,
    border: BorderStroke? = null,
    shadow: AdvancedShadow? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    indication: Indication? = null,
    enabled: Boolean = true,
    role: Role? = null,
    contentAlignment: Alignment = Alignment.TopStart,
    padding: PaddingValues? = null,
    content: @Composable BoxScope.() -> Unit,
) {
    KRDSurface(
        modifier = modifier,
        clickAndSemanticsModifier = Modifier.clickable(
            interactionSource = interactionSource,
            indication = indication,
            enabled = enabled,
            role = role,
            onClick = onClick,
        ),
        color = color,
        border = border,
        shape = shape,
        shadow = shadow,
        padding = padding,
        contentAlignment = contentAlignment,
        content = content,
    )
}

@Composable
fun KRDSurface(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit,
    clickAndSemanticsModifier: Modifier = Modifier,
    color: Color = WalletTheme.colors.mainWhite,
    border: BorderStroke? = null,
    shadow: AdvancedShadow? = null,
    padding: PaddingValues? = null,
    contentAlignment: Alignment = Alignment.TopStart,
    shape: RoundedCornerShape = WalletTheme.shapes.zero,
) {
    Box(
        modifier
            .then(if (shadow != null) Modifier.advancedShadow(shadow, shape) else Modifier)
            .clip(shape)
            .then(if (border != null) Modifier.border(border, shape) else Modifier)
            .background(
                color = color,
                shape = shape,
            )
            .then(clickAndSemanticsModifier)
            .then(padding?.let { Modifier.padding(padding) } ?: Modifier),
        contentAlignment = contentAlignment,
        propagateMinConstraints = true,
        content = { content.invoke(this) },
    )
}

@Preview
@Composable
private fun KRDSurfacePreview() {
    Box(
        Modifier.background(WalletTheme.colors.black600)
    ) {
        KRDSurface(
            modifier = Modifier
                .padding(WalletTheme.spacings.s16)
                .size(WalletTheme.spacings.s72),
            shadow = WalletTheme.shadows.xl,
            shape = WalletTheme.shapes.xs,
            color = WalletTheme.colors.mainWhite,
            border = BorderStroke(24.dp, WalletTheme.colors.mainPrimary),
            content = {},
        )
    }
}
