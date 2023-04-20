package com.example.filmatic_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    //Maheen
    public void navigateToHome(View view) {
        ImageButton newNavigation = findViewById(R.id.imageButtonHome);

        Intent newIntentHome = new Intent(this, MainActivity.class);

        startActivity(newIntentHome);
    }

    //Maheen
    public void navigateToExplore(View view) {
        ImageButton newNavigation = findViewById(R.id.imageButtonExplore);

        Intent newIntentExplore = new Intent(this, ExploreActivity.class);

        startActivity(newIntentExplore);
    }
}