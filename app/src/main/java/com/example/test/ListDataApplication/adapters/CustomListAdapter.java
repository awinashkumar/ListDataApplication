package com.example.test.ListDataApplication.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.ListDataApplication.NewsDetailsActivity;
import com.example.test.ListDataApplication.ParseJSON;
import com.example.test.ListDataApplication.R;
import com.example.test.ListDataApplication.models.NewsListModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by Awinash on 18-12-2016.
 */

public class CustomListAdapter extends ArrayAdapter {

    /**
     * Global Context variable
     */
    private Context mContext;

    /**
     * Global ArrayList object
     */
    ArrayList<NewsListModel> newsArrayList = new ArrayList<NewsListModel>();

    /**
     * Global LayoutInflater instance
     */
    LayoutInflater inflater;

    /**
     * Global int layout variable for XML id
     */
    private  int layout;

    /**
     * Constructor of CustomListAdapter class
     *
     * @param context
     * @param layout
     * @param list
     */
    public CustomListAdapter(Context context, int layout, ArrayList<NewsListModel> list){
        super(context, layout, list);
        this.mContext = context;
        this.newsArrayList = list;
        this.layout = layout;
    }

    /**
     **
     * Static class used to avoid the calling of "findViewById" every time the
     * getView() method is called, because this can impact to your application
     * performance when your list is too big. The class is static so it cache
     * all the things inside once it's created.
     */
    private static class ViewHolder{
        protected TextView authorName;
        protected TextView titleName;
        protected TextView description;
        protected TextView publishedAt;
        protected TextView urlNews;
        protected ImageView thumbnail;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null || convertView.getTag() == null){

            viewHolder = new ViewHolder();
            inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layout, parent, false);

            viewHolder.authorName = (TextView) convertView.findViewById(R.id.authorName);
            viewHolder.titleName = (TextView) convertView.findViewById(R.id.titleName);
            viewHolder.description = (TextView) convertView.findViewById(R.id.description);
            viewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.image_thumbnail);

            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        String newsImageUrl = ParseJSON.getNewsList().get(position).getNewsUrlImage();
        if (newsImageUrl != null && newsImageUrl.length() > 0) {

            Picasso.with(mContext).load(newsImageUrl)
                    .resize(100,100).centerCrop()
                    .into(viewHolder.thumbnail);
            //Glide.with(context).load(article.getThumbnail()).centerCrop().into(mainHolder.front_page_item_news_thumbnail);
        }

        viewHolder.authorName.setText(newsArrayList.get(position).getNewsAuthor());
        viewHolder.titleName.setText(newsArrayList.get(position).getNewsTitle());
        viewHolder.description.setText(newsArrayList.get(position).getNewsDescription());


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, NewsDetailsActivity.class);
                intent.putExtra("index",position);
                ((Activity) mContext).startActivity(intent);
            }
        });

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getCount() {
        return newsArrayList.size();
    }
}
