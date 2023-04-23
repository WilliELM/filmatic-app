package com.example.filmatic_app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
//William
public class MovieAdapter extends ArrayAdapter<MovieFetcher> {
    private ArrayList<MovieFetcher> itemList;

    public static Bitmap getBitmapFromURL(String src) {
        try {
            Log.e("src", src);
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            Log.e("Bitmap", "returned");
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
            return null;
        }
    }


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


        //Load images, title and description to imageview and textviews
        Glide.with(getContext()).load(movieFetcher.getPicture()).into(imageView);
        movieName.setText(movieFetcher.getTitle());
        movieDescription.setText(movieFetcher.getDescription());



        return super.getView(position, convertView, parent);
    }
}
