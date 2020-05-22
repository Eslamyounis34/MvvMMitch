package com.example.mvvmmitch.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.mvvmmitch.R;
import com.example.mvvmmitch.model.Movie;
import com.example.mvvmmitch.viewmodels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mMainActivityViewModel;
    RecyclerView recyclerView;
    MovieRecyclerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclr);
        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        mMainActivityViewModel.init();
        mMainActivityViewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                Log.e("TESTDATA",movies.toString());

                mAdapter=new MovieRecyclerAdapter(movies,MainActivity.this);
                recyclerView.setAdapter(mAdapter);

            }
        });
        initRecyclerView();
    }
    private void initRecyclerView(){

    }
}
