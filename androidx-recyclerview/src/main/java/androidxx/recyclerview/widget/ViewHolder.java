package androidxx.recyclerview.widget;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder<T extends View> extends RecyclerView.ViewHolder {
  @NonNull
  private final T view;

  public ViewHolder(@NonNull T view) {
    super(view);
    this.view = view;
  }

  @NonNull
  public T getView() {
    return view;
  }
}