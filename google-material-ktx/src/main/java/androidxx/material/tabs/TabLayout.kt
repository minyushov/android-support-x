@file:Suppress("NOTHING_TO_INLINE")

package androidxx.material.tabs

import com.google.android.material.tabs.TabLayout

inline fun TabLayout.get(index: Int) =
  getTabAt(index) ?: throw IndexOutOfBoundsException("Index: $index, Size: $tabCount")

inline fun TabLayout.forEach(action: (tab: TabLayout.Tab) -> Unit) {
  for (index in 0 until tabCount) {
    action(get(index))
  }
}

inline fun TabLayout.forEachIndexed(action: (index: Int, tab: TabLayout.Tab) -> Unit) {
  for (index in 0 until tabCount) {
    action(index, get(index))
  }
}

inline fun TabLayout.onTabSelected(
  crossinline onTabSelected: (tab: TabLayout.Tab) -> Unit = { _ -> }
) = addOnTabSelectedListener(onTabSelected = onTabSelected)

inline fun TabLayout.onTabUnselected(
  crossinline onTabUnselected: (tab: TabLayout.Tab) -> Unit = { _ -> }
) = addOnTabSelectedListener(onTabUnselected = onTabUnselected)

inline fun TabLayout.onTabReselected(
  crossinline onTabReselected: (tab: TabLayout.Tab) -> Unit = { _ -> }
) = addOnTabSelectedListener(onTabReselected = onTabReselected)

inline fun TabLayout.addOnTabSelectedListener(
  crossinline onTabSelected: (tab: TabLayout.Tab) -> Unit = { _ -> },
  crossinline onTabUnselected: (tab: TabLayout.Tab) -> Unit = { _ -> },
  crossinline onTabReselected: (tab: TabLayout.Tab) -> Unit = { _ -> }
): TabLayout.OnTabSelectedListener {

  val listener = object : TabLayout.OnTabSelectedListener {
    override fun onTabSelected(tab: TabLayout.Tab) = onTabSelected(tab)
    override fun onTabUnselected(tab: TabLayout.Tab) = onTabUnselected(tab)
    override fun onTabReselected(tab: TabLayout.Tab) = onTabReselected(tab)
  }

  addOnTabSelectedListener(listener)

  return listener
}

open class TabSelectionAdapter : TabLayout.OnTabSelectedListener {
  override fun onTabSelected(tab: TabLayout.Tab) = Unit
  override fun onTabUnselected(tab: TabLayout.Tab) = Unit
  override fun onTabReselected(tab: TabLayout.Tab) = Unit
}