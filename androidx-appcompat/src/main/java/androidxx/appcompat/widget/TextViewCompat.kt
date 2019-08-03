@file:JvmName("TextViewCompat")

package androidxx.appcompat.widget

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.os.Build
import android.widget.TextView
import androidxx.appcompat.view.TintableCompoundDrawableView

// Compound drawable tint is supported by the framework since API 23,
// but it's not working for relative compound drawables (drawableStart, drawableEnd)
// https://issuetracker.google.com/issues/129907900

var TextView.compoundDrawableTintCompat: ColorStateList?
  @JvmName("setCompoundDrawableTintList")
  set(value) =
    when {
      Build.VERSION.SDK_INT >= 24 -> compoundDrawableTintList = value
      this is TintableCompoundDrawableView -> setSupportCompoundDrawableTintList(value)
      else -> Unit
    }
  @JvmName("getCompoundDrawableTintList")
  get() =
    when {
      Build.VERSION.SDK_INT >= 24 -> compoundDrawableTintList
      this is TintableCompoundDrawableView -> getSupportCompoundDrawableTintList()
      else -> null
    }

var TextView.compoundDrawableTintModeCompat: PorterDuff.Mode
  @JvmName("setCompoundDrawableTintMode")
  set(value) =
    when {
      Build.VERSION.SDK_INT >= 24 -> compoundDrawableTintMode = value
      this is TintableCompoundDrawableView -> setSupportCompoundDrawableTintMode(value)
      else -> Unit
    }
  @JvmName("getCompoundDrawableTintMode")
  get() =
    when {
      Build.VERSION.SDK_INT >= 24 -> compoundDrawableTintMode
      this is TintableCompoundDrawableView -> getSupportCompoundDrawableTintMode()
      else -> DEFAULT_TINT_MODE
    }