@file:Suppress("NOTHING_TO_INLINE")

package androidxx.core.view

import android.content.res.ColorStateList
import android.view.View
import android.view.ViewTreeObserver
import androidx.annotation.ColorInt
import androidx.core.view.ViewCompat
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

inline fun View.onLayout(crossinline action: (view: View) -> Unit): View.OnLayoutChangeListener {
  val listener = View.OnLayoutChangeListener { view, _, _, _, _, _, _, _, _ -> action(view) }
  addOnLayoutChangeListener(listener)
  return listener
}

inline fun View.setBackgroundTintCompat(@ColorInt color: Int) =
  ViewCompat.setBackgroundTintList(this, ColorStateList.valueOf(color))

inline fun View.setBackgroundTintCompat(tint: ColorStateList?) =
  ViewCompat.setBackgroundTintList(this, tint)

inline var View.elevationCompat: Float
  get() = ViewCompat.getElevation(this)
  set(value) = ViewCompat.setElevation(this, value)

suspend fun View.awaitNextLayout() = suspendCancellableCoroutine<Unit> { continuation ->
  val listener = object : View.OnLayoutChangeListener {
    override fun onLayoutChange(
      view: View,
      left: Int,
      top: Int,
      right: Int,
      bottom: Int,
      oldLeft: Int,
      oldTop: Int,
      oldRight: Int,
      oldBottom: Int
    ) {
      view.removeOnLayoutChangeListener(this)
      continuation.resume(Unit)
    }
  }
  continuation.invokeOnCancellation { removeOnLayoutChangeListener(listener) }
  addOnLayoutChangeListener(listener)
}

suspend fun View.awaitPreDraw() = suspendCancellableCoroutine<Unit> { continuation ->
  if (width > 0 || height > 0) {
    continuation.resume(Unit)
  } else {
    val listener = object : ViewTreeObserver.OnPreDrawListener {
      override fun onPreDraw(): Boolean {
        viewTreeObserver.removeOnPreDrawListener(this)
        continuation.resume(Unit)
        return true
      }
    }
    continuation.invokeOnCancellation { viewTreeObserver.removeOnPreDrawListener(listener) }
    viewTreeObserver.addOnPreDrawListener(listener)
  }
}

suspend fun View.awaitAnimationFrame() = suspendCancellableCoroutine<Unit> { continuation ->
  val runnable = Runnable { continuation.resume(Unit) }
  continuation.invokeOnCancellation { removeCallbacks(runnable) }
  postOnAnimation(runnable)
}