package androidxx.core.text.format

import android.text.format.DateUtils
import java.util.Date

inline val Date.isToday: Boolean
  get() = DateUtils.isToday(time)