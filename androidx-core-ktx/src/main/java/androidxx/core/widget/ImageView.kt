@file:Suppress("NOTHING_TO_INLINE")

package androidxx.core.widget

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.widget.ImageView
import androidx.core.widget.ImageViewCompat

inline fun ImageView.setImageTintListCompat(tint: ColorStateList?) =
  ImageViewCompat.setImageTintList(this, tint)

inline fun ImageView.setImageTintModeCompat(mode: PorterDuff.Mode?) =
  ImageViewCompat.setImageTintMode(this, mode)