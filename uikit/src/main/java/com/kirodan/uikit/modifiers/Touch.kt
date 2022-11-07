package com.kirodan.uikit.modifiers

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager

/**
 * Calls onTouchStart callback on every touch action in the component or its descendants
 * Useful if you need to determine whether there was a touch action and perform a side effect
 * (for example, close the keyboard when clicking on any element)
 */
fun Modifier.touchStart(
    vararg keys: Any?,
    onTouchStart: () -> Unit,
) = this.pointerInput(*keys) {
    awaitPointerEventScope {
        while (true) {
            awaitFirstDown(false)
            onTouchStart()
        }
    }
}

fun Modifier.clearFocusOnScroll(
    scrollState: ScrollState,
) = composed {
    val focusManager = LocalFocusManager.current
    val isDragged by scrollState.interactionSource.collectIsDraggedAsState()
    if (scrollState.isScrollInProgress && isDragged) {
        LaunchedEffect(Unit) {
            focusManager.clearFocus(true)
        }
    }
    return@composed Modifier
}
