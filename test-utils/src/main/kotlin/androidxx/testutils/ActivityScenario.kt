package androidxx.testutils

import android.app.Activity
import androidx.test.core.app.ActivityScenario

/**
 * Run [block] using [ActivityScenario.onActivity], returning the result of the block.
 */
inline fun <reified A : Activity, T : Any> ActivityScenario<A>.withActivity(
  crossinline block: A.() -> T
): T {
  lateinit var value: T
  onActivity { activity ->
    value = block(activity)
  }
  return value
}