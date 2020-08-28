package androidxx.core.view

import android.view.ViewPropertyAnimator
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

suspend fun ViewPropertyAnimator.awaitEnd() = suspendCancellableCoroutine<Unit> { continuation ->
  continuation.invokeOnCancellation { cancel() }
  withEndAction {
    if (continuation.isActive) {
      continuation.resume(Unit)
    }
  }
  start()
}