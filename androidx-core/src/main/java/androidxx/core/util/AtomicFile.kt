package androidxx.core.util

import androidx.core.util.AtomicFile
import java.io.FileOutputStream

inline fun AtomicFile.tryWrite(block: (out: FileOutputStream) -> Unit) {
  val stream = startWrite()
  var success = false
  try {
    block(stream)
    success = true
  } finally {
    if (success) {
      finishWrite(stream)
    } else {
      failWrite(stream)
    }
  }
}