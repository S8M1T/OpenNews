package com.learningproject.newsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements CategoriesRecyclerViewAdapter.CategoryClickInterface {

    private RecyclerView newsRecyclerView, categoryRecyclerView;
    private ProgressBar loadingProgressBar;
    private ArrayList<Articles> articlesArrayList;
    private ArrayList<CategoriesRecyclerViewModel> categoriesRecyclerViewModelArrayList;
    private CategoriesRecyclerViewAdapter categoriesRecyclerViewAdapter;
    private NewsRecyclerViewAdapter newsRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView AboutButton = (ImageView) findViewById(R.id.AboutImageView);
        AboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutButton = new Intent(MainActivity.this, AboutPage.class);
                startActivity(aboutButton);
            }
        });
        newsRecyclerView = findViewById(R.id.NewsArea);
        categoryRecyclerView = findViewById(R.id.CategoriesArea);
        loadingProgressBar = findViewById(R.id.Progress);
        articlesArrayList = new ArrayList<>();
        categoriesRecyclerViewModelArrayList = new ArrayList<>();
        newsRecyclerViewAdapter = new NewsRecyclerViewAdapter(articlesArrayList,this);
        categoriesRecyclerViewAdapter = new CategoriesRecyclerViewAdapter(categoriesRecyclerViewModelArrayList,this,this::onCategoryClick);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsRecyclerView.setAdapter(newsRecyclerViewAdapter);
        categoryRecyclerView.setAdapter(categoriesRecyclerViewAdapter);
        getCategories();
        getNews("All");
        newsRecyclerViewAdapter.notifyDataSetChanged();
    }

    private void getCategories(){
        categoriesRecyclerViewModelArrayList.add(new CategoriesRecyclerViewModel("All"));
        categoriesRecyclerViewModelArrayList.add(new CategoriesRecyclerViewModel("Technology"));
        categoriesRecyclerViewModelArrayList.add(new CategoriesRecyclerViewModel("Sports"));
        categoriesRecyclerViewModelArrayList.add(new CategoriesRecyclerViewModel("Entertainment"));
        categoriesRecyclerViewModelArrayList.add(new CategoriesRecyclerViewModel("Business"));
        categoriesRecyclerViewModelArrayList.add(new CategoriesRecyclerViewModel("Science"));
        categoriesRecyclerViewModelArrayList.add(new CategoriesRecyclerViewModel("Health"));
        categoriesRecyclerViewAdapter.notifyDataSetChanged();
    }

    private void getNews(String category){
        loadingProgressBar.setVisibility(View.VISIBLE);
        articlesArrayList.clear();
        String categoryURL = "https://newsapi.org/v2/top-headlines?country=in&category="+category+"&apikey=93cf2ab7f8b846d0b5534da09e77ef9e";
        String url = "https://newsapi.org/v2/top-headlines?country=in&excludeDomains=stackoverflow.com&sortBy=publishedAt&language=en&apikey=93cf2ab7f8b846d0b5534da09e77ef9e";
        String BASE_URL = "https://newsapi.org/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<NewsModel> call;
        if(category.equals("All")) {
            call = retrofitAPI.getAllNews(url);
        }
        else{
            call = retrofitAPI.getNewsByCategory(categoryURL);
        }

        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                NewsModel newsModel = response.body();
                loadingProgressBar.setVisibility(View.GONE);
                ArrayList<Articles> articles = newsModel.getArticles();
                for(int i=0; i<articles.size(); i++){
                    articlesArrayList.add(new Articles(articles.get(i).getTitle(), articles.get(i).getDescription(), articles.get(i).getUrlToImage(), articles.get(i).getUrl(), articles.get(i).getContent()));
                }
                newsRecyclerViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to get news!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onCategoryClick(int position) {
        String category = categoriesRecyclerViewModelArrayList.get(position).getCategory();
        getNews(category);
    }
}