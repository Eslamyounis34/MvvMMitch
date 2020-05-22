package com.example.mvvmmitch.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmmitch.model.Movie;
import com.example.mvvmmitch.repositories.MovieRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    public MutableLiveData<List<Movie>> mMovies;
    public MovieRepository movieRepository;

    public void init()
    {
        if(mMovies !=null)
        {
            return;
        }
        movieRepository=MovieRepository.getInstance();
        mMovies=movieRepository.getMovies();
        Log.e("viewmodelData",mMovies.toString());

    }


    public LiveData<List<Movie>>getMovies()
    {
        return mMovies;
    }

}
