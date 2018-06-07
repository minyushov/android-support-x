package msv.androidx.appcompat

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.minyushov.inflater.ContextWrapper
import msv.androidx.appcompat.widget.AppCompatXProgressBar
import msv.androidx.appcompat.widget.AppCompatXTextView

class AppCompatXInterceptor : ContextWrapper.InflationInterceptor {
  override fun onCreateView(context: Context, parent: View?, name: String, attrs: AttributeSet?): View? =
    when (name) {
      "TextView" -> AppCompatXTextView(context, attrs)
      "ProgressBar" -> AppCompatXProgressBar(context, attrs)
      else -> null
    }
}