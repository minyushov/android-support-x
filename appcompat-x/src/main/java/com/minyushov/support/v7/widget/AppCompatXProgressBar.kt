package com.minyushov.support.v7.widget

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.support.v7.widget.TintContextWrapper
import android.util.AttributeSet
import android.widget.ProgressBar
import com.minyushov.support.v7.view.TintableProgressBar

@SuppressLint("RestrictedApi")
class AppCompatXProgressBar : ProgressBar, TintableProgressBar {
  private val progressTintHelper: ProgressTintHelper? = ProgressTintHelper.create(this)

  constructor(context: Context) : this(context, null)
  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, android.R.attr.progressBarStyle)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(TintContextWrapper.wrap(context), attrs, defStyleAttr) {
    progressTintHelper?.loadFromAttributes(attrs, defStyleAttr)
  }

  override fun setSupportIndeterminateTintList(tint: ColorStateList?) {
    progressTintHelper?.setIndeterminateTintList(tint)
  }

  override fun getSupportIndeterminateTintList(): ColorStateList? {
    return progressTintHelper?.getIndeterminateTintList()
  }

  override fun setSupportIndeterminateTintMode(tintMode: PorterDuff.Mode) {
    progressTintHelper?.setIndeterminateTintMode(tintMode)
  }

  override fun getSupportIndeterminateTintMode(): PorterDuff.Mode {
    return progressTintHelper?.getIndeterminateTintMode() ?: ProgressTintHelper.DEFAULT_TINT_MODE
  }

  override fun setSupportProgressTintList(tint: ColorStateList?) {
    progressTintHelper?.setProgressTintList(tint)
  }

  override fun getSupportProgressTintList(): ColorStateList? {
    return progressTintHelper?.getProgressTintList()
  }

  override fun setSupportProgressTintMode(tintMode: PorterDuff.Mode) {
    progressTintHelper?.setProgressTintMode(tintMode)
  }

  override fun getSupportProgressTintMode(): PorterDuff.Mode {
    return progressTintHelper?.getProgressTintMode() ?: ProgressTintHelper.DEFAULT_TINT_MODE
  }

  override fun setSupportProgressBackgroundTintList(tint: ColorStateList?) {
    progressTintHelper?.setProgressBackgroundTintList(tint)
  }

  override fun getSupportProgressBackgroundTintList(): ColorStateList? {
    return progressTintHelper?.getProgressBackgroundTintList()
  }

  override fun setSupportProgressBackgroundTintMode(tintMode: PorterDuff.Mode) {
    progressTintHelper?.setProgressBackgroundTintMode(tintMode)
  }

  override fun getSupportProgressBackgroundTintMode(): PorterDuff.Mode {
    return progressTintHelper?.getProgressBackgroundTintMode() ?: ProgressTintHelper.DEFAULT_TINT_MODE
  }

  override fun setSupportSecondaryProgressTintList(tint: ColorStateList?) {
    progressTintHelper?.setSecondaryProgressTintList(tint)
  }

  override fun getSupportSecondaryProgressTintList(): ColorStateList? {
    return progressTintHelper?.getSecondaryProgressTintList()
  }

  override fun setSupportSecondaryProgressTintMode(tintMode: PorterDuff.Mode) {
    progressTintHelper?.setSecondaryProgressTintMode(tintMode)
  }

  override fun getSupportSecondaryProgressTintMode(): PorterDuff.Mode {
    return progressTintHelper?.getSecondaryProgressTintMode() ?: ProgressTintHelper.DEFAULT_TINT_MODE
  }
}