package androidxx.core.view

import android.view.View
import android.widget.LinearLayout
import androidx.test.core.app.ApplicationProvider
import androidxx.test.assertThrows
import org.junit.Assert.assertNull
import org.junit.Assert.assertSame
import org.junit.Test

class ViewGroupTest {

  private val context = ApplicationProvider.getApplicationContext() as android.content.Context
  private val viewGroup = LinearLayout(context)

  @Test
  fun first() {
    assertThrows<NoSuchElementException> { viewGroup.first() }

    val view = View(context)
    viewGroup.addView(view)

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

    assertSame(view, viewGroup.firstOrNull())
  }

  @Test
  fun firstOrNullWithPredicate() {
    val view = View(context)
    viewGroup.addView(view)

    assertNull(viewGroup.firstOrNull { it !== view })
    assertSame(view, viewGroup.firstOrNull { it == view })
  }
}