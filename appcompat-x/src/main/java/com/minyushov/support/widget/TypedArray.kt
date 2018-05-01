package com.minyushov.support.widget

import android.annotation.SuppressLint
import android.support.v7.widget.TintTypedArray

@SuppressLint("RestrictedApi")
internal inline fun TintTypedArray.use(action: TintTypedArray.() -> Unit) {
  action()
  recycle()
}

@SuppressLint("RestrictedApi")
internal inline fun TintTypedArray.findValue(index: Int, action: TintTypedArray.(Int) -> Unit) =
  if (hasValue(index)) action(index) else Unit