package msv.androidx.sample

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import msv.androidx.appcompat.AppCompatX
import msv.androidx.appcompat.widget.setSupportIndeterminateTintList
import msv.androidx.appcompat.widget.setSupportProgressBackgroundTintList
import msv.androidx.appcompat.widget.setSupportProgressTintList
import msv.androidx.appcompat.widget.setSupportSecondaryProgressTintList

class ProgressActivity : AppCompatActivity() {
  override fun attachBaseContext(context: Context) {
    super.attachBaseContext(AppCompatX.wrap(context))
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.a_progress)

    val progressBarIndeterminate = findViewById<ProgressBar>(R.id.progress_bar_indeterminate)
    progressBarIndeterminate.setSupportIndeterminateTintList(ColorStateList.valueOf(Color.RED))

    val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
    progressBar.setSupportProgressTintList(ColorStateList.valueOf(Color.GREEN))
    progressBar.setSupportProgressBackgroundTintList(ColorStateList.valueOf(Color.BLUE))
    progressBar.setSupportSecondaryProgressTintList(ColorStateList.valueOf(Color.RED))
  }
}