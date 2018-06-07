package msv.androidx.appcompat.widget

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.TextView
import androidx.appcompat.widget.DrawableUtils
import androidx.appcompat.widget.TintTypedArray
import androidx.core.graphics.drawable.DrawableCompat
import msv.androidx.appcompat.R

internal open class CompoundDrawableHelper(private val view: TextView) {
  companion object {
    val DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN

    fun create(textView: TextView): CompoundDrawableHelper = CompoundDrawableHelper(textView)
  }

  private var drawableTint: TintInfo? = null

  @SuppressLint("RestrictedApi")
  fun loadFromAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
    TintTypedArray
      .obtainStyledAttributes(view.context, attrs, R.styleable.CompoundDrawableHelper, defStyleAttr, 0)
      .use {
        findValue(R.styleable.CompoundDrawableHelper_drawableTint) {
          view.setSupportCompoundDrawableTintList(getColorStateList(it))
        }
        findValue(R.styleable.CompoundDrawableHelper_drawableTintMode) {
          view.setSupportCompoundDrawableTintMode(DrawableUtils.parseTintMode(getInt(it, -1), DEFAULT_TINT_MODE))
        }
      }
  }

  fun setCompoundDrawableTintList(tint: ColorStateList?) {
    if (drawableTint == null) {
      drawableTint = TintInfo()
    }

    drawableTint?.tintList = tint
    drawableTint?.hasTintList = true

    applyCompoundDrawableTint()
  }

  fun getCompoundDrawableTintList(): ColorStateList? =
    drawableTint?.tintList

  fun setCompoundDrawableTintMode(tintMode: PorterDuff.Mode) {
    if (drawableTint == null) {
      drawableTint = TintInfo()
    }

    drawableTint?.tintMode = tintMode
    drawableTint?.hasTintMode = true

    applyCompoundDrawableTint()
  }

  fun getCompoundDrawableTintMode(): PorterDuff.Mode =
    drawableTint?.tintMode ?: DEFAULT_TINT_MODE

  fun applyCompoundDrawableTint() {
    val tintInfo = drawableTint ?: return

    if (tintInfo.hasTintList || tintInfo.hasTintMode) {
      val compoundDrawables = view.compoundDrawables
      for (index in compoundDrawables.indices) {
        var drawable: Drawable? = compoundDrawables[index]
        if (drawable != null) {
          drawable = DrawableCompat.wrap(drawable).mutate()
          DrawableCompat.setTintList(drawable, getCompoundDrawableTintList())
          DrawableCompat.setTintMode(drawable, getCompoundDrawableTintMode())
          compoundDrawables[index] = drawable
          view.setCompoundDrawables(
            compoundDrawables[0],
            compoundDrawables[1],
            compoundDrawables[2],
            compoundDrawables[3]
          )
        }
      }
      val compoundDrawablesRelative = view.compoundDrawablesRelative
      for (index in compoundDrawablesRelative.indices) {
        var drawable: Drawable? = compoundDrawablesRelative[index]
        if (drawable != null) {
          drawable = DrawableCompat.wrap(drawable).mutate()
          DrawableCompat.setTintList(drawable, getCompoundDrawableTintList())
          DrawableCompat.setTintMode(drawable, getCompoundDrawableTintMode())
          compoundDrawablesRelative[index] = drawable
          view.setCompoundDrawablesRelative(
            compoundDrawablesRelative[0],
            compoundDrawablesRelative[1],
            compoundDrawablesRelative[2],
            compoundDrawablesRelative[3]
          )
        }
      }
    }
  }
}