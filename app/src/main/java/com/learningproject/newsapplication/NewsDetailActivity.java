package com.learningproject.newsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {

    String title,desc,content,imageURL,url;
    private TextView titleTextView, descTextView, contentTextView;
    private ImageView newsImageView;
    private Button readNewsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        title = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("desc");
        //content = getIntent().getStringExtra("content");
        imageURL = getIntent().getStringExtra("image");
        url = getIntent().getStringExtra("url");
        titleTextView = findViewById(R.id.HeadlineTextView);
        descTextView = findViewById(R.id.DescriptionTextView);
        //contentTextView = findViewById(R.id.ContentTextView);
        newsImageView = findViewById(R.id.NewsImage);
        readNewsButton = findViewById(R.id.ReadNewsButton);
        titleTextView.setText(title);
        descTextView.setText(desc);
        //contentTextView.setText(content);
        Picasso.get().load(imageURL).into(newsImageView);
        readNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i );
            }
        });
    }
}