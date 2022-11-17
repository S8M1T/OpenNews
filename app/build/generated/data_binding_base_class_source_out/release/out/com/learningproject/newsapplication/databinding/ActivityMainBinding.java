// Generated by view binder compiler. Do not edit!
package com.learningproject.newsapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.learningproject.newsapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView AboutImageView;

  @NonNull
  public final RecyclerView CategoriesArea;

  @NonNull
  public final RecyclerView NewsArea;

  @NonNull
  public final ProgressBar Progress;

  @NonNull
  public final Toolbar Toolbar;

  private ActivityMainBinding(@NonNull RelativeLayout rootView, @NonNull ImageView AboutImageView,
      @NonNull RecyclerView CategoriesArea, @NonNull RecyclerView NewsArea,
      @NonNull ProgressBar Progress, @NonNull Toolbar Toolbar) {
    this.rootView = rootView;
    this.AboutImageView = AboutImageView;
    this.CategoriesArea = CategoriesArea;
    this.NewsArea = NewsArea;
    this.Progress = Progress;
    this.Toolbar = Toolbar;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.AboutImageView;
      ImageView AboutImageView = ViewBindings.findChildViewById(rootView, id);
      if (AboutImageView == null) {
        break missingId;
      }

      id = R.id.CategoriesArea;
      RecyclerView CategoriesArea = ViewBindings.findChildViewById(rootView, id);
      if (CategoriesArea == null) {
        break missingId;
      }

      id = R.id.NewsArea;
      RecyclerView NewsArea = ViewBindings.findChildViewById(rootView, id);
      if (NewsArea == null) {
        break missingId;
      }

      id = R.id.Progress;
      ProgressBar Progress = ViewBindings.findChildViewById(rootView, id);
      if (Progress == null) {
        break missingId;
      }

      id = R.id.Toolbar;
      Toolbar Toolbar = ViewBindings.findChildViewById(rootView, id);
      if (Toolbar == null) {
        break missingId;
      }

      return new ActivityMainBinding((RelativeLayout) rootView, AboutImageView, CategoriesArea,
          NewsArea, Progress, Toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}