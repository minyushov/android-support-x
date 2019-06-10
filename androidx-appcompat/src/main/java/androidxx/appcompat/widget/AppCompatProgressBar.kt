package androidxx.appcompat.widget

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.widget.ProgressBar
import androidx.appcompat.widget.TintContextWrapper
import androidxx.appcompat.view.TintableProgressBar

open class AppCompatProgressBar
@JvmOverloads
constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = android.R.attr.progressBarStyle
) : ProgressBar(
  TintContextWrapper.wrap(context),
  attrs,
  defStyleAttr
), TintableProgressBar {

  private val progressTintHelper: ProgressTintHelper? = ProgressTintHelper(this)

  init {
    progressTintHelper?.loadFromAttributes(attrs, defStyleAttr)
  }

  override fun setSupportIndeterminateTintList(tint: ColorStateList?) {
    progressTintHelper?.setIndeterminateTintList(tint)
  }

  override fun getSupportIndeterminateTintList(): ColorStateList? {
    return progressTintHelper?.getIndeterminateTintList()
  }

  override fun setSupportIndeterminateTintMode(tintMode: PorterDuff.Mode?) {
    progressTintHelper?.setIndeterminateTintMode(tintMode)
  }

  override fun getSupportIndeterminateTintMode(): PorterDuff.Mode? {
    return progressTintHelper?.getIndeterminateTintMode() ?: DEFAULT_TINT_MODE
  }

  override fun setSupportProgressTintList(tint: ColorStateList?) {
    progressTintHelper?.setProgressTintList(tint)
  }

  override fun getSupportProgressTintList(): ColorStateList? {
    return progressTintHelper?.getProgressTintList()
  }

  override fun setSupportProgressTintMode(tintMode: PorterDuff.Mode?) {
    progressTintHelper?.setProgressTintMode(tintMode)
  }

  override fun getSupportProgressTintMode(): PorterDuff.Mode? {
    return progressTintHelper?.getProgressTintMode() ?: DEFAULT_TINT_MODE
  }

  override fun setSupportProgressBackgroundTintList(tint: ColorStateList?) {
    progressTintHelper?.setProgressBackgroundTintList(tint)
  }

  override fun getSupportProgressBackgroundTintList(): ColorStateList? {
    return progressTintHelper?.getProgressBackgroundTintList()
  }

  override fun setSupportProgressBackgroundTintMode(tintMode: PorterDuff.Mode?) {
    progressTintHelper?.setProgressBackgroundTintMode(tintMode)
  }

  override fun getSupportProgressBackgroundTintMode(): PorterDuff.Mode? {
    return progressTintHelper?.getProgressBackgroundTintMode() ?: DEFAULT_TINT_MODE
  }

  override fun setSupportSecondaryProgressTintList(tint: ColorStateList?) {
    progressTintHelper?.setSecondaryProgressTintList(tint)
  }

  override fun getSupportSecondaryProgressTintList(): ColorStateList? {
    return progressTintHelper?.getSecondaryProgressTintList()
  }

  override fun setSupportSecondaryProgressTintMode(tintMode: PorterDuff.Mode?) {
    progressTintHelper?.setSecondaryProgressTintMode(tintMode)
  }

  override fun getSupportSecondaryProgressTintMode(): PorterDuff.Mode? {
    return progressTintHelper?.getSecondaryProgressTintMode() ?: DEFAULT_TINT_MODE
  }

  override fun setProgress(progress: Int) {
    super.setProgress(progress)
    progressTintHelper?.onSetProgress(progress)
  }

  override fun setSecondaryProgress(secondaryProgress: Int) {
    super.setSecondaryProgress(secondaryProgress)
    progressTintHelper?.onSetSecondaryProgress(progress)
  }
}