package com.minyushov.appcompat.sample;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.minyushov.support.v7.AppCompatX

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
  }
}