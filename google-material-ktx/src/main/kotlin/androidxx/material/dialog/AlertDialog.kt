@file:Suppress("NOTHING_TO_INLINE")

package androidxx.material.dialog

import android.content.Context
import android.view.View
import androidx.annotation.StringRes
import androidx.annotation.StyleRes
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder

inline fun showAlert(
  context: Context,
  @StyleRes theme: Int = 0,
  configuration: AlertDialog.Builder.() -> Unit
) =
  AlertDialog(
    context = context,
    theme = theme,
    configuration = configuration
  ).show()

inline fun AlertDialog(
  context: Context,
  @StyleRes theme: Int = 0,
  configuration: AlertDialog.Builder.() -> Unit
): AlertDialog =
  MaterialAlertDialogBuilder(context, theme)
    .apply(configuration)
    .create()

inline fun AlertDialog.Builder.title(
  @StringRes title: Int
): AlertDialog.Builder =
  setTitle(title)

inline fun AlertDialog.Builder.title(
  title: CharSequence?
): AlertDialog.Builder =
  setTitle(title)

inline fun AlertDialog.Builder.message(
  @StringRes message: Int
): AlertDialog.Builder =
  setMessage(message)

inline fun AlertDialog.Builder.message(
  message: CharSequence?
): AlertDialog.Builder =
  setMessage(message)

inline fun AlertDialog.Builder.positiveButton(
  @StringRes textId: Int
): AlertDialog.Builder =
  setPositiveButton(textId, null)

inline fun AlertDialog.Builder.positiveButton(
  text: CharSequence
): AlertDialog.Builder =
  setPositiveButton(text, null)

inline fun AlertDialog.Builder.positiveButton(
  @StringRes textId: Int,
  crossinline action: () -> Unit
): AlertDialog.Builder =
  setPositiveButton(textId) { _, _ -> action.invoke() }

inline fun AlertDialog.Builder.positiveButton(
  text: CharSequence,
  crossinline action: () -> Unit
): AlertDialog.Builder =
  setPositiveButton(text) { _, _ -> action.invoke() }

inline fun AlertDialog.Builder.negativeButton(
  @StringRes textId: Int
): AlertDialog.Builder =
  setNegativeButton(textId, null)

inline fun AlertDialog.Builder.negativeButton(
  text: CharSequence
): AlertDialog.Builder =
  setNegativeButton(text, null)

inline fun AlertDialog.Builder.negativeButton(
  @StringRes textId: Int,
  crossinline action: () -> Unit
): AlertDialog.Builder =
  setNegativeButton(textId) { _, _ -> action.invoke() }

inline fun AlertDialog.Builder.negativeButton(
  text: CharSequence,
  crossinline action: () -> Unit
): AlertDialog.Builder =
  setNegativeButton(text) { _, _ -> action.invoke() }

inline fun AlertDialog.Builder.neutralButton(
  @StringRes textId: Int
): AlertDialog.Builder =
  setNeutralButton(textId, null)

inline fun AlertDialog.Builder.neutralButton(
  @StringRes textId: Int,
  crossinline action: () -> Unit
): AlertDialog.Builder =
  setNeutralButton(textId) { _, _ -> action.invoke() }

inline fun AlertDialog.Builder.view(
  view: View
): AlertDialog.Builder =
  setView(view)