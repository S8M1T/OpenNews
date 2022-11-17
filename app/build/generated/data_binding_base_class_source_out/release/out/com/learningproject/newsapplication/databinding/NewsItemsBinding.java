// Generated by view binder compiler. Do not edit!
package com.learningproject.newsapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.learningproject.newsapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class NewsItemsBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView HeadlineTextView;

  @NonNull
  public final ImageView NewsImage;

  private NewsItemsBinding(@NonNull CardView rootView, @NonNull TextView HeadlineTextView,
      @NonNull ImageView NewsImage) {
    this.rootView = rootView;
    this.HeadlineTextView = HeadlineTextView;
    this.NewsImage = NewsImage;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static NewsItemsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static NewsItemsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.news_items, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static NewsItemsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.HeadlineTextView;
      TextView HeadlineTextView = ViewBindings.findChildViewById(rootView, id);
      if (HeadlineTextView == null) {
        break missingId;
      }

      id = R.id.NewsImage;
      ImageView NewsImage = ViewBindings.findChildViewById(rootView, id);
      if (NewsImage == null) {
        break missingId;
      }

      return new NewsItemsBinding((CardView) rootView, HeadlineTextView, NewsImage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
