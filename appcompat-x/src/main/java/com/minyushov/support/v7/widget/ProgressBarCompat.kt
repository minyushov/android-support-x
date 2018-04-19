package com.minyushov.support.v7.widget

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.os.Build
import android.support.annotation.RequiresApi
import android.widget.ProgressBar
import com.minyushov.support.v7.view.TintableProgressBar

fun ProgressBar.setSupportIndeterminateTintList(tint: ColorStateList?) =
  IMPL.setIndeterminateTintList(this, tint)

fun ProgressBar.getSupportIndeterminateTintList(): ColorStateList? =
  IMPL.getIndeterminateTintList(this)

fun ProgressBar.setSupportIndeterminateTintMode(tintMode: PorterDuff.Mode) =
  IMPL.setIndeterminateTintMode(this, tintMode)

fun ProgressBar.getSupportIndeterminateTintMode(): PorterDuff.Mode =
  IMPL.getIndeterminateTintMode(this)

fun ProgressBar.setSupportProgressTintList(tint: ColorStateList?) =
  IMPL.setProgressTintList(this, tint)

fun ProgressBar.getSupportProgressTintList(): ColorStateList? =
  IMPL.getProgressTintList(this)

fun ProgressBar.setSupportProgressTintMode(tintMode: PorterDuff.Mode) =
  IMPL.setProgressTintMode(this, tintMode)

fun ProgressBar.getSupportProgressTintMode(): PorterDuff.Mode =
  IMPL.getProgressTintMode(this)

fun ProgressBar.setSupportProgressBackgroundTintList(tint: ColorStateList?) =
  IMPL.setProgressBackgroundTintList(this, tint)

fun ProgressBar.getSupportProgressBackgroundTintList(): ColorStateList? =
  IMPL.getProgressBackgroundTintList(this)

fun ProgressBar.setSupportProgressBackgroundTintMode(tintMode: PorterDuff.Mode) =
  IMPL.setProgressBackgroundTintMode(this, tintMode)

fun ProgressBar.getSupportProgressBackgroundTintMode(): PorterDuff.Mode =
  IMPL.getProgressBackgroundTintMode(this)

fun ProgressBar.setSupportSecondaryProgressTintList(tint: ColorStateList?) =
  IMPL.setSecondaryProgressTintList(this, tint)

fun ProgressBar.getSupportSecondaryProgressTintList(): ColorStateList? =
  IMPL.getSecondaryProgressTintList(this)

fun ProgressBar.setSupportSecondaryProgressTintMode(tintMode: PorterDuff.Mode) =
  IMPL.setSecondaryProgressTintMode(this, tintMode)

fun ProgressBar.getSupportSecondaryProgressTintMode(): PorterDuff.Mode =
  IMPL.getSecondaryProgressTintMode(this)

private val IMPL =
  if (Build.VERSION.SDK_INT >= 21) {
    ProgressBarCompatV21()
  } else {
    ProgressBarCompat()
  }

internal open class ProgressBarCompat {
  open fun setIndeterminateTintList(view: ProgressBar, tint: ColorStateList?) {
    if (view is TintableProgressBar) {
      view.setSupportIndeterminateTintList(tint)
    }
  }

  open fun getIndeterminateTintList(view: ProgressBar): ColorStateList? {
    if (view is TintableProgressBar) {
      return view.getSupportIndeterminateTintList()
    }
    return null
  }

  open fun setIndeterminateTintMode(view: ProgressBar, tintMode: PorterDuff.Mode) {
    if (view is TintableProgressBar) {
      view.setSupportIndeterminateTintMode(tintMode)
    }
  }

  open fun getIndeterminateTintMode(view: ProgressBar): PorterDuff.Mode {
    if (view is TintableProgressBar) {
      return view.getSupportIndeterminateTintMode()
    }
    return ProgressTintHelper.DEFAULT_TINT_MODE
  }

  open fun setProgressTintList(view: ProgressBar, tint: ColorStateList?) {
    if (view is TintableProgressBar) {
      view.setSupportProgressTintList(tint)
    }
  }

  open fun getProgressTintList(view: ProgressBar): ColorStateList? {
    if (view is TintableProgressBar) {
      return view.getSupportProgressTintList()
    }
    return null
  }

  open fun setProgressTintMode(view: ProgressBar, tintMode: PorterDuff.Mode) {
    if (view is TintableProgressBar) {
      view.setSupportProgressTintMode(tintMode)
    }
  }

