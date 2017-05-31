package com.example.test.ListDataApplication.models;

/**
 * Created by Awinash on 18-12-2016.
 */

public class NewsListModel {

    private String mNewsAuthor = "";
    private String mNewsTitle = "";
    private String mNewsDescription = "";
    private String mNewsUrl = "";
    private String mNewsUrlImage = "";
    private String mNewsPublishedDate = "";

    public NewsListModel(String mNewsAuthor, String mNewsTitle, String mNewsDescription, String mNewsUrl,String mNewsUrlImage, String mNewsPublishedDate){

        this.mNewsAuthor = mNewsAuthor;
        this.mNewsTitle = mNewsTitle;
        this.mNewsDescription = mNewsDescription;
        this.mNewsUrl = mNewsUrl;
        this.mNewsUrlImage = mNewsUrlImage;
        this.mNewsPublishedDate = mNewsPublishedDate;

    }

    // Getter, Setter methods for news

    public String getNewsAuthor(){
        return this.mNewsAuthor;
    }

    public void setNewsAuthor(String newsAuthor){
        this.mNewsAuthor = newsAuthor;
    }

    public String getNewsTitle(){
        return this.mNewsTitle;
    }

    public void setNewsTitle(String newsTitle){
        this.mNewsTitle = newsTitle;
    }

    public String getNewsDescription(){
        return this.mNewsDescription;
    }

    public void setNewsDescription(String newsDescription){
        this.mNewsDescription = newsDescription;
    }

    public String getNewsUrl(){
        return this.mNewsUrl;
    }

    public void setNewsUrl(String newsUrl){
        this.mNewsUrl = newsUrl;
    }

    public String getNewsUrlImage(){
        return this.mNewsUrlImage;
    }

    public void setNewsUrlImage(String newsUrlImage){
        this.mNewsUrlImage = newsUrlImage;
    }

    public String getNewsPublishedDate(){
        return this.mNewsPublishedDate;
    }

    public void setNewsPublishedDate(String newsPublishedDate){
        this.mNewsPublishedDate = newsPublishedDate;
    }
}
