---
title: Transitions
description: Configure how the grid transitions between column counts
---

## ColumnTransitionSpec

Controls the visual transition when the column count changes.

### None (default)

Google Photos style — instant reflow, no animation. This is the default because it matches the behavior users expect from photo grid apps.

```kotlin
PinchGrid(
    state = state,
    transitionSpec = ColumnTransitionSpec.None,
) { /* content */ }
```

### Crossfade

Smooth opacity transition between the old and new column layouts.

```kotlin
PinchGrid(
    state = state,
    transitionSpec = ColumnTransitionSpec.Crossfade(durationMillis = 200),
) { /* content */ }
```

The crossfade uses `AnimatedContent` with `fadeIn`/`fadeOut` internally.

## Choosing a transition

| Transition | Use case |
|-----------|----------|
| `None` | Photo galleries, media grids — instant feedback feels right |
| `Crossfade` | Content grids, dashboards — smoother but slightly delayed |
