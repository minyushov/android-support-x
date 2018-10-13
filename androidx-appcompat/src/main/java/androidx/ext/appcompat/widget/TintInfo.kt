package androidx.ext.appcompat.widget

import android.content.res.ColorStateList
import android.graphics.PorterDuff

internal data class TintInfo(
  var tintList: ColorStateList? = null,
  var tintMode: PorterDuff.Mode? = null,
  var hasTintMode: Boolean = false,
  var hasTintList: Boolean = false
) {
  fun clear() {
    tintList = null
    hasTintList = false
    tintMode = null
    hasTintMode = false
  }
}