package msv.androidx.sample

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import msv.androidx.appcompat.AppCompatX

class CompoundDrawableActivity : AppCompatActivity() {
  override fun attachBaseContext(context: Context) {
    super.attachBaseContext(AppCompatX.wrap(context))
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.a_compound)
  }
}