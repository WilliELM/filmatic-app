package com.example.filmatic_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.filmatic_app.databinding.ActivityExploreBinding;
import com.example.filmatic_app.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExploreActivity extends AppCompatActivity {

    private SearchView searchView;
    private ArrayList<MovieFetcher> itemList;
    private ArrayList<String> movieTitleList;
    ActivityExploreBinding binding;

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





        fetchMovie();

        System.out.println(itemList);
        //William

        itemList = new ArrayList<>();
        movieTitleList = new ArrayList<>();

    }

    // setFilteredList skal kaldes med liste over film (moviefetchers)
    //William
    public void setFilteredList (ArrayList<String> filteredList){
        this.movieTitleList = filteredList;
    }

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
                            System.out.println(titleOfMovie);
                            String description = response.getJSONArray("result").getJSONObject(i).getString("overview");
                            JSONArray cast = response.getJSONArray("result").getJSONObject(i).getJSONArray("cast");
                            int rating = response.getJSONArray("result").getJSONObject(i).getInt("imdbRating");
                            int runtime = 0;
                            //int runtime = response.getJSONArray("result").getJSONObject(i).getInt("runtime");
                            JSONArray servicesToStream = null;
                            String posterPath = "https://image.tmdb.org/t/p/w300" + response.getJSONArray("result").getJSONObject(i).getString("posterPath");

                            MovieFetcher n = new MovieFetcher(rating,runtime,titleOfMovie,description,cast,posterPath,servicesToStream);
                            itemList.add(n);
                            movieTitleList.add(n.getTitle());
                            setFilteredList(movieTitleList);
                            //ArrayAdapter<String> myAdapter = new ArrayAdapter<>(ExploreActivity.this, android.R.layout.simple_list_item_1, movieTitleList);
                           // myListView.setAdapter(myAdapter);



                        }// nicklas
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                    //William
                    binding = ActivityExploreBinding.inflate(getLayoutInflater());
                    setContentView(binding.getRoot());
                    MovieAdapter movieAdapter = new MovieAdapter(ExploreActivity.this,R.layout.list_item,R.id.titleOfMovie,itemList);





                    binding.movieListExplore.setAdapter(movieAdapter);
                    binding.movieListExplore.setClickable(true);
                    binding.movieListExplore.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                       @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                             //intent til ny activity skal indsættes her!!!!
                             Intent intent = new Intent(ExploreActivity.this,SingularMovieActivity.class);
                             intent.putExtra("movie",itemList.get(position).getTitle());
                             intent.putExtra("description",itemList.get(position).getDescription());
                             intent.putExtra("picture",itemList.get(position).getPicture());
                             startActivity(intent);
                        }
                    });

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