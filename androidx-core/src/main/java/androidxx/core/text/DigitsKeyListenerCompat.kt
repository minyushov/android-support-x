package androidxx.core.text

import android.os.Build
import android.text.method.DigitsKeyListener
import java.util.Locale

@Suppress("DEPRECATION")
object DigitsKeyListenerCompat {
  fun getInstance(sign: Boolean, decimal: Boolean, locale: Locale? = null): DigitsKeyListener =
    when {
      Build.VERSION.SDK_INT >= 26 -> DigitsKeyListener.getInstance(locale, sign, decimal)
      else -> DigitsKeyListener.getInstance(sign, decimal)
    }
}