package msv.androidx.sample;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import msv.androidx.appcompat.AppCompatX

class MainActivity : AppCompatActivity() {
  override fun attachBaseContext(context: Context) {
    super.attachBaseContext(AppCompatX.wrap(context))
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.a_main)

    findViewById<View>(R.id.progress_bar_compat_button).setOnClickListener {
      startActivity(Intent(this, ProgressActivity::class.java))
    }

    findViewById<View>(R.id.compound_drawable_compat_button).setOnClickListener {
      startActivity(Intent(this, CompoundDrawableActivity::class.java))
    }
  }
}