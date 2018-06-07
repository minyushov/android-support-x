package msv.androidx.core.graphics.drawable

import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.graphics.drawable.TintAwareDrawable
import androidx.core.graphics.drawable.WrappedDrawableApi21X

fun Drawable.wrap(): Drawable {
  return IMPL.wrap(this)
}

private val IMPL =
  if (Build.VERSION.SDK_INT >= 23) {
    DrawableCompatX()
  } else if (Build.VERSION.SDK_INT >= 21) {
    DrawableCompatXV21()
  } else {
    DrawableCompatX()
  }

internal open class DrawableCompatX {
  open fun wrap(drawable: Drawable): Drawable {
    return DrawableCompat.wrap(drawable)
  }
}

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
internal class DrawableCompatXV21 : DrawableCompatX() {
  override fun wrap(drawable: Drawable): Drawable {
    if (drawable !is TintAwareDrawable) {
      return WrappedDrawableApi21X(drawable)
    }
    return drawable
  }
}