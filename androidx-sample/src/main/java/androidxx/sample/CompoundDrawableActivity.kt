package androidxx.sample

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CompoundDrawableActivity : AppCompatActivity() {
  override fun attachBaseContext(context: Context) {
    super.attachBaseContext(AppCompatX.wrap(context))
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.a_compound)
  }
}