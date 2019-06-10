package androidxx.core.util

import android.util.LruCache

/**
 * Returns the value for the given [key]. If the key is not found in the LruCache,
 * calls the [defaultValue] function, puts its result into the LruCache under the given key and returns it.
 *
 * This method guarantees not to put the value into the cache if the key is already there,
 * but the [defaultValue] function may be invoked even if the key is already in the cache.
 */
inline fun <K, V> LruCache<K, V>.getOrPut(key: K, defaultValue: () -> V): V =
  get(key) ?: defaultValue().also { put(key, it) }