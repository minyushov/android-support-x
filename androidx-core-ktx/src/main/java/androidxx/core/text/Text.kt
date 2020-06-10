@file:Suppress("NOTHING_TO_INLINE")

package androidxx.core.text

import android.text.Spannable
import android.text.TextPaint
import android.text.TextUtils
import android.text.util.Linkify
import androidx.core.text.toSpannable
import androidx.core.text.util.LinkifyCompat

inline fun CharSequence.ellipsize(
  paint: TextPaint,
  availableWidth: Float,
  where: TextUtils.TruncateAt
): CharSequence =
  TextUtils.ellipsize(this, paint, availableWidth, where)

inline fun String.linkify(
  @LinkifyCompat.LinkifyMask
  mask: Int = Linkify.ALL
): Spannable =
  toSpannable().apply {
    LinkifyCompat.addLinks(this, mask)
  }