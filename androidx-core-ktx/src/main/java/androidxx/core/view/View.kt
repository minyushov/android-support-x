package androidxx.core.view

import android.view.View

inline fun View.onLayout(crossinline action: (view: View) -> Unit) {
  addOnLayoutChangeListener { view, _, _, _, _, _, _, _, _ -> action(view) }
}