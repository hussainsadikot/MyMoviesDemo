package com.hussain.mymovies.retrofit;

import com.hussain.mymovies.ModelForMovie;
import com.hussain.mymovies.response.PopularMovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {
    //get popular list of movie method
    //https://api.themoviedb.org/3/movie/popular?api_key=fdc55a7112c7642f658e7643f2721d35
    @GET("/3/movie/{category}")
    Call<PopularMovieResponse> getPopularMovieList(
       @Path("category") String category,
      @Query("api_key") String api_key,
       @Query("languege") String language,
       @Query("page") int page
    );

}
