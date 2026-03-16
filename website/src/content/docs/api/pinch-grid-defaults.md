---
title: PinchGridDefaults
description: Default values reference
---

## Constants

```kotlin
object PinchGridDefaults {
    const val InitialColumnCount: Int = 3
    const val MinColumns: Int = 1
    const val MaxColumns: Int = 5
    const val ThresholdFraction: Float = 0.45f
    const val DeadZone: Float = 0.01f
    const val PinchOutThresholdMultiplier: Float = 0.85f
    val TransitionSpec: ColumnTransitionSpec = ColumnTransitionSpec.None
}
```

## Reference

| Constant | Value | Description |
|----------|-------|-------------|
| `InitialColumnCount` | `3` | Default starting columns |
| `MinColumns` | `1` | Default minimum (fully zoomed in) |
| `MaxColumns` | `5` | Default maximum (fully zoomed out) |
| `ThresholdFraction` | `0.45f` | Scale change needed to trigger snap |
| `DeadZone` | `0.01f` | Micro-movement filter to prevent jitter |
| `PinchOutThresholdMultiplier` | `0.85f` | Makes pinch-out 15% easier than pinch-in |
| `TransitionSpec` | `None` | Google Photos-style instant reflow |

## ColumnTransitionSpec

```kotlin
sealed class ColumnTransitionSpec {
    data object None : ColumnTransitionSpec()
    data class Crossfade(val durationMillis: Int = 200) : ColumnTransitionSpec()
}
```
