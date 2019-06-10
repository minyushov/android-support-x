package androidxx.recyclerview.widget

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ViewHolder<T : View>(val view: T) : RecyclerView.ViewHolder(view)