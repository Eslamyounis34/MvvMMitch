package com.example.mvvmmitch.repositories;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mvvmmitch.data.Api;
import com.example.mvvmmitch.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieRepository {

    private static MovieRepository instance;
    private List<Movie> moviesList = new ArrayList<>();
    MutableLiveData<List<Movie>> data = new MutableLiveData<>();

    Context mContext;

    //Singleton Pattern
    public static MovieRepository getInstance() {
        if (instance == null) {
            instance = new MovieRepository();
        }
        return instance;
    }


    public MutableLiveData<List<Movie>> getMovies() {
        // setMovies();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Movie>> call = api.getHeroes();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {

                for (int i = 0; i < response.body().size(); i++) {
                    Movie m = new Movie(response.body().get(i).getMovie_name(), response.body().get(i).getMovie_overView());
                    moviesList.add(m);
                }
                data.setValue(moviesList);

            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.e("FAIL", t.getMessage().toString());
            }
        });

        return data;


    }
}


