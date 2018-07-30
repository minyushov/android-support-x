package com.minyushov.support.widget

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.os.Build
import android.widget.ProgressBar
import com.minyushov.support.view.TintableProgressBar

fun ProgressBar.setSupportIndeterminateTintList(tint: ColorStateList?) =
  when {
    Build.VERSION.SDK_INT >= 21 -> indeterminateTintList = tint
    this is TintableProgressBar -> setSupportIndeterminateTintList(tint)
    else -> Unit
  }

fun ProgressBar.getSupportIndeterminateTintList(): ColorStateList? =
  when {
    Build.VERSION.SDK_INT >= 21 -> indeterminateTintList
    this is TintableProgressBar -> getSupportIndeterminateTintList()
    else -> null
  }

fun ProgressBar.setSupportIndeterminateTintMode(tintMode: PorterDuff.Mode) =
  when {
    Build.VERSION.SDK_INT >= 21 -> indeterminateTintMode = tintMode
    this is TintableProgressBar -> setSupportIndeterminateTintMode(tintMode)
    else -> Unit
  }

fun ProgressBar.getSupportIndeterminateTintMode(): PorterDuff.Mode =
  when {
    Build.VERSION.SDK_INT >= 21 -> indeterminateTintMode
    this is TintableProgressBar -> getSupportIndeterminateTintMode()
    else -> ProgressTintHelper.DEFAULT_TINT_MODE
  }

fun ProgressBar.setSupportProgressTintList(tint: ColorStateList?) =
  when {
    Build.VERSION.SDK_INT >= 22 -> progressTintList = tint
    this is TintableProgressBar -> setSupportProgressTintList(tint)
    else -> Unit
  }

fun ProgressBar.getSupportProgressTintList(): ColorStateList? =
  when {
    Build.VERSION.SDK_INT >= 22 -> progressTintList
    this is TintableProgressBar -> getSupportProgressTintList()
    else -> null
  }

fun ProgressBar.setSupportProgressTintMode(tintMode: PorterDuff.Mode) =
  when {
    Build.VERSION.SDK_INT >= 22 -> progressTintMode = tintMode
    this is TintableProgressBar -> setSupportProgressTintMode(tintMode)
    else -> Unit
  }

fun ProgressBar.getSupportProgressTintMode(): PorterDuff.Mode =
  when {
    Build.VERSION.SDK_INT >= 22 -> progressTintMode
    this is TintableProgressBar -> getSupportProgressTintMode()
    else -> ProgressTintHelper.DEFAULT_TINT_MODE
  }

fun ProgressBar.setSupportProgressBackgroundTintList(tint: ColorStateList?) =
  when {
    Build.VERSION.SDK_INT >= 22 -> progressBackgroundTintList = tint
    this is TintableProgressBar -> setSupportProgressBackgroundTintList(tint)
    else -> Unit
  }

fun ProgressBar.getSupportProgressBackgroundTintList(): ColorStateList? =
  when {
    Build.VERSION.SDK_INT >= 22 -> progressBackgroundTintList
    this is TintableProgressBar -> getSupportProgressBackgroundTintList()
    else -> null
  }

fun ProgressBar.setSupportProgressBackgroundTintMode(tintMode: PorterDuff.Mode) =
  when {
    Build.VERSION.SDK_INT >= 22 -> progressBackgroundTintMode = tintMode
    this is TintableProgressBar -> setSupportProgressBackgroundTintMode(tintMode)
    else -> Unit
  }

fun ProgressBar.getSupportProgressBackgroundTintMode(): PorterDuff.Mode =
  when {
    Build.VERSION.SDK_INT >= 22 -> progressBackgroundTintMode
    this is TintableProgressBar -> getSupportProgressBackgroundTintMode()
    else -> ProgressTintHelper.DEFAULT_TINT_MODE
  }

fun ProgressBar.setSupportSecondaryProgressTintList(tint: ColorStateList?) =
  when {
    Build.VERSION.SDK_INT >= 22 -> secondaryProgressTintList = tint
    this is TintableProgressBar -> setSupportSecondaryProgressTintList(tint)
    else -> Unit
  }

fun ProgressBar.getSupportSecondaryProgressTintList(): ColorStateList? =
  when {
    Build.VERSION.SDK_INT >= 22 -> secondaryProgressTintList
    this is TintableProgressBar -> getSupportSecondaryProgressTintList()
    else -> null
  }

fun ProgressBar.setSupportSecondaryProgressTintMode(tintMode: PorterDuff.Mode) =
  when {
    Build.VERSION.SDK_INT >= 22 -> secondaryProgressTintMode = tintMode
    this is TintableProgressBar -> setSupportSecondaryProgressTintMode(tintMode)
    else -> Unit
  }

fun ProgressBar.getSupportSecondaryProgressTintMode(): PorterDuff.Mode =
  when {
    Build.VERSION.SDK_INT >= 22 -> secondaryProgressTintMode
    this is TintableProgressBar -> getSupportSecondaryProgressTintMode()
    else -> ProgressTintHelper.DEFAULT_TINT_MODE
  }