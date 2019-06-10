@file:Suppress("NOTHING_TO_INLINE")

package androidxx.core.content

import android.content.res.Resources
import android.util.TypedValue

inline val Int.sp: Int
  get() = toFloat().sp.toInt()

inline val Int.dp: Int
  get() = toFloat().dp.toInt()

inline val Float.sp: Float
  get() = asTypedValue(TypedValue.COMPLEX_UNIT_SP)

inline val Float.dp: Float
  get() = asTypedValue(TypedValue.COMPLEX_UNIT_DIP)

inline fun Float.asTypedValue(unit: Int): Float =
  TypedValue.applyDimension(unit, this, Resources.getSystem().displayMetrics)