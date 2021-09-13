@file:Suppress("FunctionName", "NOTHING_TO_INLINE")

package androidxx.core.app

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build

inline fun PendingActivityIntent(
  context: Context,
  requestCode: Int,
  intent: Intent,
  flags: Int
): PendingIntent =
  PendingIntent.getActivity(
    context,
    requestCode,
    intent,
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      flags or PendingIntent.FLAG_IMMUTABLE
    } else {
      flags
    }
  )

inline fun PendingBroadcastIntent(
  context: Context,
  requestCode: Int,
  intent: Intent,
  flags: Int
): PendingIntent =
  PendingIntent.getBroadcast(
    context,
    requestCode,
    intent,
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      flags or PendingIntent.FLAG_IMMUTABLE
    } else {
      flags
    }
  )