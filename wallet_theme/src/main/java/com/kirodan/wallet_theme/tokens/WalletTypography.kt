package com.kirodan.wallet_theme.tokens

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnitType

data class WalletTypography(
    val Family: FontFamily,

    val Weight: WalletFontWeight,
    val Decoration: WalletFontDecoration,

    val TitleBig: TextStyle,
    val Title0: TextStyle,
    val Title1: TextStyle,
    val Title2: TextStyle,
    val Title3: TextStyle,
    val Headline: TextStyle,
    val Body: TextStyle,
    val Footnote: TextStyle,
    val Caption: TextStyle,

    val HeadlineSemiBold: TextStyle,
    val BodyBold: TextStyle,
    val BodySemiBold: TextStyle,
    val FootnoteSemiBold: TextStyle,
    val CaptionSemiBold: TextStyle
)

@Composable
private fun TextStyle.withoutFontScale(): TextStyle {
    if (fontSize.type == TextUnitType.Unspecified) {
        return this
    }
    val fontScale = LocalDensity.current.fontScale
    return copy(fontSize = fontSize.div(fontScale), lineHeight = lineHeight.div(fontScale))
}

@Composable
fun WalletTypography.withoutFontScale() = WalletTypography(
    Family = this.Family,
    Weight = this.Weight,
    Decoration = this.Decoration,

    TitleBig = this.TitleBig.withoutFontScale(),
    Title0 = this.Title0.withoutFontScale(),
    Title1 = this.Title1.withoutFontScale(),
    Title2 = this.Title2.withoutFontScale(),
    Title3 = this.Title3.withoutFontScale(),
    Headline = this.Headline.withoutFontScale(),
    Body = this.Body.withoutFontScale(),
    Footnote = this.Footnote.withoutFontScale(),
    Caption = this.Caption.withoutFontScale(),

    HeadlineSemiBold = this.HeadlineSemiBold.withoutFontScale(),
    BodyBold = this.BodyBold.withoutFontScale(),
    BodySemiBold = this.BodySemiBold.withoutFontScale(),
    FootnoteSemiBold = this.FootnoteSemiBold.withoutFontScale(),
    CaptionSemiBold = this.CaptionSemiBold.withoutFontScale()
)
