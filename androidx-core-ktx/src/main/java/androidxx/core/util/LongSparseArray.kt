package androidxx.core.util

import android.util.LongSparseArray
import androidx.annotation.RequiresApi

/**
 * Returns the value for the given [key]. If the key is not found in the sparse array,
 * calls the [defaultValue] function, puts its result into the sparse array under the given key and returns it.
 *
 * This method guarantees not to put the value into the map if the key is already there,
 * but the [defaultValue] function may be invoked even if the key is already in the map.
 */
@RequiresApi(16)
inline fun <T> LongSparseArray<T>.getOrPut(key: Long, defaultValue: () -> T): T =
  get(key) ?: defaultValue().also { put(key, it) }