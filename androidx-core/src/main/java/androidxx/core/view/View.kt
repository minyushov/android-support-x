package androidxx.core.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewTreeObserver
import androidx.core.graphics.Insets
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsCompat.Type.InsetsType
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

inline val View.inflater: LayoutInflater
  get() = context.inflater

inline fun View.onLayout(crossinline action: (view: View) -> Unit): View.OnLayoutChangeListener {
  val listener = View.OnLayoutChangeListener { view, _, _, _, _, _, _, _, _ -> action(view) }
  addOnLayoutChangeListener(listener)
  return listener
}

inline fun View.onApplyWindowInsets(
  crossinline action: (insets: WindowInsetsCompat) -> WindowInsetsCompat
): OnApplyWindowInsetsListener {
  val listener = OnApplyWindowInsetsListener { _, insets -> action(insets) }
  ViewCompat.setOnApplyWindowInsetsListener(this, listener)
  return listener
}

inline fun View.onSystemBarInsets(
  crossinline action: (insets: Insets) -> Unit
): OnApplyWindowInsetsListener =
  onInsets(
    insetsType = WindowInsetsCompat.Type.systemBars(),
    action = action
  )

inline fun View.onSafeDrawingInsets(
  crossinline action: (insets: Insets) -> Unit
): OnApplyWindowInsetsListener =
  onInsets(
    insetsType = WindowInsetsCompat.Type.systemBars()
      or WindowInsetsCompat.Type.ime()
      or WindowInsetsCompat.Type.displayCutout(),
    action = action
  )

inline fun View.onInsets(
  @InsetsType insetsType: Int,
  crossinline action: (insets: Insets) -> Unit
): OnApplyWindowInsetsListener =
  onApplyWindowInsets { insets ->
    action(insets.getInsets(insetsType))
    insets
  }

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
      if (continuation.isActive) {
        continuation.resume(Unit)
      }
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
        if (continuation.isActive) {
          continuation.resume(Unit)
        }
        return true
      }
    }
    continuation.invokeOnCancellation { viewTreeObserver.removeOnPreDrawListener(listener) }
    viewTreeObserver.addOnPreDrawListener(listener)
  }
}

suspend fun View.awaitAnimationFrame() = suspendCancellableCoroutine<Unit> { continuation ->
  val runnable = Runnable {
    if (continuation.isActive) {
      continuation.resume(Unit)
    }
  }
  continuation.invokeOnCancellation { removeCallbacks(runnable) }
  postOnAnimation(runnable)
}