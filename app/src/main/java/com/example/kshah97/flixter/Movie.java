package com.example.kshah97.flixter;

import java.util.ArrayList;

/**
 * Created by kshah97 on 6/15/16.
 */
public class Movie {

    public String title;
    public int rating;
    public String posterUrl;

    public Movie(String title, String posterUrl, int rating) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.rating = rating;
    }

    public static ArrayList<Movie> getFakeMovies() {
        ArrayList<Movie> movies = new ArrayList<Movie>();

        for (int i = 0; i<60; i++) {

            movies.add(new Movie("The Social Network", "", 75));
            movies.add(new Movie("The Internship", "", 50));
            movies.add(new Movie("The Lion King", "", 100));

        }

        return movies;
    }

    public String toString() {
        return title + " - " + rating;
    }
}
