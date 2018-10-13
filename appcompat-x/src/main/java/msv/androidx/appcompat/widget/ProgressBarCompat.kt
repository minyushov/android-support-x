package msv.androidx.appcompat.widget

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.os.Build
import android.widget.ProgressBar
import msv.androidx.appcompat.view.TintableProgressBar

object ProgressBarCompat {
  @JvmStatic
  fun setIndeterminateTintList(progressBar: ProgressBar, tint: ColorStateList?) =
    when {
      Build.VERSION.SDK_INT >= 21 -> progressBar.indeterminateTintList = tint
      progressBar is TintableProgressBar -> progressBar.setSupportIndeterminateTintList(tint)
      else -> Unit
    }

  @JvmStatic
  fun getIndeterminateTintList(progressBar: ProgressBar): ColorStateList? =
    when {
      Build.VERSION.SDK_INT >= 21 -> progressBar.indeterminateTintList
      progressBar is TintableProgressBar -> progressBar.getSupportIndeterminateTintList()
      else -> null
    }

  @JvmStatic
  fun setIndeterminateTintMode(progressBar: ProgressBar, tintMode: PorterDuff.Mode?) =
    when {
      Build.VERSION.SDK_INT >= 21 -> progressBar.indeterminateTintMode = tintMode
      progressBar is TintableProgressBar -> progressBar.setSupportIndeterminateTintMode(tintMode)
      else -> Unit
    }

  @JvmStatic
  fun getIndeterminateTintMode(progressBar: ProgressBar): PorterDuff.Mode? =
    when {
      Build.VERSION.SDK_INT >= 21 -> progressBar.indeterminateTintMode
      progressBar is TintableProgressBar -> progressBar.getSupportIndeterminateTintMode()
      else -> ProgressTintHelper.DEFAULT_TINT_MODE
    }

  @JvmStatic
  fun setProgressTintList(progressBar: ProgressBar, tint: ColorStateList?) =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressBar.progressTintList = tint
      progressBar is TintableProgressBar -> progressBar.setSupportProgressTintList(tint)
      else -> Unit
    }

  @JvmStatic
  fun getProgressTintList(progressBar: ProgressBar): ColorStateList? =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressBar.progressTintList
      progressBar is TintableProgressBar -> progressBar.getSupportProgressTintList()
      else -> null
    }

  @JvmStatic
  fun setProgressTintMode(progressBar: ProgressBar, tintMode: PorterDuff.Mode?) =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressBar.progressTintMode = tintMode
      progressBar is TintableProgressBar -> progressBar.setSupportProgressTintMode(tintMode)
      else -> Unit
    }

  @JvmStatic
  fun getProgressTintMode(progressBar: ProgressBar): PorterDuff.Mode? =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressBar.progressTintMode
      progressBar is TintableProgressBar -> progressBar.getSupportProgressTintMode()
      else -> ProgressTintHelper.DEFAULT_TINT_MODE
    }

  @JvmStatic
  fun setProgressBackgroundTintList(progressBar: ProgressBar, tint: ColorStateList?) =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressBar.progressBackgroundTintList = tint
      progressBar is TintableProgressBar -> progressBar.setSupportProgressBackgroundTintList(tint)
      else -> Unit
    }

  @JvmStatic
  fun getProgressBackgroundTintList(progressBar: ProgressBar): ColorStateList? =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressBar.progressBackgroundTintList
      progressBar is TintableProgressBar -> progressBar.getSupportProgressBackgroundTintList()
      else -> null
    }

  @JvmStatic
  fun setProgressBackgroundTintMode(progressBar: ProgressBar, tintMode: PorterDuff.Mode?) =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressBar.progressBackgroundTintMode = tintMode
      progressBar is TintableProgressBar -> progressBar.setSupportProgressBackgroundTintMode(tintMode)
      else -> Unit
    }

  @JvmStatic
  fun getProgressBackgroundTintMode(progressBar: ProgressBar): PorterDuff.Mode? =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressBar.progressBackgroundTintMode
      progressBar is TintableProgressBar -> progressBar.getSupportProgressBackgroundTintMode()
      else -> ProgressTintHelper.DEFAULT_TINT_MODE
    }

  @JvmStatic
  fun setSecondaryProgressTintList(progressBar: ProgressBar, tint: ColorStateList?) =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressBar.secondaryProgressTintList = tint
      progressBar is TintableProgressBar -> progressBar.setSupportSecondaryProgressTintList(tint)
      else -> Unit
    }

  @JvmStatic
  fun getSecondaryProgressTintList(progressBar: ProgressBar): ColorStateList? =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressBar.secondaryProgressTintList
      progressBar is TintableProgressBar -> progressBar.getSupportSecondaryProgressTintList()
      else -> null
    }

  @JvmStatic
  fun setSecondaryProgressTintMode(progressBar: ProgressBar, tintMode: PorterDuff.Mode?) =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressBar.secondaryProgressTintMode = tintMode
      progressBar is TintableProgressBar -> progressBar.setSupportSecondaryProgressTintMode(tintMode)
      else -> Unit
    }

  @JvmStatic
  fun getSecondaryProgressTintMode(progressBar: ProgressBar): PorterDuff.Mode? =
    when {
      Build.VERSION.SDK_INT >= 22 -> progressBar.secondaryProgressTintMode
      progressBar is TintableProgressBar -> progressBar.getSupportSecondaryProgressTintMode()
      else -> ProgressTintHelper.DEFAULT_TINT_MODE
    }
}