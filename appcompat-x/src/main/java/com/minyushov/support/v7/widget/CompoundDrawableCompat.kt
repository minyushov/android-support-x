package com.minyushov.support.v7.widget

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.os.Build
import android.support.annotation.RequiresApi
import android.widget.TextView
import com.minyushov.support.v7.view.TintableCompoundDrawableView

fun TextView.setSupportCompoundDrawableTintList(tint: ColorStateList?) {
  IMPL.setCompoundDrawableTintList(this, tint)
}

fun TextView.getSupportCompoundDrawableTintList(): ColorStateList? {
  return IMPL.getCompoundDrawableTintList(this)
}

fun TextView.setSupportCompoundDrawableTintMode(tintMode: PorterDuff.Mode) {
  IMPL.setCompoundDrawableTintMode(this, tintMode)
}

fun TextView.getSupportCompoundDrawableTintMode(): PorterDuff.Mode {
  return IMPL.getCompoundDrawableTintMode(this)
}

private val IMPL =
  if (Build.VERSION.SDK_INT >= 23) {
    CompoundDrawableCompatV23()
  } else {
    CompoundDrawableCompat()
  }

internal open class CompoundDrawableCompat {
  open fun setCompoundDrawableTintList(view: TextView, tint: ColorStateList?) {
    if (view is TintableCompoundDrawableView) {
      view.setSupportCompoundDrawableTintList(tint)
    }
  }

  open fun getCompoundDrawableTintList(view: TextView): ColorStateList? {
    if (view is TintableCompoundDrawableView) {
      return view.getSupportCompoundDrawableTintList()
    }
    return null
  }

  open fun setCompoundDrawableTintMode(view: TextView, tintMode: PorterDuff.Mode) {
    if (view is TintableCompoundDrawableView) {
      view.setSupportCompoundDrawableTintMode(tintMode)
    }
  }

  open fun getCompoundDrawableTintMode(view: TextView): PorterDuff.Mode {
    if (view is TintableCompoundDrawableView) {
      return view.getSupportCompoundDrawableTintMode()
    }
    return CompoundDrawableHelper.DEFAULT_TINT_MODE
  }
}

@RequiresApi(Build.VERSION_CODES.M)
internal class CompoundDrawableCompatV23 : CompoundDrawableCompat() {
  override fun setCompoundDrawableTintList(view: TextView, tint: ColorStateList?) {
    view.compoundDrawableTintList = tint
  }

  override fun getCompoundDrawableTintList(view: TextView): ColorStateList? =
    view.compoundDrawableTintList

  override fun setCompoundDrawableTintMode(view: TextView, tintMode: PorterDuff.Mode) {
    view.compoundDrawableTintMode = tintMode
  }

  override fun getCompoundDrawableTintMode(view: TextView): PorterDuff.Mode =
    view.compoundDrawableTintMode ?: CompoundDrawableHelper.DEFAULT_TINT_MODE
}