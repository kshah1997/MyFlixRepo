package com.example.kshah97.flixter;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kshah97.flixter.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by kshah97 on 6/15/16.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    private static class ViewHolder {
        TextView title;
        TextView overview;
        ImageView poster;
    }

    public MoviesAdapter(Context context, List<Movie> movies) {
        super(context, R.layout.item_movie, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        boolean isLandscape = getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;


        // Get the data item for this position
        Movie movie = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.overview = (TextView) convertView.findViewById(R.id.tvOverview);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.poster = (ImageView) convertView.findViewById(R.id.ivPoster);
            convertView.setTag(viewHolder);
            //convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
        }

        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        // Populate the data into the template view using the data object
        viewHolder.title.setText(movie.getTitle());
        viewHolder.overview.setText(movie.getOverview());


        //String imageUri = "https://i.imgur.com/tGbaZCY.jpg";

        if (isLandscape) {

            Picasso.with(getContext())
                    .load(movie.getBackdroppath())
                    .fit().centerInside()
                    .placeholder(R.drawable.placeholder)
                    .transform(new RoundedCornersTransformation(10, 10))
                    .into(viewHolder.poster);


        }

        else {
            Picasso.with(getContext())
                    .load(movie.getPosterpath())
                    .fit().centerInside()
                    .placeholder(R.drawable.placeholder)
                    .transform(new RoundedCornersTransformation(10, 10))
                    .into(viewHolder.poster);
        }

        // Return the completed view to render on screen
        return convertView;


    }
}
