package com.minyushov.support.view

import android.content.res.ColorStateList
import android.graphics.PorterDuff

/**
 * Interface which allows a [ProgressBar][android.widget.ProgressBar] to receive progress drawable
 * tinting calls from [ProgressBarCompat][com.minyushov.support.widget.ProgressBarCompat]
 * when running on API v20 devices or lower.
 */
internal interface TintableProgressBar {
  /**
   * Applies a tint to the indeterminate drawable. Does not modify the
   * current tint mode, which is [PorterDuff.Mode.SRC_IN] by default.
   *
   * Subsequent calls to
   * [ProgressBar.setIndeterminateDrawable][android.widget.ProgressBar.setIndeterminateDrawable]
   * will automatically mutate the drawable and apply the specified tint and
   * tint mode using
   * [DrawableCompat.setTint][android.support.v4.graphics.drawable.DrawableCompat.setTintList].
   *
   * @param tint the tint to apply, may be null to clear tint
   *
   * @see [getSupportIndeterminateTintList]
   * @see [android.support.v4.graphics.drawable.DrawableCompat.setTintList]
   */
  fun setSupportIndeterminateTintList(tint: ColorStateList?)

  /**
   * @return the tint applied to the indeterminate drawable
   *
   * @see [setSupportIndeterminateTintList]
   */
  fun getSupportIndeterminateTintList(): ColorStateList?

  /**
   * Specifies the blending mode used to apply the tint specified by
   * [setSupportIndeterminateTintList] to the indeterminate progress drawable.
   *
   * The default mode is [PorterDuff.Mode.SRC_IN].
   *
   * @param tintMode the blending mode used to apply the tint, may be null to clear tint
   *
   * @see [getSupportIndeterminateTintMode]
   * @see [android.support.v4.graphics.drawable.DrawableCompat.setTintMode]
   */
  fun setSupportIndeterminateTintMode(tintMode: PorterDuff.Mode)

  /**
   * Returns the blending mode used to apply the tint to the indeterminate
   * drawable, if specified.
   *
   * @return the blending mode used to apply the tint to the indeterminate drawable
   *
   * @see [setSupportIndeterminateTintMode]
   */
  fun getSupportIndeterminateTintMode(): PorterDuff.Mode

  /**
   * Applies a tint to the progress indicator, if one exists, or to the
   * entire progress drawable otherwise. Does not modify the current tint
   * mode, which is [PorterDuff.Mode.SRC_IN] by default.
   *
   * The progress indicator should be specified as a layer with id [android.R.id.progress]
   * in a [LayerDrawable][android.graphics.drawable.LayerDrawable] used as
   * the progress drawable.
   *
   * Subsequent calls to
   * [ProgressBar.setProgressDrawable][android.widget.ProgressBar.setProgressDrawable]
   * will automatically mutate the drawable and apply the specified tint and tint mode using
   * [DrawableCompat.setTint][android.support.v4.graphics.drawable.DrawableCompat.setTintList].
   *
   * @param tint the tint to apply, may be null to clear tint
   *
   * @see [getSupportProgressTintList]
   * @see [android.support.v4.graphics.drawable.DrawableCompat.setTintList]
   */
  fun setSupportProgressTintList(tint: ColorStateList?)

  /**
   * Returns the tint applied to the progress drawable, if specified.
   *
   * @return the tint applied to the progress drawable
   *
   * @see [setSupportProgressTintList]
   */
  fun getSupportProgressTintList(): ColorStateList?

  /**
   * Specifies the blending mode used to apply the tint specified by
   * [setSupportProgressTintList] to the progress indicator.
   *
   * The default mode is [PorterDuff.Mode.SRC_IN].
   *
   * @param tintMode the blending mode used to apply the tint, may be null to clear tint
   *
   * @see [setSupportProgressTintList]
   * @see [getSupportProgressTintMode]
   * @see [android.support.v4.graphics.drawable.DrawableCompat.setTintMode]
   */
  fun setSupportProgressTintMode(tintMode: PorterDuff.Mode)

  /**
   * Returns the blending mode used to apply the tint to the progress
   * drawable, if specified.
   *
   * @return the blending mode used to apply the tint to the progress drawable
   *
   * @see [setSupportProgressTintMode]
   */
  fun getSupportProgressTintMode(): PorterDuff.Mode

