---
title: Programmatic Control
description: Change column count from code
---

## snapToColumn

Use `snapToColumn()` to change the column count programmatically — useful for buttons, keyboard shortcuts, or accessibility.

```kotlin
val state = rememberPinchGridState()

// Zoom in / out buttons
Button(onClick = { state.snapToColumn(state.columnCount - 1) }) {
    Text("Zoom In")
}
Button(onClick = { state.snapToColumn(state.columnCount + 1) }) {
    Text("Zoom Out")
}
```

`snapToColumn` respects `minColumns` and `maxColumns` bounds, triggers haptic feedback, and fires the `onColumnChanged` callback.

## Reading state

```kotlin
state.columnCount       // current column count
state.minColumns        // minimum allowed
state.maxColumns        // maximum allowed
state.scaleProgress     // 0f–1f, progress toward next snap
state.isZoomingIn       // true/false/null (gesture direction)
state.previousColumnCount  // for transition animation
```

## Disabling gestures

You can disable the pinch gesture while keeping programmatic control:

```kotlin
PinchGrid(
    state = state,
    gestureEnabled = false,  // no pinch, but snapToColumn still works
) { /* content */ }
```

## Scroll position preservation

When the column count changes (via gesture or programmatic), the grid snapshots `firstVisibleItemIndex` before the change and restores it after. For best results, provide stable `key` values to your items:

```kotlin
items(photos, key = { it.id }) { photo -> /* ... */ }
```
