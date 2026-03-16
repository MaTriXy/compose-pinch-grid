---
title: Installation
description: Add PinchGrid to your project
---

## Gradle (Kotlin DSL)

```kotlin
dependencies {
    implementation("io.github.aldefy:pinch-grid:1.0.0-alpha01")
}
```

## Version Catalog

```toml
# gradle/libs.versions.toml
[versions]
pinch-grid = "1.0.0-alpha01"

[libraries]
pinch-grid = { group = "io.github.aldefy", name = "pinch-grid", version.ref = "pinch-grid" }
```

Then in your `build.gradle.kts`:

```kotlin
dependencies {
    implementation(libs.pinch.grid)
}
```

## Platform artifacts

The library automatically resolves the correct artifact for your platform:

| Platform | Artifact |
|----------|----------|
| Android | `pinch-grid-android` (AAR) |
| JVM / Desktop | `pinch-grid-jvm` (JAR) |
| iOS arm64 | `pinch-grid-iosarm64` (klib) |
| iOS simulator | `pinch-grid-iossimulatorarm64` (klib) |
| iOS x64 | `pinch-grid-iosx64` (klib) |
| Web (Wasm) | `pinch-grid-wasm-js` (klib) |

## Requirements

- Kotlin 2.1.20+
- Compose Multiplatform 1.8.0+
- Android: minSdk 23, compileSdk 35
