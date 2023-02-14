package com.hussain.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hussain.mymovies.response.Result;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>
{
   private List<Result> modelForMovieArrayList;
   private Context mcontext;

   public RecyclerViewAdapter(List<Result> modelForMovieArrayList, Context mcontext) {
      this.modelForMovieArrayList = modelForMovieArrayList;
      this.mcontext = mcontext;
   }

   @NonNull
   @Override
   public RecyclerViewAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_movie_item, parent, false);
      return new RecyclerViewHolder(view);
   }

   @Override
   public void onBindViewHolder(@NonNull RecyclerViewAdapter.RecyclerViewHolder holder, int position) {
      Result recyclerData = modelForMovieArrayList.get(position);
      holder.movieTV.setText(recyclerData.getTitle());
//      holder.imageView.setImageResource(recyclerData.getPosterPath());
      String imageUrl ="https://image.tmdb.org/t/p/w500";
      String imageUrlOg ="https://image.tmdb.org/t/p/original";
      String image="https://image.tmdb.org/t/p/original";
      Picasso.get().load(image+modelForMovieArrayList.get(position).getPosterPath()).into(holder.imageView);
      if(!recyclerData.getPosterPath().isEmpty()){

      }
   }

   @Override
   public int getItemCount() {
      return modelForMovieArrayList.size();
   }
   public class RecyclerViewHolder extends RecyclerView.ViewHolder {

      private TextView movieTV;
      private ImageView imageView;

      public RecyclerViewHolder(@NonNull View itemView) {
         super(itemView);
         movieTV = itemView.findViewById(R.id.tv_movie_name_rv);
         imageView = itemView.findViewById(R.id.iv_movie_rv);
      }
   }
}
