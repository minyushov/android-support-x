package androidxx.core.view

import android.app.Activity
import android.app.Application
import android.os.Build
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.core.app.launchActivity
import androidxx.core.app.onActivityCreated
import androidxx.core.app.onActivityDestroyed
import androidxx.core.app.onActivityPaused
import androidxx.core.app.onActivityResumed
import androidxx.core.app.onActivitySaveInstanceState
import androidxx.core.app.onActivityStarted
import androidxx.core.app.onActivityStopped
import androidxx.testutils.TestActivity
import androidxx.testutils.withActivity
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.anyOrNull
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
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