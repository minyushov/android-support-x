package androidxx.material.tabs

import com.google.android.material.tabs.TabLayout

fun TabLayout.getTab(index: Int) =
  getTabAt(index) ?: throw IndexOutOfBoundsException("Index: $index, Size: $tabCount")

inline fun TabLayout.forEachTab(action: (tab: TabLayout.Tab) -> Unit) {
  for (index in 0 until tabCount) {
    action(getTab(index))
  }
}

inline fun TabLayout.forEachTabIndexed(action: (index: Int, tab: TabLayout.Tab) -> Unit) {
  for (index in 0 until tabCount) {
    action(index, getTab(index))
  }
}

inline fun TabLayout.onTabSelected(
  crossinline onTabSelected: (tab: TabLayout.Tab) -> Unit = { _ -> }
): TabLayout.OnTabSelectedListener =
  addOnTabSelectedListener(onTabSelected = onTabSelected)

inline fun TabLayout.onTabUnselected(
  crossinline onTabUnselected: (tab: TabLayout.Tab) -> Unit = { _ -> }
): TabLayout.OnTabSelectedListener =
  addOnTabSelectedListener(onTabUnselected = onTabUnselected)

inline fun TabLayout.onTabReselected(
  crossinline onTabReselected: (tab: TabLayout.Tab) -> Unit = { _ -> }
): TabLayout.OnTabSelectedListener =
  addOnTabSelectedListener(onTabReselected = onTabReselected)

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