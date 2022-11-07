package com.kirodan.uikit.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.kirodan.uikit.components.surface.KRDSurface
import com.kirodan.wallet_theme.WalletTheme
import com.kirodan.wallet_theme.common.AdvancedShadow

const val DefaultShadowDuration = 200

@Composable
fun KRDButton(
    modifier: Modifier,
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    shape: RoundedCornerShape = WalletTheme.shapes.zero,
    backgroundColor: Color = Color.Unspecified,
    disabledBackgroundColor: Color = Color.Unspecified,
    rippleColor: Color = WalletTheme.colors.rippleColor,
    borderColor: Color? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shadow: AdvancedShadow? = null,
    contentPadding: PaddingValues = PaddingValues(WalletTheme.spacings.s0),
    shadowSpec: ShadowSpec = DefaultShadowSpec(DefaultShadowDuration),
    content: @Composable RowScope.() -> Unit,
) {
    KRDSurface(
        modifier = modifier,
        onClick = onClick,
        shape = shape,
        color = if (isEnabled) backgroundColor else disabledBackgroundColor,
        border = if (borderColor != null) BorderStroke(1.dp, SolidColor(borderColor)) else null,
        shadow = if (shadow != null) shadowButton(shadow, shadow / 2, shadow * 0).shadow(
            isEnabled = isEnabled,
            interactionSource = interactionSource,
            shadowSpec = shadowSpec,
        ).value else null,
        interactionSource = interactionSource,
        indication = rememberRipple(color = rippleColor),
        enabled = isEnabled,
        role = Role.Button,
        contentAlignment = Alignment.Center,
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(contentPadding),
            content = { content.invoke(this) },
        )
    }
}
