package androidx.core.graphics.drawable

import android.graphics.drawable.Drawable
import android.graphics.drawable.ScaleDrawable
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
internal class WrappedDrawableApi21X(drawable: Drawable) : WrappedDrawableApi21(drawable) {
  override fun isCompatTintEnabled() =
    if (Build.VERSION.SDK_INT == 21) {
      super.isCompatTintEnabled() || mDrawable is ScaleDrawable
    } else {
      super.isCompatTintEnabled()
    }
}