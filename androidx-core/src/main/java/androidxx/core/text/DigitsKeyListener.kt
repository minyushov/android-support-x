@file:JvmName("DigitsKeyListenerCompat")

package androidxx.core.text

import android.os.Build
import android.text.method.DigitsKeyListener
import java.util.Locale

@JvmName("getInstance")
fun createDigitsKeyListener(
  sign: Boolean,
  decimal: Boolean,
  locale: Locale? = null
): DigitsKeyListener =
  if (Build.VERSION.SDK_INT >= 26) {
    DigitsKeyListener.getInstance(locale, sign, decimal)
  } else {
    @Suppress("DEPRECATION")
    DigitsKeyListener.getInstance(sign, decimal)
  }