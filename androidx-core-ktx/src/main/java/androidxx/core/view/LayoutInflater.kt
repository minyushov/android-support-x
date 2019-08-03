@file:Suppress("NOTHING_TO_INLINE")

package androidxx.core.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

inline val Context.inflater: LayoutInflater
  get() = LayoutInflater.from(this)

@Suppress("UNCHECKED_CAST")
inline fun <T : View> LayoutInflater.inflateView(
  @LayoutRes resource: Int,
  root: ViewGroup? = null,
  attachToRoot: Boolean = false
): T = inflate(resource, root, attachToRoot) as T