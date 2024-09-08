@file:Suppress("FunctionName", "NOTHING_TO_INLINE")

package androidxx.core.app

import android.app.PendingIntent
import android.content.Context
import android.content.Intent

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
    flags or PendingIntent.FLAG_IMMUTABLE
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
    flags or PendingIntent.FLAG_IMMUTABLE
  )