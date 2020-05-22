package com.example.mvvmmitch.model;

import com.google.gson.annotations.SerializedName;

public class Movie {
 //   private int id;
    @SerializedName("name")
    private String movie_name;
    @SerializedName("email")
    private String movie_overView;
  //  private String movie_poster;

    public Movie( String movie_name, String movie_overView) {
      //  this.id = id;
        this.movie_name = movie_name;
        this.movie_overView = movie_overView;
     //   this.movie_poster = movie_poster;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_overView() {
        return movie_overView;
    }

    public void setMovie_overView(String movie_overView) {
        this.movie_overView = movie_overView;
    }

}
