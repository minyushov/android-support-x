package androidxx.core.animation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

suspend fun Animator.awaitEnd() = suspendCancellableCoroutine<Unit> { continuation ->
  continuation.invokeOnCancellation { cancel() }
  addListener(object : AnimatorListenerAdapter() {
    private var endedSuccessfully = true

    override fun onAnimationCancel(animation: Animator) {
      endedSuccessfully = false
    }

    override fun onAnimationEnd(animation: Animator) {
      animation.removeListener(this)
      if (continuation.isActive) {
        if (endedSuccessfully) {
          continuation.resume(Unit)
        } else {
          continuation.cancel()
        }
      }
    }
  })
}