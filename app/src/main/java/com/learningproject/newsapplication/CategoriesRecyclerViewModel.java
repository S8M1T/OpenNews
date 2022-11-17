package com.learningproject.newsapplication;

public class CategoriesRecyclerViewModel {
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public CategoriesRecyclerViewModel(String category) {
        this.category = category;
    }
}