  /**
   * Applies a tint to the progress background, if one exists. Does not modify the
   * current tint mode, which is [PorterDuff.Mode.SRC_IN] by default.
   *
   * The progress background must be specified as a layer with id [android.R.id.background]
   * in a [LayerDrawable][android.graphics.drawable.LayerDrawable] used as the progress drawable.
   *
   * Subsequent calls to
   * [ProgressBar.setProgressDrawable][android.widget.ProgressBar.setProgressDrawable]
   * where the drawable contains a progress background will automatically mutate the
   * drawable and apply the specified tint and tint mode using
   * [DrawableCompat.setTint][android.support.v4.graphics.drawable.DrawableCompat.setTintList].
   *
   * @param tint the tint to apply, may be {@code null} to clear tint
   *
   * @see [getSupportProgressBackgroundTintList]
   * @see [android.support.v4.graphics.drawable.DrawableCompat.setTintList]
   */
  fun setSupportProgressBackgroundTintList(tint: ColorStateList?)

  /**
   * Returns the tint applied to the progress background, if specified.
   *
   * @return the tint applied to the progress background
   *
   * @see [setSupportProgressBackgroundTintList]
   */
  fun getSupportProgressBackgroundTintList(): ColorStateList?

  /**
   * Specifies the blending mode used to apply the tint specified by
   * [setSupportProgressBackgroundTintList] to the progress background.
   * The default mode is [PorterDuff.Mode.SRC_IN].
   *
   * @param tintMode the blending mode used to apply the tint, may be null to clear tint
   *
   * @see [setSupportProgressBackgroundTintList]
   * @see [getSupportIndeterminateTintMode]
   * @see [android.support.v4.graphics.drawable.DrawableCompat.setTintMode]
   */
  fun setSupportProgressBackgroundTintMode(tintMode: PorterDuff.Mode)

  /**
   * @return the blending mode used to apply the tint to the progress background
   * @see [setSupportProgressBackgroundTintMode]
   */
  fun getSupportProgressBackgroundTintMode(): PorterDuff.Mode

  /**
   * Applies a tint to the secondary progress indicator, if one exists.
   * Does not modify the current tint mode,
   * which is [PorterDuff.Mode.SRC_IN] by default.
   *
   * The secondary progress indicator must be specified as a layer with id
   * [android.R.id.secondaryProgress] in a [LayerDrawable][android.graphics.drawable.LayerDrawable]
   * used as the progress drawable.
   *
   * Subsequent calls to
   * [ProgressBar.setProgressDrawable][android.widget.ProgressBar.setProgressDrawable]
   * where the drawable contains a secondary progress indicator will automatically
   * mutate the drawable and apply the specified tint and tint mode using
   * [DrawableCompat.setTint][android.support.v4.graphics.drawable.DrawableCompat.setTintList].
   *
   * @param tint the tint to apply, may be null to clear tint
   *
   * @see [getSupportSecondaryProgressTintList]
   * @see [android.support.v4.graphics.drawable.DrawableCompat.setTintList]
   */
  fun setSupportSecondaryProgressTintList(tint: ColorStateList?)

  /**
   * Returns the tint applied to the secondary progress drawable, if specified.
   *
   * @return the tint applied to the secondary progress drawable
   *
   * @see [setSupportSecondaryProgressTintList]
   */
  fun getSupportSecondaryProgressTintList(): ColorStateList?

  /**
   * Specifies the blending mode used to apply the tint specified by
   * [setSupportSecondaryProgressTintList] to the secondary progress indicator.
   * The default mode is [PorterDuff.Mode.SRC_IN].
   *
   * @param tintMode the blending mode used to apply the tint, may be null to clear tint
   *
   * @see [setSupportSecondaryProgressTintList]
   * @see [getSupportSecondaryProgressTintMode]
   * @see @see [android.support.v4.graphics.drawable.DrawableCompat.setTintMode]
   */
  fun setSupportSecondaryProgressTintMode(tintMode: PorterDuff.Mode)

  /**
   * Returns the blending mode used to apply the tint to the secondary
   * progress drawable, if specified.
   *
   * @return the blending mode used to apply the tint to the secondary progress drawable
   *
   * @see [setSupportSecondaryProgressTintMode]
   */
  fun getSupportSecondaryProgressTintMode(): PorterDuff.Mode
}