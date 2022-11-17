package com.learningproject.newsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AboutPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);
        Toast.makeText(AboutPage.this, "Don't forget to give the repo a star \uD83D\uDE09", Toast.LENGTH_LONG).show();
        Button SourceButton = (Button) findViewById(R.id.SourceButton);
        SourceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sourceLink = new Intent(Intent.ACTION_VIEW);
                sourceLink.setData(Uri.parse("https://github.com/S8M1T/OpenNews"));
                startActivity(sourceLink);
            }
        });
    }
}