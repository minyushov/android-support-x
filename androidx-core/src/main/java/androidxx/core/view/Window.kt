@file:Suppress("NOTHING_TO_INLINE")

package androidxx.core.view

import android.os.Build
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager

inline fun Window.showStatusBar() {
  if (Build.VERSION.SDK_INT >= 30) {
    insetsController?.show(WindowInsets.Type.statusBars())
  } else {
    @Suppress("DEPRECATION")
    setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN.inv(), WindowManager.LayoutParams.FLAG_FULLSCREEN)
  }
}

inline fun Window.hideStatusBar() {
  if (Build.VERSION.SDK_INT >= 30) {
    insetsController?.hide(WindowInsets.Type.statusBars())
  } else {
    @Suppress("DEPRECATION")
    setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
  }
}