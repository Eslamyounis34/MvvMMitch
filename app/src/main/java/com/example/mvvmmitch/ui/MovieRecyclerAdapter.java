package com.example.mvvmmitch.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmmitch.R;
import com.example.mvvmmitch.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.ViewHolder> {

    List<Movie> moviesList=new ArrayList<>();
    Context mContext ;

    public MovieRecyclerAdapter(List<Movie> moviesList, Context mContext) {
        this.moviesList = moviesList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.item_row,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.movieName.setText(moviesList.get(position).getMovie_name());
        holder.movieDesc.setText(moviesList.get(position).getMovie_overView());


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView movieName;
        TextView movieDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            movieName= itemView.findViewById(R.id.movieName);
            movieDesc=itemView.findViewById(R.id.moviedesc);
        }
    }
}

