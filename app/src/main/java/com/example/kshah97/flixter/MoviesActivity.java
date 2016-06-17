package com.example.kshah97.flixter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kshah97.flixter.models.Movie;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MoviesActivity extends AppCompatActivity {

    ArrayList<Movie> movies;
    MoviesAdapter moviesAdapter;
    ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        lvItems = (ListView) findViewById(R.id.lvMovies);

        movies = new ArrayList<>();

        moviesAdapter = new MoviesAdapter(this, movies);

        lvItems.setAdapter(moviesAdapter);

        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";

        AsyncHttpClient client = new AsyncHttpClient();

        client.get(url, new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                JSONArray movieJsonResults = null;

                try {
                    movieJsonResults = response.getJSONArray("results");
                    movies.addAll(Movie.fromJSONArray(movieJsonResults));
                    moviesAdapter.notifyDataSetChanged();
                    Log.d("DEBUG", movies.toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });


        itemClickListener();





        /*
        // 1. Get the actual movies

        ArrayList<Movie> movies = Movie.fromJson();
        // 2. Get the listview that we want to populate

        ListView lvMovies = (ListView) findViewById(R.id.lvMovies);
        // 3. Create an ArrayAdapter

        //ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, movies);
        MoviesAdapter adapter = new MoviesAdapter(this, movies);

        // 4. Associate the arrayadapter with the listview

        if (lvMovies != null) {

            lvMovies.setAdapter(adapter);

        }
        **/
    }


    public void itemClickListener(){

        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent open_details = new Intent(MoviesActivity.this, DetailsActivity.class);
                open_details.putExtra("Title",movies.get(position).getTitle());
                open_details.putExtra("Synopsis", movies.get(position).getOverview());
                open_details.putExtra("Rating", movies.get(position).getRating());
                open_details.putExtra("Poster", movies.get(position).getPosterpath());
                startActivity(open_details);

            }
        });
    }

}
