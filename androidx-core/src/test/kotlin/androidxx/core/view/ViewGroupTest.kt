package androidxx.core.view

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertNull
import org.junit.Assert.assertSame
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import kotlin.test.assertFailsWith

@RunWith(RobolectricTestRunner::class)
class ViewGroupTest {

  private val context: Context = ApplicationProvider.getApplicationContext()
  private val viewGroup = LinearLayout(context)

  @Test
  fun first() {
    assertFailsWith(NoSuchElementException::class) { viewGroup.first() }

    val view = View(context)
    viewGroup.addView(view)
    viewGroup.addView(View(context))

    assertSame(view, viewGroup.first())
  }

  @Test
  fun firstWithPredicate() {
    val view = View(context)
    viewGroup.addView(view)

    assertFailsWith(NoSuchElementException::class) { viewGroup.first { it !== view } }
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
    assertFailsWith(NoSuchElementException::class) { viewGroup.last() }

    val view = View(context)
    viewGroup.addView(View(context))
    viewGroup.addView(view)

    assertSame(view, viewGroup.last())
  }

  @Test
  fun lastWithPredicate() {
    val view = View(context)
    viewGroup.addView(View(context))
    viewGroup.addView(view)

    val missingView = View(context)

    assertFailsWith(NoSuchElementException::class) { viewGroup.last { it == missingView } }
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
    viewGroup.addView(View(context))
    viewGroup.addView(view)

    val missingView = View(context)

    assertNull(viewGroup.lastOrNull { it == missingView })
    assertSame(view, viewGroup.lastOrNull { it == view })
  }

}