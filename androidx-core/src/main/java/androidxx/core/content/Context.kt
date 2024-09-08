@file:Suppress("NOTHING_TO_INLINE")

package androidxx.core.content

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Point
import android.os.Build
import android.util.Size
import android.util.TypedValue
import android.view.Display
import android.view.WindowInsets
import android.view.WindowManager
import androidx.annotation.AnyRes
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService

@AnyRes
fun Context.getAttrValue(@AttrRes attr: Int): Int =
  TypedValue()
    .apply { theme.resolveAttribute(attr, this, true) }
    .resourceId

@ColorInt
inline fun Context.getColorAttrValue(@AttrRes attr: Int): Int =
  getColor(getAttrValue(attr))

inline fun Context.getColorStateListCompat(@ColorRes color: Int): ColorStateList =
  ContextCompat.getColorStateList(this, color)
    ?: throw NoSuchElementException("ColorStateList for id = $color not found")

inline val Context.displayCompat: Display?
  get() =
    if (Build.VERSION.SDK_INT >= 30) {
      display
    } else {
      @Suppress("DEPRECATION")
      getSystemService<WindowManager>()?.defaultDisplay
    }

val Context.defaultDisplaySize: Size
  get() {
    val manager = getSystemService<WindowManager>()
      ?: return Size(0, 0)

    if (Build.VERSION.SDK_INT >= 30) {
      val metrics = manager.currentWindowMetrics
      val windowInsets = metrics.windowInsets

      val insets = windowInsets.getInsetsIgnoringVisibility(
        WindowInsets.Type.navigationBars() or WindowInsets.Type.displayCutout()
      )

      val insetsWidth = insets.right + insets.left
      val insetsHeight = insets.top + insets.bottom

      val bounds = metrics.bounds

      return Size(
        bounds.width() - insetsWidth,
        bounds.height() - insetsHeight
      )
    } else {
      @Suppress("DEPRECATION")
      return Point()
        .let { point ->
          manager.defaultDisplay?.getSize(point)
          Size(point.x, point.y)
        }
    }
  }