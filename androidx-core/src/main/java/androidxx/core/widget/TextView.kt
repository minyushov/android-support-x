@file:Suppress("NOTHING_TO_INLINE")

package androidxx.core.widget

import android.graphics.drawable.Drawable
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.annotation.DrawableRes

inline fun TextView.replaceCompoundDrawables(
  left: Drawable? = null,
  top: Drawable? = null,
  right: Drawable? = null,
  bottom: Drawable? = null
) = setCompoundDrawables(left, top, right, bottom)

inline fun TextView.replaceCompoundDrawablesRelative(
  start: Drawable? = null,
  top: Drawable? = null,
  end: Drawable? = null,
  bottom: Drawable? = null
) = setCompoundDrawablesRelative(start, top, end, bottom)

inline fun TextView.replaceCompoundDrawablesWithIntrinsicBounds(
  left: Drawable? = null,
  top: Drawable? = null,
  right: Drawable? = null,
  bottom: Drawable? = null
) = setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom)

inline fun TextView.replaceCompoundDrawablesRelativeWithIntrinsicBounds(
  start: Drawable? = null,
  top: Drawable? = null,
  end: Drawable? = null,
  bottom: Drawable? = null
) = setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom)

inline fun TextView.replaceCompoundDrawablesWithIntrinsicBounds(
  @DrawableRes left: Int = 0,
  @DrawableRes top: Int = 0,
  @DrawableRes right: Int = 0,
  @DrawableRes bottom: Int = 0
) = setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom)

inline fun TextView.replaceCompoundDrawablesRelativeWithIntrinsicBounds(
  @DrawableRes start: Int = 0,
  @DrawableRes top: Int = 0,
  @DrawableRes end: Int = 0,
  @DrawableRes bottom: Int = 0
) = setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom)


inline fun TextView.onImeAction(imeActionId: Int, crossinline action: () -> Unit): TextView.OnEditorActionListener {
  val listener = TextView.OnEditorActionListener { _, actionId, _ ->
    if (imeActionId == actionId) {
      action()
      true
    } else {
      false
    }
  }
  setOnEditorActionListener(listener)
  return listener
}

inline fun TextView.onImeActionDone(crossinline action: () -> Unit): TextView.OnEditorActionListener =
  onImeAction(EditorInfo.IME_ACTION_DONE, action)