package com.example.test.ListDataApplication;

import com.example.test.ListDataApplication.models.NewsListModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Awinash on 18-12-2016.
 */

public class ParseJSON {

    private static final String JSON_ARRAY = "articles";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_URL = "url";
    private static final String KEY_URL_IMAGE = "urlToImage";
    private static final String KEY_PUBLISHED_AT = "publishedAt";

    private JSONArray mJsonArray = null;

    private  String mJsonResponse;

    private static ArrayList<NewsListModel> sNewsList = new ArrayList<NewsListModel>();

    public ParseJSON(String jsonResponse){
        this.mJsonResponse = jsonResponse;
    }

    protected void parseJSONData(){

        JSONObject mJsonObject = null;

        try {
            mJsonObject = new JSONObject(mJsonResponse);
            mJsonArray = mJsonObject.getJSONArray(JSON_ARRAY);

            for (int i = 0; i < mJsonArray.length(); i++){
                JSONObject mJsonArrayJSONObject = mJsonArray.getJSONObject(i);

                getNewsList().add(new NewsListModel(
                        mJsonArrayJSONObject.getString(KEY_AUTHOR),
                        mJsonArrayJSONObject.getString(KEY_TITLE),
                        mJsonArrayJSONObject.getString(KEY_DESCRIPTION),
                        mJsonArrayJSONObject.getString(KEY_URL),
                        mJsonArrayJSONObject.getString(KEY_URL_IMAGE),
                        mJsonArrayJSONObject.getString(KEY_PUBLISHED_AT)
                ));

            }

        }catch (Exception ex){

        }
    }

    public static ArrayList<NewsListModel> getNewsList(){
        return sNewsList;
    }

    public void  setNewsList(ArrayList<NewsListModel> newsList) {
        sNewsList = newsList;
    }
}
