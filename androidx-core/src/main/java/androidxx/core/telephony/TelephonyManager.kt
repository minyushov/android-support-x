@file:JvmName("TelephonyManagerCompat")
@file:Suppress("NOTHING_TO_INLINE")

package androidxx.core.telephony

import android.annotation.SuppressLint
import android.os.Build
import android.telephony.TelephonyManager
import androidx.annotation.RequiresPermission

@SuppressLint("HardwareIds")
@Suppress("DEPRECATION")
@RequiresPermission(android.Manifest.permission.READ_PHONE_STATE)
@JvmName("getImei")
inline fun TelephonyManager.getImeiCompat(): String? =
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) imei else deviceId

@SuppressLint("HardwareIds")
@Suppress("DEPRECATION")
@RequiresPermission(android.Manifest.permission.READ_PHONE_STATE)
@JvmName("getImei")
inline fun TelephonyManager.getImeiCompat(slotIndex: Int): String? =
  when {
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> getImei(slotIndex)
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.M -> getDeviceId(slotIndex)
    else -> deviceId
  }