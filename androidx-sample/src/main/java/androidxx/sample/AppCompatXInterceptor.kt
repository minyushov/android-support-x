package androidxx.sample

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidxx.appcompat.widget.AppCompatProgressBar
import androidxx.appcompat.widget.AppCompatTextView
import com.minyushov.inflater.ContextWrapper

class AppCompatXInterceptor : ContextWrapper.InflationInterceptor {
  override fun onCreateView(context: Context, parent: View?, name: String, attrs: AttributeSet?): View? =
    when (name) {
      "TextView" -> AppCompatTextView(context, attrs)
      "ProgressBar" -> AppCompatProgressBar(context, attrs)
      else -> null
    }
}