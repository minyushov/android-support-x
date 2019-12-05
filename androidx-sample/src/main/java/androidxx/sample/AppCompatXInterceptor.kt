package androidxx.sample

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidxx.appcompat.widget.AppCompatProgressBar
import com.minyushov.inflater.ContextWrapper

class AppCompatXInterceptor : ContextWrapper.InflationInterceptor {
  override fun onCreateView(context: Context, parent: View?, name: String, attrs: AttributeSet?): View? =
    when (name) {
      "ProgressBar" -> AppCompatProgressBar(context, attrs)
      else -> null
    }
}