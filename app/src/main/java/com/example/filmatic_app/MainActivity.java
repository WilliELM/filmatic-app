package com.example.filmatic_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Maheen
    public void navigateToSearch(View view) {
    ImageButton newNavigation = findViewById(R.id.imageButtonSearch);

    Intent newIntentSearch = new Intent(this, ListActivity.class);

    startActivity(newIntentSearch);
    }

    //Maheen
    public void navigateToExplore(View view) {
        ImageButton newNavigation = findViewById(R.id.imageButtonExplore);

        Intent newIntentExplore = new Intent(this, ExploreActivity.class);

        startActivity(newIntentExplore);
    }
}