package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {

    String posterPath;
    String title;
    String overview;
    double rating;

    //empty constructor needed by the Parceler library.
    public Movie(){

    }

    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        title  = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
    }

    public static List<com.example.flixster.models.Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<com.example.flixster.models.Movie> movies = new ArrayList<>();
        for (int i = 0; i< movieJsonArray.length(); i++){
            movies.add(new com.example.flixster.models.Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }


    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating(){
        return rating;
    }
}
