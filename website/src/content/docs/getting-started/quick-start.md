---
title: Quick Start
description: Get PinchGrid working in 30 seconds
---

## Basic usage

```kotlin
@Composable
fun PhotoGrid(photos: List<Photo>) {
    val state = rememberPinchGridState()

    PinchGrid(state = state) {
        items(photos, key = { it.id }) { photo ->
            AsyncImage(
                model = photo.url,
                modifier = Modifier.aspectRatio(1f),
                contentScale = ContentScale.Crop,
            )
        }
    }
}
```

That's the complete integration. The grid handles:
- Pinch gesture detection (two-finger only, no scroll conflicts)
- Column count changes with haptic feedback
- Breathing scale animation during the gesture
- Scroll position preservation across column changes

## Customizing column range

```kotlin
val state = rememberPinchGridState(
    initialColumnCount = 3,  // start with 3 columns
    minColumns = 1,          // full-width single item (zoom in limit)
    maxColumns = 5,          // dense grid (zoom out limit)
)
```

## Adding spacing and padding

```kotlin
PinchGrid(
    state = state,
    contentPadding = PaddingValues(4.dp),
    verticalArrangement = Arrangement.spacedBy(4.dp),
    horizontalArrangement = Arrangement.spacedBy(4.dp),
) {
    items(photos, key = { it.id }) { photo ->
        // your item composable
    }
}
```

## Responding to column changes

```kotlin
PinchGrid(
    state = state,
    onColumnChanged = { newCount ->
        analytics.log("columns_changed", newCount)
    },
) { /* content */ }
```

## Stable keys

For best scroll position preservation, always provide stable `key` values:

```kotlin
items(photos, key = { it.id }) { photo -> /* ... */ }
```
