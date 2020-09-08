@file:Suppress("NOTHING_TO_INLINE")

package androidxx.core.view

import android.os.Build
import android.view.View
import android.view.WindowInsets
import android.view.inputmethod.InputMethodManager
import androidx.core.content.getSystemService
import androidx.core.view.doOnPreDraw

inline fun View.showIme() {
  doOnPreDraw {
    requestFocus()
    post {
      if (Build.VERSION.SDK_INT >= 30) {
        windowInsetsController?.show(WindowInsets.Type.ime())
      } else {
        context
          .getSystemService<InputMethodManager>()
          ?.showSoftInput(this, 0)
      }
    }
  }
}

inline fun View.hideIme() {
  if (Build.VERSION.SDK_INT >= 30) {
    windowInsetsController?.hide(WindowInsets.Type.ime())
  } else {
    context
      .getSystemService<InputMethodManager>()
      ?.hideSoftInputFromWindow(windowToken, 0)
  }
}