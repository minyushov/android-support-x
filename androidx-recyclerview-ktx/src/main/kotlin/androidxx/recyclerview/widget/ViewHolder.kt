package androidxx.recyclerview.widget

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class ViewHolder<T : View>(val view: T) : RecyclerView.ViewHolder(view)