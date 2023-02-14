package com.hussain.mymovies.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hussain.mymovies.ModelForMovie;

import java.util.List;
//response for popular movie list
public class MovieResponse {
   @SerializedName("results")
   @Expose()
   private List<ModelForMovie> movies;

   @SerializedName("total_results")
   @Expose()
   private int total_count;

//   private ModelForMovie movie;
   public List<ModelForMovie> getMovie(){
      return movies;
   }
   public int getTotal_count(){
      return total_count;
   }

   @Override
   public String toString() {
      return "MovieResponse{" +
              "movies=" + movies +
              ", total_count=" + total_count +
              '}';
   }
}
