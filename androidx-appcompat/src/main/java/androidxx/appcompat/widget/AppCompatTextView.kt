package androidxx.appcompat.widget

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.TintContextWrapper
import androidxx.appcompat.view.TintableCompoundDrawableView

open class AppCompatTextView
@JvmOverloads
constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = android.R.attr.textViewStyle
) : AppCompatTextView(
  TintContextWrapper.wrap(context),
  attrs,
  defStyleAttr
), TintableCompoundDrawableView {

  private val compoundDrawableHelper: CompoundDrawableHelper? = CompoundDrawableHelper(this)

  init {
    compoundDrawableHelper?.loadFromAttributes(attrs, defStyleAttr)
  }

  override fun setSupportCompoundDrawableTintList(tint: ColorStateList?) {
    compoundDrawableHelper?.setCompoundDrawableTintList(tint)
  }

  override fun getSupportCompoundDrawableTintList(): ColorStateList? {
    return compoundDrawableHelper?.getCompoundDrawableTintList()
  }

  override fun setSupportCompoundDrawableTintMode(tintMode: PorterDuff.Mode) {
    compoundDrawableHelper?.setCompoundDrawableTintMode(tintMode)
  }

  override fun getSupportCompoundDrawableTintMode(): PorterDuff.Mode {
    return compoundDrawableHelper?.getCompoundDrawableTintMode() ?: DEFAULT_TINT_MODE
  }

  override fun drawableStateChanged() {
    super.drawableStateChanged()
    compoundDrawableHelper?.applyCompoundDrawableTint()
  }
}