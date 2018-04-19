package com.minyushov.support.v7

import android.content.Context
import com.minyushov.inflater.ContextWrapper

class AppCompatX private constructor() {
  companion object {
    @JvmStatic
    fun wrap(context: Context): Context =
      ContextWrapper
        .Builder(context)
        .addInterceptor(AppCompatXInterceptor())
        .build()
  }
}