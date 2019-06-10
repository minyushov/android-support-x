package androidxx.sample

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidxx.appcompat.widget.indeterminateTintListCompat
import androidxx.appcompat.widget.progressBackgroundTintListCompat
import androidxx.appcompat.widget.progressTintListCompat
import androidxx.appcompat.widget.secondaryProgressTintListCompat

class ProgressActivity : AppCompatActivity() {
  private val handler = Handler(Looper.getMainLooper())

  private lateinit var updateProgressRunnable: Runnable

  override fun attachBaseContext(context: Context) {
    super.attachBaseContext(AppCompatX.wrap(context))
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.a_progress)

    val progressBarIndeterminate = findViewById<ProgressBar>(R.id.progress_bar_indeterminate)
    progressBarIndeterminate.indeterminateTintListCompat = ColorStateList.valueOf(Color.RED)

    val progressBar1 = findViewById<ProgressBar>(R.id.progress_bar_1)

    val progressBar2 = findViewById<ProgressBar>(R.id.progress_bar_2)
    progressBar2.progressTintListCompat = ColorStateList.valueOf(Color.GREEN)
    progressBar2.progressBackgroundTintListCompat = ColorStateList.valueOf(Color.BLUE)
    progressBar2.secondaryProgressTintListCompat = ColorStateList.valueOf(Color.RED)

    val progressBar3 = findViewById<ProgressBar>(R.id.progress_bar_3)

    updateProgressRunnable = Runnable {
      progressBar1.progress = ++progressBar1.progress % 100
      progressBar2.progress = ++progressBar2.progress % 100
      progressBar3.progress = ++progressBar3.progress % 100

      handler.postDelayed(updateProgressRunnable, 1000L)
    }
  }

  override fun onStart() {
    super.onStart()
    handler.postDelayed(updateProgressRunnable, 1000L)
  }

  override fun onStop() {
    super.onStop()
    handler.removeCallbacksAndMessages(null)
  }
}