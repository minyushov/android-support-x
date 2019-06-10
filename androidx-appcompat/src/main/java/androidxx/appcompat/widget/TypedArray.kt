package androidxx.appcompat.widget

import android.graphics.PorterDuff
import androidx.appcompat.widget.TintTypedArray

internal val DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN

internal inline fun TintTypedArray.use(action: TintTypedArray.() -> Unit) {
  action()
  recycle()
}

internal inline fun TintTypedArray.findValue(index: Int, action: TintTypedArray.(Int) -> Unit) =
  if (hasValue(index)) action(index) else Unit