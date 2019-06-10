package androidxx.appcompat.widget

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.util.AttributeSet
import android.widget.ProgressBar
import androidx.appcompat.widget.DrawableUtils
import androidx.appcompat.widget.TintTypedArray
import androidx.core.graphics.drawable.DrawableCompat
import androidxx.appcompat.R
import androidxx.core.graphics.drawable.wrap

internal class ProgressTintHelper(private val view: ProgressBar) {
  companion object {
    val DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN
  }

  private var progressTintInfo: ProgressTintInfo? = null

  @SuppressLint("RestrictedApi")
  fun loadFromAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
    TintTypedArray
      .obtainStyledAttributes(view.context, attrs, R.styleable.ProgressTintHelper, defStyleAttr, 0)
      .use {
        findValue(R.styleable.ProgressTintHelper_indeterminateTint) {
          view.indeterminateTintListCompat = getColorStateList(it)
        }
        findValue(R.styleable.ProgressTintHelper_indeterminateTintMode) {
          view.indeterminateTintModeCompat = DrawableUtils.parseTintMode(getInt(it, -1), DEFAULT_TINT_MODE)
        }

        findValue(R.styleable.ProgressTintHelper_progressTint) {
          view.progressTintListCompat = getColorStateList(it)
        }
        findValue(R.styleable.ProgressTintHelper_progressTintMode) {
          view.progressTintModeCompat = DrawableUtils.parseTintMode(getInt(it, -1), DEFAULT_TINT_MODE)
        }

        findValue(R.styleable.ProgressTintHelper_progressBackgroundTint) {
          view.progressBackgroundTintListCompat = getColorStateList(it)
        }
        findValue(R.styleable.ProgressTintHelper_progressBackgroundTintMode) {
          view.progressBackgroundTintModeCompat = DrawableUtils.parseTintMode(getInt(it, -1), DEFAULT_TINT_MODE)
        }

        findValue(R.styleable.ProgressTintHelper_secondaryProgressTint) {
          view.secondaryProgressTintListCompat = getColorStateList(it)
        }
        findValue(R.styleable.ProgressTintHelper_secondaryProgressTintMode) {
          view.secondaryProgressTintModeCompat = DrawableUtils.parseTintMode(getInt(it, -1), DEFAULT_TINT_MODE)
        }
      }
  }

  fun onSetProgress(progress: Int) {
    if (progressTintInfo != null) {
      view.invalidate()
    }
  }

  fun onSetSecondaryProgress(progress: Int) {
    if (progressTintInfo != null) {
      view.invalidate()
    }
  }

  fun setIndeterminateTintList(tint: ColorStateList?) {
    if (progressTintInfo == null) {
      progressTintInfo = ProgressTintInfo()
    }

    progressTintInfo?.indeterminateTintList = tint
    progressTintInfo?.hasIndeterminateTint = true

    applyIndeterminateTint()
  }

  fun getIndeterminateTintList(): ColorStateList? =
    progressTintInfo?.indeterminateTintList

  fun setIndeterminateTintMode(tintMode: PorterDuff.Mode?) {
    if (progressTintInfo == null) {
      progressTintInfo = ProgressTintInfo()
    }

    progressTintInfo?.indeterminateTintMode = tintMode
    progressTintInfo?.hasIndeterminateTintMode = true

    applyIndeterminateTint()
  }

  fun getIndeterminateTintMode(): PorterDuff.Mode =
    progressTintInfo?.indeterminateTintMode ?: DEFAULT_TINT_MODE

  private fun applyIndeterminateTint() {
    val tintInfo = progressTintInfo
    val indeterminateDrawable = view.indeterminateDrawable

    if (view.indeterminateDrawable != null && tintInfo != null) {
      if (tintInfo.hasIndeterminateTint || tintInfo.hasIndeterminateTintMode) {
        val drawable = DrawableCompat.wrap(indeterminateDrawable).mutate()

        if (tintInfo.hasIndeterminateTint) {
          DrawableCompat.setTintList(drawable, getIndeterminateTintList())
        }

        if (tintInfo.hasIndeterminateTintMode) {
          DrawableCompat.setTintMode(drawable, getIndeterminateTintMode())
        }

        // The drawable (or one of its children) may not have been
        // stateful before applying the tint, so let's try again.
        if (drawable.isStateful) {
          drawable.state = view.drawableState
        }

        view.indeterminateDrawable = drawable
      }
    }
  }

  fun setProgressTintList(tint: ColorStateList?) {
    if (progressTintInfo == null) {
      progressTintInfo = ProgressTintInfo()
    }

    progressTintInfo?.progressTintList = tint
    progressTintInfo?.hasProgressTint = true

    if (view.progressDrawable != null) {
      applyPrimaryProgressTint()
    }
  }

  fun getProgressTintList(): ColorStateList? =
    progressTintInfo?.progressTintList

  fun setProgressTintMode(tintMode: PorterDuff.Mode?) {
    if (progressTintInfo == null) {
      progressTintInfo = ProgressTintInfo()
    }

    progressTintInfo?.progressTintMode = tintMode
    progressTintInfo?.hasProgressTintMode = true

    if (view.progressDrawable != null) {
      applyPrimaryProgressTint()
    }
  }

  fun getProgressTintMode(): PorterDuff.Mode =
    progressTintInfo?.progressTintMode ?: DEFAULT_TINT_MODE

  private fun applyPrimaryProgressTint() {
    val tintInfo = progressTintInfo ?: return

    if (tintInfo.hasProgressTint || tintInfo.hasProgressTintMode) {
      val target = getTintTarget(android.R.id.progress, true)
      if (target != null) {
        if (tintInfo.hasProgressTint) {
          DrawableCompat.setTintList(target, getProgressTintList())
        }
        if (tintInfo.hasProgressTintMode) {
          DrawableCompat.setTintMode(target, getProgressTintMode())
        }

        // The drawable (or one of its children) may not have been
        // stateful before applying the tint, so let's try again.
        if (target.isStateful) {
          target.state = view.drawableState
        }
      }
    }
  }

  fun setProgressBackgroundTintList(tint: ColorStateList?) {
    if (progressTintInfo == null) {
      progressTintInfo = ProgressTintInfo()
    }

    progressTintInfo?.progressBackgroundTintList = tint
    progressTintInfo?.hasProgressBackgroundTint = true

    if (view.progressDrawable != null) {
      applyProgressBackgroundTint()
    }
  }

  fun getProgressBackgroundTintList(): ColorStateList? =
    progressTintInfo?.progressBackgroundTintList

  fun setProgressBackgroundTintMode(tintMode: PorterDuff.Mode?) {
    if (progressTintInfo == null) {
      progressTintInfo = ProgressTintInfo()
    }

    progressTintInfo?.progressBackgroundTintMode = tintMode
    progressTintInfo?.hasProgressBackgroundTintMode = true

    if (view.progressDrawable != null) {
      applyProgressBackgroundTint()
    }
  }

  fun getProgressBackgroundTintMode(): PorterDuff.Mode =
    progressTintInfo?.progressBackgroundTintMode ?: DEFAULT_TINT_MODE

  private fun applyProgressBackgroundTint() {
    val tintInfo = progressTintInfo ?: return

    if (tintInfo.hasProgressBackgroundTint || tintInfo.hasProgressBackgroundTintMode) {
      val target = getTintTarget(android.R.id.background, false)
      if (target != null) {
        if (tintInfo.hasProgressBackgroundTint) {
          DrawableCompat.setTintList(target, getProgressBackgroundTintList())
        }
        if (tintInfo.hasProgressBackgroundTintMode) {
          DrawableCompat.setTintMode(target, getProgressBackgroundTintMode())
        }

        // The drawable (or one of its children) may not have been
        // stateful before applying the tint, so let's try again.
        if (target.isStateful) {
          target.state = view.drawableState
        }
      }
    }
  }

  fun setSecondaryProgressTintList(tint: ColorStateList?) {
    if (progressTintInfo == null) {
      progressTintInfo = ProgressTintInfo()
    }

    progressTintInfo?.secondaryProgressTintList = tint
    progressTintInfo?.hasSecondaryProgressTint = true

    if (view.progressDrawable != null) {
      applySecondaryProgressTint()
    }
  }

  fun getSecondaryProgressTintList(): ColorStateList? =
    progressTintInfo?.secondaryProgressTintList

  fun setSecondaryProgressTintMode(tintMode: PorterDuff.Mode?) {
    if (progressTintInfo == null) {
      progressTintInfo = ProgressTintInfo()
    }

    progressTintInfo?.secondaryProgressTintMode = tintMode
    progressTintInfo?.hasSecondaryProgressTintMode = true

    if (view.progressDrawable != null) {
      applySecondaryProgressTint()
    }
  }

  fun getSecondaryProgressTintMode(): PorterDuff.Mode =
    progressTintInfo?.secondaryProgressTintMode ?: DEFAULT_TINT_MODE

  private fun applySecondaryProgressTint() {
    val tintInfo = progressTintInfo ?: return

    if (tintInfo.hasSecondaryProgressTint || tintInfo.hasSecondaryProgressTintMode) {
      val target = getTintTarget(android.R.id.secondaryProgress, false)
      if (target != null) {

        if (tintInfo.hasSecondaryProgressTint) {
          DrawableCompat.setTintList(target, getSecondaryProgressTintList())
        }
        if (tintInfo.hasSecondaryProgressTintMode) {
          DrawableCompat.setTintMode(target, getSecondaryProgressTintMode())
        }

        // The drawable (or one of its children) may not have been
        // stateful before applying the tint, so let's try again.
        if (target.isStateful) {
          target.state = view.drawableState
        }
      }
    }
  }

  private fun getTintTarget(layerId: Int, shouldFallback: Boolean): Drawable? {
    var layer: Drawable? = null
    val drawable = DrawableCompat.unwrap<Drawable>(view.progressDrawable)

    if (drawable != null) {
      if (drawable is LayerDrawable) {
        layer = drawable.findDrawableByLayerId(layerId)
        if (layer != null) {
          layer = layer.wrap().mutate()
          drawable.setDrawableByLayerId(layerId, layer)
        }
      }

      if (shouldFallback && layer == null) {
        layer = drawable
        view.progressDrawable = DrawableCompat.wrap(drawable).mutate()
      }
    }

    return layer
  }

  private class ProgressTintInfo {
    var indeterminateTintList: ColorStateList? = null
    var indeterminateTintMode: PorterDuff.Mode? = null
    var hasIndeterminateTint: Boolean = false
    var hasIndeterminateTintMode: Boolean = false

    var progressTintList: ColorStateList? = null
    var progressTintMode: PorterDuff.Mode? = null
    var hasProgressTint: Boolean = false
    var hasProgressTintMode: Boolean = false

    var progressBackgroundTintList: ColorStateList? = null
    var progressBackgroundTintMode: PorterDuff.Mode? = null
    var hasProgressBackgroundTint: Boolean = false
    var hasProgressBackgroundTintMode: Boolean = false

    var secondaryProgressTintList: ColorStateList? = null
    var secondaryProgressTintMode: PorterDuff.Mode? = null
    var hasSecondaryProgressTint: Boolean = false
    var hasSecondaryProgressTintMode: Boolean = false
  }
}