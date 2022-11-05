package com.kirodan.wallet_theme.constants

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.kirodan.wallet_theme.R
import com.kirodan.wallet_theme.tokens.WalletFontDecoration
import com.kirodan.wallet_theme.tokens.WalletFontWeight
import com.kirodan.wallet_theme.tokens.WalletTypography

private val defaultFontWeights = WalletFontWeight(
    Black = FontWeight.Black,
    ExtraBold = FontWeight.ExtraBold,
    Bold = FontWeight.Bold,
    SemiBold = FontWeight.SemiBold,
    Medium = FontWeight.Medium,
    Regular = FontWeight.Normal,
    Light = FontWeight.Light,
    ExtraLight = FontWeight.ExtraLight,
    Thin = FontWeight.Thin,
)

private val defaultFontDecorations = WalletFontDecoration(
    Crossed = TextDecoration.LineThrough
)

private val Family = FontFamily(
    Font(R.font.sfpro_black, defaultFontWeights.Black),
    Font(R.font.sfpro_heavy, defaultFontWeights.ExtraBold),
    Font(R.font.sfpro_bold, defaultFontWeights.Bold),
    Font(R.font.sfpro_semibold, defaultFontWeights.SemiBold),
    Font(R.font.sfpro_medium, defaultFontWeights.Medium),
    Font(R.font.sfpro_regular, defaultFontWeights.Regular),
    Font(R.font.sfpro_light, defaultFontWeights.Light),
    Font(R.font.sfpro_ultralight, defaultFontWeights.ExtraLight),
    Font(R.font.sfpro_thin, defaultFontWeights.Thin),
)

private val FontBase = TextStyle(
    fontWeight = defaultFontWeights.Regular,
    fontFamily = Family,
)

private val TitleBig = FontBase.copy(
    fontSize = 32.sp,
    lineHeight = 41.sp,
    fontWeight = defaultFontWeights.Bold
)
private val Title0 = FontBase.copy(
    fontSize = 26.sp,
    lineHeight = 34.sp,
    fontWeight = defaultFontWeights.Bold
)
private val Title1 = FontBase.copy(
    fontSize = 20.sp,
    lineHeight = 26.sp,
    fontWeight = defaultFontWeights.Bold
)
private val Title2 = FontBase.copy(
    fontSize = 18.sp,
    lineHeight = 24.sp,
    fontWeight = defaultFontWeights.Bold
)
private val Title3 = FontBase.copy(
    fontSize = 14.sp,
    lineHeight = 18.sp,
    fontWeight = defaultFontWeights.SemiBold
)
private val Headline = FontBase.copy(
    fontSize = 17.sp,
    lineHeight = 24.sp
)
private val Body = FontBase.copy(
    fontSize = 15.sp,
    lineHeight = 20.sp
)
private val Footnote = FontBase.copy(
    fontSize = 13.sp,
    lineHeight = 18.sp
)
private val Caption = FontBase.copy(
    fontSize = 12.sp,
    lineHeight = 16.sp
)

private val HeadlineSemiBold = Headline.copy(fontWeight = defaultFontWeights.SemiBold)
private val BodyBold = Body.copy(fontWeight = defaultFontWeights.Bold)
private val BodySemiBold = Body.copy(fontWeight = defaultFontWeights.SemiBold)
private val FootnoteSemiBold = Footnote.copy(fontWeight = defaultFontWeights.SemiBold)
private val CaptionSemiBold = Caption.copy(fontWeight = defaultFontWeights.SemiBold)

internal val defaultTypography = WalletTypography(
    Family = Family,
    Weight = defaultFontWeights,
    Decoration = defaultFontDecorations,

    // Main Fonts
    TitleBig = TitleBig,
    Title0 = Title0,
    Title1 = Title1,
    Title2 = Title2,
    Title3 = Title3,
    Headline = Headline,
    Body = Body,
    Footnote = Footnote,
    Caption = Caption,

    // Extended fonts
    HeadlineSemiBold = HeadlineSemiBold,
    BodyBold = BodyBold,
    BodySemiBold = BodySemiBold,
    FootnoteSemiBold = FootnoteSemiBold,
    CaptionSemiBold = CaptionSemiBold
)
