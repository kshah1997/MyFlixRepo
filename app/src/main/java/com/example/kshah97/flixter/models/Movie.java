package com.example.kshah97.flixter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by kshah97 on 6/15/16.
 */
public class Movie {

    public String title;
    public String posterpath;
    public String overview;
    public String backdroppath;
    public double rating;
    public double popularity;


    /*
    public Movie(String title, String posterUrl, String overview) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.overview = overview;
    }

    public static ArrayList<Movie> getFakeMovies() {
        ArrayList<Movie> movies = new ArrayList<Movie>();

        for (int i = 0; i<60; i++) {

            movies.add(new Movie("The Social Network", "", "overview1"));
            movies.add(new Movie("The Internship", "", "overview2"));
            movies.add(new Movie("The Lion King", "", "overview3"));

        }

        return movies;
    }

    public String toString() {
        return title + " - " + overview;
    }

    **/

    public String getTitle() {
        return title;
    }

    public String getPosterpath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterpath);
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdroppath() {
        return String.format("https://image.tmdb.org/t/p/w780/%s", backdroppath);
    }

    public double getRating(){
        return rating;
    }

    public double getPopularity() {
        return popularity;
    }


    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterpath = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("title");
        this.overview = jsonObject.getString("overview");
        this.backdroppath = jsonObject.getString("backdrop_path");
        this.rating =(jsonObject.getDouble("vote_average"))*0.5;
        this.popularity=jsonObject.getDouble("popularity");

    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList();

        for (int i = 0; i < array.length(); i++) {
            try {
                results.add(new Movie(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return results;
    }



}
