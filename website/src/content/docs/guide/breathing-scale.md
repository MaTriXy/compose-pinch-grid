---
title: Breathing Scale
description: Real-time visual feedback during the pinch gesture
---

During a pinch gesture, the grid subtly scales up (zooming in) or down (zooming out) following your fingers. This provides real-time visual feedback before the column count snaps.

## How it works

The breathing effect uses `graphicsLayer` — **zero recompositions**, pure GPU transform at 60fps. During the gesture, scale tracks `scaleProgress` instantly (0ms tween). On release, it animates back to 1.0 over 150ms.

## Custom per-item transforms

You can use `state.scaleProgress` and `state.isZoomingIn` to apply custom transforms to individual items:

```kotlin
items(photos, key = { it.id }) { photo ->
    val itemScale = when (state.isZoomingIn) {
        true -> 1f + (state.scaleProgress * 0.1f)
        false -> 1f - (state.scaleProgress * 0.1f)
        null -> 1f
    }
    AsyncImage(
        model = photo.url,
        modifier = Modifier
            .graphicsLayer { scaleX = itemScale; scaleY = itemScale }
            .aspectRatio(1f),
    )
}
```

## State properties

| Property | Type | Description |
|----------|------|-------------|
| `scaleProgress` | `Float` | 0f–1f, how close to the next column snap |
| `isZoomingIn` | `Boolean?` | `true` = spreading fingers, `false` = pinching, `null` = idle |
