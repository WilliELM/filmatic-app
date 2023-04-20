package com.example.filmatic_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
}