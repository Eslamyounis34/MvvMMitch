package com.example.mvvmmitch.data;

import com.example.mvvmmitch.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("users")
    Call<List<Movie>> getHeroes();
}
