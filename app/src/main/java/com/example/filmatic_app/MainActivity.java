package com.example.filmatic_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

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
    public void setFilteredList (List<String> filteredList){
        this.movieTitleList = filteredList;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // fetchMovie();



        System.out.println(itemList);
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
        movieTitleList = new ArrayList<>();
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
                    System.out.println(response.length());
                    //William
                    try {
                        for (int i = 0; i < response.getJSONArray("result").length()-1; i++) {
                            String titleOfMovie = response.getJSONArray("result").getJSONObject(i).getString("title");
                            String description = response.getJSONArray("result").getJSONObject(i).getString("overview");
                            JSONArray cast = response.getJSONArray("result").getJSONObject(i).getJSONArray("cast");
                            int rating = response.getJSONArray("result").getJSONObject(i).getInt("imdbRating");
                            int runtime = 0;
                            //int runtime = response.getJSONArray("result").getJSONObject(i).getInt("runtime");
                            JSONArray servicesToStream = null;
                            String posterPath = "https://image.tmdb.org/t/p/w300" + response.getJSONArray("result").getJSONObject(i).getString("posterPath");
                            ArrayList<String> movieList = new ArrayList<>();

                            MovieFetcher n = new MovieFetcher(rating,runtime,titleOfMovie,description,cast,posterPath,servicesToStream);
                            itemList.add(n);
                            movieTitleList.add(n.getTitle());
                            System.out.println(itemList.toString());
                            setFilteredList(movieTitleList);
                            ArrayAdapter<String> myAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, movieTitleList);

                            // myListView.setVisibility(View.GONE);


                        }// nicklas
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                },
                error -> {
                    // Handle errors here
                    Log.e("API Error", error.toString());
                }
        ) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                headers.put("X-RapidAPI-Key", "16e69359b6msh3a22f265460a552p16fc9djsn03f7d838b998");
                headers.put("X-RapidAPI-Host", "streaming-availability.p.rapidapi.com");
                return headers;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }


}