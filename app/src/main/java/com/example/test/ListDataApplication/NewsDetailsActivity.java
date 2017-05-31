package com.example.test.ListDataApplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Awinash on 18-12-2016.
 */

public class NewsDetailsActivity extends AppCompatActivity {

    /**
     * Global index variable
     *
     */
    private int mReceviedIndex = 0;

//    ImageView mImageUrl;
//    TextView mTitle, mAuthorName, mDescription, mPublishedDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_details_layout);

        /**
         * Enable home button
         *
         */
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /**
         * Received extra intent data which passed on list item click event.
         *
         */
        Intent intent = getIntent();

        if(intent != null){
            mReceviedIndex = intent.getIntExtra("index",0);
            displayDetailsNews();
        }
    }

    /**
     * Display news data.
     *
     */
    private void displayDetailsNews(){
        // Display image icon
        ImageView mImageUrl = (ImageView) findViewById(R.id.image_details_page);
        String newsImageUrl = ParseJSON.getNewsList().get(mReceviedIndex).getNewsUrlImage();
        if (newsImageUrl != null && newsImageUrl.length() > 0) {

            Picasso.with(NewsDetailsActivity.this).load(newsImageUrl).resize(250,200)
                    .centerCrop().into(mImageUrl);
        }

        // Display Author name
        TextView mAuthorName = (TextView) findViewById(R.id.author_details_page);
        mAuthorName.setText(ParseJSON.getNewsList().get(mReceviedIndex).getNewsAuthor());

        // Display Title
        TextView mTitle = (TextView) findViewById(R.id.title_details_page);
        mTitle.setText(ParseJSON.getNewsList().get(mReceviedIndex).getNewsTitle());

        // Display Description
        TextView mDescription = (TextView) findViewById(R.id.description_details_page);
        mDescription.setText(ParseJSON.getNewsList().get(mReceviedIndex).getNewsDescription());

        // Display Published Date
        TextView mPublishedDate = (TextView) findViewById(R.id.published_date_details_page);
        mPublishedDate.setText(ParseJSON.getNewsList().get(mReceviedIndex).getNewsPublishedDate());

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }
}
