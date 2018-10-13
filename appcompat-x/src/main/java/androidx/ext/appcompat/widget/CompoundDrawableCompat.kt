package androidx.ext.appcompat.widget

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.os.Build
import android.widget.TextView
import androidx.ext.appcompat.view.TintableCompoundDrawableView

// Compound drawable tint is supported by the framework since API 23,
// but it's not working for relative compound drawables (drawableStart, drawableEnd)
object CompoundDrawableCompat {
  @JvmStatic
  fun setCompoundDrawableTintList(view: TextView, tint: ColorStateList?) =
    when {
      Build.VERSION.SDK_INT >= 24 -> view.compoundDrawableTintList = tint
      view is TintableCompoundDrawableView -> view.setSupportCompoundDrawableTintList(tint)
      else -> Unit
    }

  @JvmStatic
  fun getCompoundDrawableTintList(view: TextView): ColorStateList? =
    when {
      Build.VERSION.SDK_INT >= 24 -> view.compoundDrawableTintList
      view is TintableCompoundDrawableView -> view.getSupportCompoundDrawableTintList()
      else -> null
    }

  @JvmStatic
  fun setCompoundDrawableTintMode(view: TextView, tintMode: PorterDuff.Mode) =
    when {
      Build.VERSION.SDK_INT >= 24 -> view.compoundDrawableTintMode = tintMode
      view is TintableCompoundDrawableView -> view.setSupportCompoundDrawableTintMode(tintMode)
      else -> Unit
    }

  @JvmStatic
  fun getCompoundDrawableTintMode(view: TextView): PorterDuff.Mode =
    when {
      Build.VERSION.SDK_INT >= 24 -> view.compoundDrawableTintMode
      view is TintableCompoundDrawableView -> view.getSupportCompoundDrawableTintMode()
      else -> CompoundDrawableHelper.DEFAULT_TINT_MODE
    }
}