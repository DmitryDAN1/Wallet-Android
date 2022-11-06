package com.kirodan.uikit.modifiers

import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Modifier

fun Modifier.statusBarsPadding() = statusBarsPadding()

fun Modifier.keyboardPadding() = imePadding()
