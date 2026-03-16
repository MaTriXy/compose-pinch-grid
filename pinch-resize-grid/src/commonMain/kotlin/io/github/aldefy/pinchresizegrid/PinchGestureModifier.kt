package io.github.aldefy.pinchresizegrid

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.calculateZoom
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChanged

/**
 * Attaches pinch-to-resize gesture handling to a composable.
 *
 * Uses raw pointer input to detect two-finger pinch gestures. This approach
 * avoids the scroll-vs-transform conflict that occurs when using [transformable]
 * alongside LazyVerticalGrid — we only consume zoom when two pointers are down,
 * letting single-finger scroll pass through untouched.
 *
 * @param state The [PinchResizeGridState] to drive.
 * @param thresholdFraction Scale change fraction required to trigger column snap.
 * @param deadZone Minimum scale delta to register.
 * @param pinchOutMultiplier Asymmetric threshold multiplier for pinch-out.
 * @param enabled Whether gesture detection is enabled.
 */
@Composable
internal fun Modifier.pinchResizeGesture(
    state: PinchResizeGridState,
    thresholdFraction: Float = PinchResizeGridDefaults.ThresholdFraction,
    deadZone: Float = PinchResizeGridDefaults.DeadZone,
    pinchOutMultiplier: Float = PinchResizeGridDefaults.PinchOutThresholdMultiplier,
    enabled: Boolean = true,
): Modifier {
    if (!enabled) return this

    return this.pointerInput(state, thresholdFraction, deadZone, pinchOutMultiplier) {
        awaitEachGesture {
            // Wait for first finger
            awaitFirstDown(requireUnconsumed = false)

            var isPinching = false

            do {
                val event = awaitPointerEvent()
                val pointers = event.changes

                if (pointers.size >= 2) {
                    val zoom = event.calculateZoom()

                    if (zoom != 1f) {
                        isPinching = true
                        // Consume all pointer changes to prevent scroll
                        pointers.forEach { change ->
                            if (change.positionChanged()) {
                                change.consume()
                            }
                        }
                        state.onScale(
                            scaleFactor = zoom,
                            thresholdFraction = thresholdFraction,
                            deadZone = deadZone,
                            pinchOutMultiplier = pinchOutMultiplier,
                        )
                    }
                }
            } while (pointers.any { it.pressed })

            if (isPinching) {
                state.onGestureEnd()
            }
        }
    }
}