  open fun getProgressTintMode(view: ProgressBar): PorterDuff.Mode {
    if (view is TintableProgressBar) {
      return view.getSupportProgressTintMode()
    }
    return ProgressTintHelper.DEFAULT_TINT_MODE
  }

  open fun setProgressBackgroundTintList(view: ProgressBar, tint: ColorStateList?) {
    if (view is TintableProgressBar) {
      view.setSupportProgressBackgroundTintList(tint)
    }
  }

  open fun getProgressBackgroundTintList(view: ProgressBar): ColorStateList? {
    if (view is TintableProgressBar) {
      return view.getSupportProgressBackgroundTintList()
    }
    return null
  }

  open fun setProgressBackgroundTintMode(view: ProgressBar, tintMode: PorterDuff.Mode) {
    if (view is TintableProgressBar) {
      view.setSupportProgressBackgroundTintMode(tintMode)
    }
  }

  open fun getProgressBackgroundTintMode(view: ProgressBar): PorterDuff.Mode {
    if (view is TintableProgressBar) {
      return view.getSupportProgressBackgroundTintMode()
    }
    return ProgressTintHelper.DEFAULT_TINT_MODE
  }

  open fun setSecondaryProgressTintList(view: ProgressBar, tint: ColorStateList?) {
    if (view is TintableProgressBar) {
      view.setSupportSecondaryProgressTintList(tint)
    }
  }

  open fun getSecondaryProgressTintList(view: ProgressBar): ColorStateList? {
    if (view is TintableProgressBar) {
      return view.getSupportSecondaryProgressTintList()
    }
    return null
  }

  open fun setSecondaryProgressTintMode(view: ProgressBar, tintMode: PorterDuff.Mode) {
    if (view is TintableProgressBar) {
      view.setSupportSecondaryProgressTintMode(tintMode)
    }
  }

  open fun getSecondaryProgressTintMode(view: ProgressBar): PorterDuff.Mode {
    if (view is TintableProgressBar) {
      return view.getSupportProgressTintMode()
    }
    return ProgressTintHelper.DEFAULT_TINT_MODE
  }
}

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
internal class ProgressBarCompatV21 : ProgressBarCompat() {
  override fun setIndeterminateTintList(view: ProgressBar, tint: ColorStateList?) {
    view.indeterminateTintList = tint
  }

  override fun getIndeterminateTintList(view: ProgressBar): ColorStateList? =
    view.indeterminateTintList

  override fun setIndeterminateTintMode(view: ProgressBar, tintMode: PorterDuff.Mode) {
    view.indeterminateTintMode = tintMode
  }

  override fun getIndeterminateTintMode(view: ProgressBar): PorterDuff.Mode =
    view.indeterminateTintMode ?: ProgressTintHelper.DEFAULT_TINT_MODE

  override fun setProgressTintList(view: ProgressBar, tint: ColorStateList?) {
    view.progressTintList = tint
  }

  override fun getProgressTintList(view: ProgressBar): ColorStateList? =
    view.progressTintList

  override fun setProgressTintMode(view: ProgressBar, tintMode: PorterDuff.Mode) {
    view.progressTintMode = tintMode
  }

  override fun getProgressTintMode(view: ProgressBar): PorterDuff.Mode =
    view.progressTintMode ?: ProgressTintHelper.DEFAULT_TINT_MODE

  override fun setProgressBackgroundTintList(view: ProgressBar, tint: ColorStateList?) {
    view.progressBackgroundTintList = tint
  }

  override fun getProgressBackgroundTintList(view: ProgressBar): ColorStateList? =
    view.progressBackgroundTintList

  override fun setProgressBackgroundTintMode(view: ProgressBar, tintMode: PorterDuff.Mode) {
    view.progressBackgroundTintMode = tintMode
  }

  override fun getProgressBackgroundTintMode(view: ProgressBar): PorterDuff.Mode =
    view.progressBackgroundTintMode ?: ProgressTintHelper.DEFAULT_TINT_MODE

  override fun setSecondaryProgressTintList(view: ProgressBar, tint: ColorStateList?) {
    view.secondaryProgressTintList = tint
  }

  override fun getSecondaryProgressTintList(view: ProgressBar): ColorStateList? =
    view.secondaryProgressTintList

  override fun setSecondaryProgressTintMode(view: ProgressBar, tintMode: PorterDuff.Mode) {
    view.secondaryProgressTintMode = tintMode
  }

  override fun getSecondaryProgressTintMode(view: ProgressBar): PorterDuff.Mode =
    view.secondaryProgressTintMode ?: ProgressTintHelper.DEFAULT_TINT_MODE
}