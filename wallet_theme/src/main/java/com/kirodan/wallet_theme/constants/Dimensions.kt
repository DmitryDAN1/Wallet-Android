package com.kirodan.wallet_theme.constants

fun checkIsSmallScreen(width: Int): Boolean {
    return width < 360
}

fun checkIsMediumScreen(width: Int): Boolean {
    return width in 360..410
}

fun checkIsLargeScreen(width: Int): Boolean {
    return width >= 414
}
