@file:JvmName("ProgressBarCompat")

package androidxx.appcompat.widget

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.os.Build
import android.widget.ProgressBar
import androidxx.appcompat.view.TintableProgressBar

var ProgressBar.indeterminateTintListCompat: ColorStateList?
  @JvmName("setIndeterminateTintList")
  set(value) =
    when {
      Build.VERSION.SDK_INT >= 21 -> indeterminateTintList = value
      this is TintableProgressBar -> setSupportIndeterminateTintList(value)
      else -> Unit
    }
  @JvmName("getIndeterminateTintList")
  get() =
    when {
      Build.VERSION.SDK_INT >= 21 -> indeterminateTintList
      this is TintableProgressBar -> getSupportIndeterminateTintList()
      else -> null
    }

var ProgressBar.indeterminateTintModeCompat: PorterDuff.Mode?
  @JvmName("setIndeterminateTintMode")
  set(value) =
    when {
      Build.VERSION.SDK_INT >= 21 -> indeterminateTintMode = value
      this is TintableProgressBar -> setSupportIndeterminateTintMode(value)
      else -> Unit
    }
  @JvmName("getIndeterminateTintMode")
  get() =
    when {
      Build.VERSION.SDK_INT >= 21 -> indeterminateTintMode
      this is TintableProgressBar -> getSupportIndeterminateTintMode()
      else -> DEFAULT_TINT_MODE
    }

var ProgressBar.progressTintListCompat: ColorStateList?
  @JvmName("setProgressTintList")
  set(value) =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressTintList = value
      this is TintableProgressBar -> setSupportProgressTintList(value)
      else -> Unit
    }
  @JvmName("getProgressTintList")
  get() =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressTintList
      this is TintableProgressBar -> getSupportProgressTintList()
      else -> null
    }

var ProgressBar.progressTintModeCompat: PorterDuff.Mode?
  @JvmName("setProgressTintMode")
  set(value) =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressTintMode = value
      this is TintableProgressBar -> setSupportProgressTintMode(value)
      else -> Unit
    }
  @JvmName("getProgressTintMode")
  get() =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressTintMode
      this is TintableProgressBar -> getSupportProgressTintMode()
      else -> DEFAULT_TINT_MODE
    }

var ProgressBar.progressBackgroundTintListCompat: ColorStateList?
  @JvmName("setProgressBackgroundTintList")
  set(value) =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressBackgroundTintList = value
      this is TintableProgressBar -> setSupportProgressBackgroundTintList(value)
      else -> Unit
    }
  @JvmName("getProgressBackgroundTintList")
  get() =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressBackgroundTintList
      this is TintableProgressBar -> getSupportProgressBackgroundTintList()
      else -> null
    }

var ProgressBar.progressBackgroundTintModeCompat: PorterDuff.Mode?
  @JvmName("setProgressBackgroundTintMode")
  set(value) =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressBackgroundTintMode = value
      this is TintableProgressBar -> setSupportProgressBackgroundTintMode(value)
      else -> Unit
    }
  @JvmName("getProgressBackgroundTintMode")
  get() =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressBackgroundTintMode
      this is TintableProgressBar -> getSupportProgressBackgroundTintMode()
      else -> DEFAULT_TINT_MODE
    }

var ProgressBar.secondaryProgressTintListCompat: ColorStateList?
  @JvmName("setSecondaryProgressTintList")
  set(value) =
    when {
      Build.VERSION.SDK_INT >= 22 -> secondaryProgressTintList = value
      this is TintableProgressBar -> setSupportSecondaryProgressTintList(value)
      else -> Unit
    }
  @JvmName("getSecondaryProgressTintList")
  get() =
    when {
      Build.VERSION.SDK_INT >= 22 -> secondaryProgressTintList
      this is TintableProgressBar -> getSupportSecondaryProgressTintList()
      else -> null
    }

var ProgressBar.secondaryProgressTintModeCompat: PorterDuff.Mode?
  @JvmName("setSecondaryProgressTintMode")
  set(value) =
    when {
      Build.VERSION.SDK_INT >= 22 -> secondaryProgressTintMode = value
      this is TintableProgressBar -> setSupportSecondaryProgressTintMode(value)
      else -> Unit
    }
  @JvmName("getSecondaryProgressTintMode")
  get() =
    when {
      Build.VERSION.SDK_INT >= 22 -> secondaryProgressTintMode
      this is TintableProgressBar -> getSupportSecondaryProgressTintMode()
      else -> DEFAULT_TINT_MODE
    }