---
title: PinchGrid
description: Main composable API reference
---

## Signature

```kotlin
@Composable
fun PinchGrid(
    state: PinchGridState,
    modifier: Modifier = Modifier,
    gridState: LazyGridState = rememberLazyGridState(),
    contentPadding: PaddingValues = PaddingValues(),
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(0.dp),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(0.dp),
    thresholdFraction: Float = PinchGridDefaults.ThresholdFraction,
    transitionSpec: ColumnTransitionSpec = PinchGridDefaults.TransitionSpec,
    gestureEnabled: Boolean = true,
    onColumnChanged: ((newCount: Int) -> Unit)? = null,
    content: LazyGridScope.() -> Unit,
)
```

## Parameters

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `state` | `PinchGridState` | *required* | State holder created by `rememberPinchGridState()` |
| `modifier` | `Modifier` | `Modifier` | Modifier for the outer container |
| `gridState` | `LazyGridState` | `rememberLazyGridState()` | State for the underlying `LazyVerticalGrid` |
| `contentPadding` | `PaddingValues` | `PaddingValues()` | Padding around the grid content |
| `verticalArrangement` | `Arrangement.Vertical` | `spacedBy(0.dp)` | Vertical spacing between items |
| `horizontalArrangement` | `Arrangement.Horizontal` | `spacedBy(0.dp)` | Horizontal spacing between items |
| `thresholdFraction` | `Float` | `0.45f` | Scale change fraction required to trigger column snap |
| `transitionSpec` | `ColumnTransitionSpec` | `None` | Transition animation between column layouts |
| `gestureEnabled` | `Boolean` | `true` | Whether pinch gesture is active |
| `onColumnChanged` | `((Int) -> Unit)?` | `null` | Callback when column count changes |
| `content` | `LazyGridScope.() -> Unit` | *required* | Grid content using LazyGridScope DSL |

## Notes

- The `content` lambda uses the standard `LazyGridScope` DSL — `items()`, `item()`, `stickyHeader()` etc.
- Passing a custom `gridState` lets you observe scroll position or programmatically scroll
- The breathing scale effect is applied automatically via `graphicsLayer`
