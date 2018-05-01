package com.minyushov.support.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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