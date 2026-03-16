---
title: Haptic Feedback
description: Platform-native haptics on every column snap
---

Haptic feedback fires automatically on every column snap — no configuration needed.

## Platform implementation

| Platform | Implementation |
|----------|---------------|
| Android | `View.performHapticFeedback(CLOCK_TICK)` |
| iOS | `UISelectionFeedbackGenerator.selectionChanged()` |
| Desktop | No-op |
| Web | No-op |

## Architecture

Haptics use Kotlin `expect`/`actual` declarations:

- **Common**: `expect fun rememberHapticFeedback(): () -> Unit`
- **Android**: Uses `LocalView.current` to access the Android View for haptic feedback
- **iOS**: Creates a `UISelectionFeedbackGenerator` and calls `selectionChanged()`
- **JVM/Wasm**: No-op lambdas

The haptic trigger is stored in `PinchGridState` and invoked whenever the column count changes — both from gesture snaps and programmatic `snapToColumn()` calls.
