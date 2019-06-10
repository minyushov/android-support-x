package androidxx.appcompat.widget

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.TextView
import androidx.appcompat.widget.DrawableUtils
import androidx.appcompat.widget.TintInfo
import androidx.appcompat.widget.TintTypedArray
import androidx.core.graphics.drawable.DrawableCompat
import androidxx.appcompat.R

internal open class CompoundDrawableHelper(
  private val view: TextView
) {

  private val drawableTint by lazy { TintInfo() }

  @SuppressLint("PrivateResource")
  fun loadFromAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
    TintTypedArray
      .obtainStyledAttributes(view.context, attrs, R.styleable.AppCompatTextView, defStyleAttr, 0)
      .use {
        findValue(R.styleable.AppCompatTextView_drawableTint) {
          view.compoundDrawableTintCompat = getColorStateList(it)
        }
        findValue(R.styleable.AppCompatTextView_drawableTintMode) {
          view.compoundDrawableTintModeCompat = DrawableUtils.parseTintMode(getInt(it, -1), DEFAULT_TINT_MODE)
        }
      }
  }

  fun setCompoundDrawableTintList(tint: ColorStateList?) {
    drawableTint.mTintList = tint
    drawableTint.mHasTintList = true
    applyCompoundDrawableTint()
  }

  fun getCompoundDrawableTintList(): ColorStateList? =
    drawableTint.mTintList

  fun setCompoundDrawableTintMode(tintMode: PorterDuff.Mode) {
    drawableTint.mTintMode = tintMode
    drawableTint.mHasTintMode = true
    applyCompoundDrawableTint()
  }

  fun getCompoundDrawableTintMode(): PorterDuff.Mode =
    drawableTint.mTintMode ?: DEFAULT_TINT_MODE

  fun applyCompoundDrawableTint() {
    val tintInfo = drawableTint
    if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
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