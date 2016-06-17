package com.example.kshah97.flixter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String synopsis = getIntent().getStringExtra("Synopsis");
        String title = getIntent().getStringExtra("Title");
        double rating = getIntent().getDoubleExtra("Rating", 0.00);
        double popularity = getIntent().getDoubleExtra("Popularity", 0.00);
        String ivPoster = getIntent().getStringExtra("Poster");

        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(title);

        TextView tvSynopsis = (TextView) findViewById(R.id.tvSynopsis);
        tvSynopsis.setText(synopsis);

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setRating((float) rating);
        Drawable drawable = ratingBar.getProgressDrawable();  drawable.setColorFilter(Color.parseColor("#e1c323"), PorterDuff.Mode.SRC_ATOP);











    }


}
