# snapx-layout

Snapshot xml layout to Bitmap for Android.

[![](https://jitpack.io/v/prongbang/snapx-layout.svg)](https://jitpack.io/#prongbang/snapx-layout)

## Preview

![img.png](img.png)

## Setup

- `build.gradle`

```groovy
buildscript {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

- `settings.gradle`

```groovy
dependencyResolutionManagement {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

- `app/build.gradle`

```groovy
implementation 'com.github.prongbang:snapx-layout:1.0.0'
```

## How to use

- With viewBinding

```kotlin
private fun snapshotLayout() {
    val snapXLayout = SnapshotXLayout(context)

    // Initial view
    val view = snapXLayout.inflate(R.layout.view_biz_card)
    val bizBinding = ViewBizCardBinding.bind(view)

    // snapshot
    val bitmap = snapXLayout.snapshot(bizBinding)
}
```

- With view

```kotlin
private fun snapshotLayout() {
    val snapXLayout = SnapshotXLayout(context)

    // Initial view
    val view = snapXLayout.inflate(R.layout.view_biz_card)

    // snapshot
    val bitmap = snapXLayout.snapshot(view)
}
```