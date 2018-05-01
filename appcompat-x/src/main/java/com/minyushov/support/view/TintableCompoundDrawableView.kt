package com.minyushov.support.view

import android.content.res.ColorStateList
import android.graphics.PorterDuff

/**
 * Interface which allows a [TextView][android.widget.TextView] to receive compound drawable
 * tinting calls from [CompoundDrawableCompat][com.minyushov.support.widget.CompoundDrawableCompat]
 * when running on API v20 devices or lower.
 */
internal interface TintableCompoundDrawableView {
  /**
   * Applies a tint to the compound drawables. Does not modify the
   * current tint mode, which is [PorterDuff.Mode.SRC_IN] by default.
   *
   * Subsequent calls to [TextView.setCompoundDrawables][android.widget.TextView.setCompoundDrawables]
   * will automatically mutate the drawable and apply
   * the specified tint and tint mode.
   *
   * @param tint the tint to apply, may be null to clear tint
   * @see [getSupportCompoundDrawableTintList]
   */
  fun setSupportCompoundDrawableTintList(tint: ColorStateList?)

  /**
   * Return the tint applied to the compound drawables, if specified.
   *
   * @return the tint applied to the compound drawables
   */
  fun getSupportCompoundDrawableTintList(): ColorStateList?

  /**
   * Specifies the blending mode used to apply the tint specified by
   * [setSupportCompoundDrawableTintList] to the compound drawable.
   *
   * The default mode is [PorterDuff.Mode.SRC_IN].
   *
   * @param tintMode the blending mode used to apply the tint, may be null to clear tint
   * @see [getSupportCompoundDrawableTintMode]
   */
  fun setSupportCompoundDrawableTintMode(tintMode: PorterDuff.Mode)

  /**
   * Return the blending mode used to apply the tint to the background
   * drawable, if specified.
   *
   * @return the blending mode used to apply the tint to the background drawable
   */
  fun getSupportCompoundDrawableTintMode(): PorterDuff.Mode
}