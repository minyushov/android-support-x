package androidxx.core.graphics.drawable

import android.graphics.drawable.Drawable
import android.os.Build
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.graphics.drawable.TintAwareDrawable
import androidx.core.graphics.drawable.WrappedDrawableApi21X

fun Drawable.wrap(): Drawable =
  when {
    Build.VERSION.SDK_INT >= 23 -> DrawableCompat.wrap(this)
    Build.VERSION.SDK_INT >= 21 -> {
      if (this !is TintAwareDrawable) {
        WrappedDrawableApi21X(this)
      } else {
        this
      }
    }
    else -> DrawableCompat.wrap(this)
  }