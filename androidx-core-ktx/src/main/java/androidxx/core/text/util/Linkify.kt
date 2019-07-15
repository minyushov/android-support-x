@file:Suppress("NOTHING_TO_INLINE")

package androidxx.core.text.util

import android.text.Spannable
import android.text.util.Linkify
import androidx.core.text.toSpannable
import androidx.core.text.util.LinkifyCompat

inline fun String.linkify(@LinkifyCompat.LinkifyMask mask: Int = Linkify.ALL): Spannable =
  toSpannable().apply { LinkifyCompat.addLinks(this, mask) }