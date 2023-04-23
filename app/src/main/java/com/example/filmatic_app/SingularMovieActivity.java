package com.example.filmatic_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.filmatic_app.databinding.ActivitySingularMovieBinding;

public class SingularMovieActivity extends AppCompatActivity {
    ActivitySingularMovieBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singular_movie);
        binding = ActivitySingularMovieBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null){

            String movieTitle = intent.getStringExtra("movie");
            String picture = intent.getStringExtra("picture");
            String description = intent.getStringExtra("description");

            binding.descriptionOfMovie.setText(description);
            binding.titleOfMovie.setText(movieTitle);
            ImageView imageView = findViewById(R.id.imageOfMovie);
            Glide.with(imageView.getContext()).load(picture).into(imageView);


        }


    }
}