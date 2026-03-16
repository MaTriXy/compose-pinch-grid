---
title: Gesture Configuration
description: Fine-tune the pinch gesture feel
---

The gesture feel is highly configurable. All parameters have tuned defaults that work well out of the box.

## Threshold Fraction

Controls how much pinch is needed to trigger a column change. Lower = more sensitive.

```kotlin
PinchGrid(
    state = state,
    thresholdFraction = 0.45f,  // default — responsive but not accidental
    // thresholdFraction = 0.2f,  // very sensitive — small pinch triggers change
    // thresholdFraction = 0.7f,  // conservative — requires deliberate pinch
) { /* content */ }
```

## Defaults Reference

| Parameter | Default | What it does |
|-----------|---------|-------------|
| `ThresholdFraction` | `0.45f` | Scale change needed to snap. Lower = more sensitive |
| `DeadZone` | `0.01f` | Micro-movement filter. Prevents jitter from small finger tremors |
| `PinchOutThresholdMultiplier` | `0.85f` | Makes pinch-out 15% easier than pinch-in |
| `InitialColumnCount` | `3` | Starting columns |
| `MinColumns` | `1` | Zoom-in limit (single item full width) |
| `MaxColumns` | `5` | Zoom-out limit (dense grid) |

## Asymmetric Thresholds

Pinch-out (spreading fingers) naturally produces less scale change than pinch-in. The `PinchOutThresholdMultiplier` compensates — at `0.85f`, zooming in requires 15% less finger movement than zooming out, making both directions feel equally responsive.

## Dead Zone

The `0.01f` dead zone filters micro-movements. Without it, tiny finger tremors while holding a pinch cause the grid to jitter. You shouldn't need to change this.

## Gesture architecture

PinchGrid uses raw `pointerInput` with `awaitEachGesture` instead of `transformable`. This is a deliberate choice:

- **No scroll conflicts** — only consumes events when 2+ fingers are detected
- **Single-finger scroll passes through** — the LazyVerticalGrid scrolls normally
- **KMP compatible** — works on all Compose targets
