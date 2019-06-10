@file:Suppress("NOTHING_TO_INLINE")

package androidxx.core.graphics

import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.DrawableCompat

inline fun Drawable.wrap(): Drawable =
  DrawableCompat.wrap(this)