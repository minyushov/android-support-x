@file:Suppress("NOTHING_TO_INLINE")

package androidxx.core.graphics

import android.content.res.ColorStateList
import androidx.annotation.ColorInt
import androidx.annotation.IntRange
import androidx.core.graphics.ColorUtils

inline fun @receiver:ColorInt Int.withAlpha(@IntRange(from = 0x0, to = 0xFF) alpha: Int): Int =
  ColorUtils.setAlphaComponent(this, alpha)

inline fun @receiver:ColorInt Int.toStateList(): ColorStateList =
  ColorStateList.valueOf(this)