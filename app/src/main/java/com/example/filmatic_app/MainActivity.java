package com.example.filmatic_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private SearchView searchView;
    private List<MovieFetcher> itemList;

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
    public void setFilteredList (List<MovieFetcher> filteredList){
        this.itemList = filteredList;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //William
        searchView = findViewById(R.id.SearchBar1);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
        itemList = new ArrayList<>();
    }
    //William
    private void filterList(String text) {
        List<MovieFetcher> filteredList = new ArrayList<>();
        //foreach der sorterer liste efter brugerens søgning
        for (MovieFetcher movie : itemList){
            if (movie.getTitle().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(movie);
            }
        }
        //toast hvis der ikke findes noget data fra søgningen
        if (filteredList.isEmpty()){
            Toast.makeText(this,"No data found", Toast.LENGTH_SHORT).show();
        } else {

        }
    }
    //Nicklas
    private void fetchMovie() {
        String url = "https://streaming-availability.p.rapidapi.com/v2/search/title?title=batman&country=dk&show_type=all&output_language=en";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    // Handle the API response here
                    String body = response.toString();
                    Log.d("API Response", body);
                    System.out.println(body);
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    MovieFetcher m = gson.fromJson(body, MovieFetcher.class);
                    Log.d("API Response title", "" + m);
                    String jsonString = gson.toJson(m.getRating());
                    Log.d("JSON string", jsonString);
                },
                error -> {
                    // Handle errors here
                    Log.e("API Error", error.toString());
                }
        ) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                headers.put("X-RapidAPI-Key", "b82e68eadamsh9fd7ac7d38b05bep1a4494jsn8add60e648a7");
                headers.put("X-RapidAPI-Host", "streaming-availability.p.rapidapi.com");
                return headers;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }


}