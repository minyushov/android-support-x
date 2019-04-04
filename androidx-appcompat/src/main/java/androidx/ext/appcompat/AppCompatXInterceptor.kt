package androidx.ext.appcompat

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.ext.appcompat.widget.AppCompatXProgressBar
import androidx.ext.appcompat.widget.AppCompatXTextView
import com.minyushov.inflater.ContextWrapper

class AppCompatXInterceptor : ContextWrapper.InflationInterceptor {
  override fun onCreateView(context: Context, parent: View?, name: String, attrs: AttributeSet?): View? =
    when (name) {
      "TextView" -> AppCompatXTextView(context, attrs)
      "ProgressBar" -> AppCompatXProgressBar(context, attrs)
      else -> null
    }
}