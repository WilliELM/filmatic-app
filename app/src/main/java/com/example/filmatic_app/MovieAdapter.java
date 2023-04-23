package com.example.filmatic_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
//William
public class MovieAdapter extends ArrayAdapter<MovieFetcher> {


    public MovieAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull ArrayList<MovieFetcher> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MovieFetcher movieFetcher = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        ImageView imageView =  convertView.findViewById(R.id.imageOfMovie);
        TextView movieName = convertView.findViewById(R.id.titleOfMovie);
        TextView movieDescription = convertView.findViewById(R.id.movieDescription);


        //imageView.setImageDrawable(movieFetcher.getPicture());
        movieName.setText(movieFetcher.getTitle());
        movieDescription.setText(movieFetcher.getDescription());



        return super.getView(position, convertView, parent);
    }
}
