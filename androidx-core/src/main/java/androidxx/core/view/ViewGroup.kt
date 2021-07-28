@file:Suppress("NOTHING_TO_INLINE")

package androidxx.core.view

import android.view.View
import android.view.ViewGroup

/**
 * Returns first child view.
 * @throws [NoSuchElementException] if this view group contains no views.
 */
inline fun ViewGroup.first(): View {
  if (childCount == 0) throw NoSuchElementException("ViewGroup is empty.")
  return getChildAt(0)
}

/**
 * Returns the first child view matching the given [predicate].
 * @throws [NoSuchElementException] if no such child view is found.
 */
inline fun ViewGroup.first(predicate: (View) -> Boolean): View {
  for (index in 0 until childCount) {
    val view = getChildAt(index)
    if (predicate(view)) return view
  }
  throw NoSuchElementException("ViewGroup contains no child view matching the predicate.")
}

/**
 * Returns the first child view, or `null` if this view group contains no views.
 */
inline fun ViewGroup.firstOrNull(): View? {
  return if (childCount == 0) null else getChildAt(0)
}

/**
 * Returns the first child view matching the given [predicate], or `null` if no such child view is found.
 */
inline fun ViewGroup.firstOrNull(predicate: (View) -> Boolean): View? {
  for (index in 0 until childCount) {
    val view = getChildAt(index)
    if (predicate(view)) return view
  }
  return null
}

/**
 * Returns last child view.
 * @throws [NoSuchElementException] if this view group contains no views.
 */
inline fun ViewGroup.last(): View {
  if (childCount == 0) throw NoSuchElementException("ViewGroup is empty.")
  return getChildAt(childCount - 1)
}

/**
 * Returns the last child view matching the given [predicate].
 * @throws [NoSuchElementException] if no such child view is found.
 */
inline fun ViewGroup.last(predicate: (View) -> Boolean): View {
  for (index in (childCount - 1) downTo 0) {
    val view = getChildAt(index)
    if (predicate(view)) return view
  }
  throw NoSuchElementException("ViewGroup contains no child view matching the predicate.")
}

/**
 * Returns the last child view, or `null` if this view group contains no views.
 */
inline fun ViewGroup.lastOrNull(): View? {
  val size = childCount
  return if (size == 0) null else getChildAt(size - 1)
}

/**
 * Returns the last child view matching the given [predicate], or `null` if no such child view is found.
 */
inline fun ViewGroup.lastOrNull(predicate: (View) -> Boolean): View? {
  for (index in (childCount - 1) downTo 0) {
    val view = getChildAt(index)
    if (predicate(view)) return view
  }
  return null
}