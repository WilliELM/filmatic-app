package com.example.filmatic_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private SearchView searchView;
    private List<MovieFetcher> itemList;
    private List<String> movieTitleList;

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

    // setFilteredList skal kaldes med liste over film (moviefetchers)
    //William

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // fetchMovie();

        System.out.println(itemList);
        //William
        searchView = findViewById(R.id.SearchBar1);
        searchView.clearFocus();
        //Funktionalitet til searchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        itemList = new ArrayList<>();
        movieTitleList = new ArrayList<>();
    }
}