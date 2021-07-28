package androidxx.core.view

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.core.app.launchActivity
import androidxx.core.TestActivity
import androidxx.core.app.onActivityCreated
import androidxx.core.app.onActivityDestroyed
import androidxx.core.app.onActivityPaused
import androidxx.core.app.onActivityResumed
import androidxx.core.app.onActivitySaveInstanceState
import androidxx.core.app.onActivityStarted
import androidxx.core.app.onActivityStopped
import androidxx.testutils.withActivity
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.any
import org.mockito.kotlin.anyOrNull
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ApplicationTest {

  private interface ActivityCallbackWithBundle : (Activity, Bundle?) -> Unit
  private interface ActivityCallback : (Activity) -> Unit

  private val application = getApplicationContext<Application>()

  @Test
  fun testLifecycleCallbacks() {
    val onActivityCreated = mock<ActivityCallbackWithBundle>()
    application.onActivityCreated(onActivityCreated)

    val onActivityStarted = mock<ActivityCallback>()
    application.onActivityStarted(onActivityStarted)

    val onActivityResumed = mock<ActivityCallback>()
    application.onActivityResumed(onActivityResumed)

    val onActivityPaused = mock<ActivityCallback>()
    application.onActivityPaused(onActivityPaused)

    val onActivityStopped = mock<ActivityCallback>()
    application.onActivityStopped(onActivityStopped)

    val onActivityDestroyed = mock<ActivityCallback>()
    application.onActivityDestroyed(onActivityDestroyed)

    launchActivity<TestActivity>().use { scenario ->
      val activity = scenario.withActivity { this }

      scenario.moveToState(Lifecycle.State.RESUMED)

      verify(onActivityCreated).invoke(activity, null)
      verifyNoMoreInteractions(onActivityCreated)

      verify(onActivityStarted).invoke(activity)
      verifyNoMoreInteractions(onActivityStarted)

      verify(onActivityResumed).invoke(activity)
      verifyNoMoreInteractions(onActivityResumed)

      scenario.moveToState(Lifecycle.State.DESTROYED)

      verify(onActivityPaused).invoke(activity)
      verifyNoMoreInteractions(onActivityPaused)

      verify(onActivityStopped).invoke(activity)
      verifyNoMoreInteractions(onActivityStopped)

      verify(onActivityDestroyed).invoke(activity)
      verifyNoMoreInteractions(onActivityDestroyed)
    }
  }

  @Test
  fun testSaveInstanceStateCallback() {
    val onActivitySaveState = mock<ActivityCallbackWithBundle>()
    application.onActivitySaveInstanceState(onActivitySaveState)

    launchActivity<TestActivity>().use { scenario ->
      scenario.moveToState(Lifecycle.State.RESUMED)
      scenario.recreate()

      verify(onActivitySaveState).invoke(any(), anyOrNull())
      verifyNoMoreInteractions(onActivitySaveState)
    }
  }
}