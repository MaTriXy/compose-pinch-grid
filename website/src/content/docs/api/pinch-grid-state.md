---
title: PinchGridState
description: State holder API reference
---

## Creating state

```kotlin
val state = rememberPinchGridState(
    initialColumnCount = 3,
    minColumns = 1,
    maxColumns = 5,
)
```

`rememberPinchGridState` uses `rememberSaveable` — the column count survives configuration changes.

## Properties

| Property | Type | Description |
|----------|------|-------------|
| `columnCount` | `Int` | Current committed column count (read-only) |
| `previousColumnCount` | `Int` | Column count before the last change (read-only) |
| `scaleProgress` | `Float` | 0f–1f progress toward next snap (read-only) |
| `isZoomingIn` | `Boolean?` | `true` = spreading, `false` = pinching, `null` = idle (read-only) |
| `minColumns` | `Int` | Minimum allowed columns |
| `maxColumns` | `Int` | Maximum allowed columns |

## Methods

### snapToColumn

```kotlin
fun snapToColumn(target: Int)
```

Programmatically change the column count. The target is clamped to `minColumns..maxColumns`. Triggers haptic feedback and `onColumnChanged` callback.

## Saver

`PinchGridState` provides a custom `Saver` for `rememberSaveable`:

```kotlin
PinchGridState.Saver(minColumns = 1, maxColumns = 5)
```

This saves and restores the `columnCount` across configuration changes.
