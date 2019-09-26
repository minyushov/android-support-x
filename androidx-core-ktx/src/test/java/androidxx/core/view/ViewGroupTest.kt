package androidxx.core.view

import android.os.Build
import android.view.View
import android.widget.LinearLayout
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertNull
import org.junit.Assert.assertSame
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
// Switch to Q when https://github.com/robolectric/robolectric/issues/5207 is fixed
@Config(sdk = [Build.VERSION_CODES.P])
class ViewGroupTest {

  private val context = ApplicationProvider.getApplicationContext() as android.content.Context
  private val viewGroup = LinearLayout(context)

  @Test
  fun first() {
    assertThrows<NoSuchElementException> { viewGroup.first() }

    val view = View(context)
    viewGroup.addView(view)
    viewGroup.addView(View(context))

    assertSame(view, viewGroup.first())
  }

  @Test
  fun firstWithPredicate() {
    val view = View(context)
    viewGroup.addView(view)

    assertThrows<NoSuchElementException> { viewGroup.first { it !== view } }
    assertSame(view, viewGroup.first { it == view })
  }

  @Test
  fun firstOrNull() {
    assertNull(viewGroup.firstOrNull())

    val view = View(context)
    viewGroup.addView(view)
    viewGroup.addView(View(context))

    assertSame(view, viewGroup.firstOrNull())
  }

  @Test
  fun firstOrNullWithPredicate() {
    val view = View(context)
    viewGroup.addView(view)

    assertNull(viewGroup.firstOrNull { it !== view })
    assertSame(view, viewGroup.firstOrNull { it == view })
  }

  @Test
  fun last() {
    assertThrows<NoSuchElementException> { viewGroup.last() }

    val view = View(context)
    viewGroup.addView(View(context))
    viewGroup.addView(view)

    assertSame(view, viewGroup.last())
  }

  @Test
  fun lastWithPredicate() {
    val view = View(context)
    viewGroup.addView(view)

    assertThrows<NoSuchElementException> { viewGroup.last { it !== view } }
    assertSame(view, viewGroup.last { it == view })
  }

  @Test
  fun lastOrNull() {
    assertNull(viewGroup.lastOrNull())

    val view = View(context)
    viewGroup.addView(View(context))
    viewGroup.addView(view)

    assertSame(view, viewGroup.lastOrNull())
  }

  @Test
  fun lastOrNullWithPredicate() {
    val view = View(context)
    viewGroup.addView(view)

    assertNull(viewGroup.lastOrNull { it !== view })
    assertSame(view, viewGroup.lastOrNull { it == view })
  }

}