package com.minyushov.support.v7.widget

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.TintContextWrapper
import android.util.AttributeSet
import com.minyushov.support.v7.view.TintableCompoundDrawableView

@SuppressLint("RestrictedApi")
open class AppCompatXTextView : AppCompatTextView, TintableCompoundDrawableView {
  private val compoundDrawableHelper: CompoundDrawableHelper? = CompoundDrawableHelper.create(this)

  constructor(context: Context) : this(context, null)
  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, android.R.attr.textViewStyle)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(TintContextWrapper.wrap(context), attrs, defStyleAttr) {
    compoundDrawableHelper?.loadFromAttributes(attrs, defStyleAttr)
  }

  override fun setSupportCompoundDrawableTintList(tint: ColorStateList?) {
    compoundDrawableHelper?.setCompoundDrawableTintList(tint)
  }

  override fun getSupportCompoundDrawableTintList(): ColorStateList? {
    return compoundDrawableHelper?.getCompoundDrawableTintList()
  }

  override fun setSupportCompoundDrawableTintMode(tintMode: PorterDuff.Mode) {
    compoundDrawableHelper?.setCompoundDrawableTintMode(tintMode)
  }

  override fun getSupportCompoundDrawableTintMode(): PorterDuff.Mode {
    return compoundDrawableHelper?.getCompoundDrawableTintMode() ?: CompoundDrawableHelper.DEFAULT_TINT_MODE
  }

  override fun drawableStateChanged() {
    super.drawableStateChanged()
    compoundDrawableHelper?.applyCompoundDrawableTint()
  }
}