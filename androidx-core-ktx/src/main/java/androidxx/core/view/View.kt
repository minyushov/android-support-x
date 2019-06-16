@file:Suppress("NOTHING_TO_INLINE")

package androidxx.core.view

import android.content.res.ColorStateList
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.view.ViewCompat

inline fun View.onLayout(crossinline action: (view: View) -> Unit) {
  addOnLayoutChangeListener { view, _, _, _, _, _, _, _, _ -> action(view) }
}

inline fun View.setBackgroundTintCompat(@ColorInt color: Int) =
  ViewCompat.setBackgroundTintList(this, ColorStateList.valueOf(color))

inline fun View.setBackgroundTintCompat(tint: ColorStateList?) =
  ViewCompat.setBackgroundTintList(this, tint)

inline var View.elevationCompat: Float
  get() = ViewCompat.getElevation(this)
  set(value) = ViewCompat.setElevation(this, value)