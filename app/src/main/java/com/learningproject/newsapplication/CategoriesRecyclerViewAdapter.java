package com.learningproject.newsapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoriesRecyclerViewAdapter extends RecyclerView.Adapter<CategoriesRecyclerViewAdapter.ViewHolder> {
    private ArrayList<CategoriesRecyclerViewModel> categoriesRecyclerViewModels;
    private Context context;
    private CategoryClickInterface categoryClickInterface;

    public CategoriesRecyclerViewAdapter(ArrayList<CategoriesRecyclerViewModel> categoriesRecyclerViewModels, Context context, CategoryClickInterface categoryClickInterface) {
        this.categoriesRecyclerViewModels = categoriesRecyclerViewModels;
        this.context = context;
        this.categoryClickInterface = categoryClickInterface;
    }

    @NonNull
    @Override
    public CategoriesRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_items,parent,false);
        return new CategoriesRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesRecyclerViewAdapter.ViewHolder holder, int position) {
        CategoriesRecyclerViewModel categoriesRecyclerViewModel = categoriesRecyclerViewModels.get(position);
        holder.categoryTextView.setText(categoriesRecyclerViewModel.getCategory());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryClickInterface.onCategoryClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoriesRecyclerViewModels.size();
    }

    public interface CategoryClickInterface{
        void onCategoryClick (int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView categoryTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTextView = itemView.findViewById(R.id.CategoriesTextView);
        }
    }
}
