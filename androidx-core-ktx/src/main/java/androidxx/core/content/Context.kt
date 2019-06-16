@file:Suppress("NOTHING_TO_INLINE")

package androidxx.core.content

import android.content.Context
import android.content.res.ColorStateList
import android.util.TypedValue
import androidx.annotation.AnyRes
import androidx.annotation.AttrRes
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

@AnyRes
fun Context.getAttrValue(@AttrRes attr: Int): Int =
  TypedValue()
    .apply { theme.resolveAttribute(attr, this, true) }
    .resourceId


inline fun Context.getColorCompat(@ColorRes color: Int): Int =
  ContextCompat.getColor(this, color)

inline fun Context.getColorStateListCompat(@ColorRes color: Int): ColorStateList =
  ContextCompat.getColorStateList(this, color)
    ?: throw NoSuchElementException("ColorStateList for id = $color not found")