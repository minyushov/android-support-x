@file:JvmName("StaticLayoutCompat")

package androidxx.core.text

import android.os.Build
import android.text.Layout
import android.text.StaticLayout
import android.text.TextDirectionHeuristic
import android.text.TextDirectionHeuristics
import android.text.TextPaint
import android.text.TextUtils

@JvmName("getInstance")
fun createStaticLayout(
  source: CharSequence,
  bufStart: Int = 0,
  bufEnd: Int = source.length,
  paint: TextPaint,
  outerWidth: Int,
  align: Layout.Alignment = Layout.Alignment.ALIGN_NORMAL,
  textDir: TextDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR,
  spacingMult: Float = 1f,
  spacingAdd: Float = 0f,
  includePad: Boolean = false,
  ellipsize: TextUtils.TruncateAt? = null,
  ellipsizedWidth: Int = 0,
  maxLines: Int = Integer.MAX_VALUE
): StaticLayout =
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    StaticLayout.Builder
      .obtain(source, bufStart, bufEnd, paint, outerWidth)
      .setAlignment(align)
      .setTextDirection(textDir)
      .setLineSpacing(spacingAdd, spacingMult)
      .setIncludePad(includePad)
      .setEllipsizedWidth(ellipsizedWidth)
      .setEllipsize(ellipsize)
      .setMaxLines(maxLines)
      .build()
  } else {
    @Suppress("DEPRECATION")
    StaticLayout(
      source,
      bufStart,
      bufEnd,
      paint,
      outerWidth,
      align,
      spacingMult,
      spacingAdd,
      includePad,
      ellipsize,
      ellipsizedWidth
    )
  }