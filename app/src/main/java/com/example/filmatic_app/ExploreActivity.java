package com.example.filmatic_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ExploreActivity extends AppCompatActivity {
    //Maheen
    public void navigateToHome(View view) {
        ImageButton newNavigation = findViewById(R.id.imageButtonHome);
        Intent newIntentHome = new Intent(this, MainActivity.class);
        startActivity(newIntentHome);
    }
    //Maheen
    public void navigateToSearch(View view) {
        ImageButton newNavigation = findViewById(R.id.imageButtonSearch);
        Intent newIntentSearch = new Intent(this, ListActivity.class);
        startActivity(newIntentSearch);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
    }
}