@file:Suppress("NOTHING_TO_INLINE")

package androidxx.material.textfield

import com.google.android.material.textfield.TextInputLayout

inline fun TextInputLayout.updateEndIconMode(@TextInputLayout.EndIconMode endIconMode: Int) {
  if (endIconMode != this.endIconMode) {
    val endIconDrawable = this.endIconDrawable
    this.endIconMode = endIconMode
    if (endIconMode != TextInputLayout.END_ICON_NONE) {
      this.endIconDrawable = endIconDrawable
    }
  }
}

inline fun TextInputLayout.updateError(error: CharSequence?) {
  if (error != this.error) {
    this.isErrorEnabled = false
    this.error = error
  }
}

inline fun TextInputLayout.updateHelperText(helperText: CharSequence?) {
  if (helperText != this.helperText) {
    this.helperText = helperText
  }
}