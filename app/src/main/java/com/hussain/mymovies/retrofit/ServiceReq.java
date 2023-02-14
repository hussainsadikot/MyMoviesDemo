package com.hussain.mymovies.retrofit;

import android.content.Context;
import android.util.Log;

import com.hussain.mymovies.MovieActivity;
import com.hussain.mymovies.response.PopularMovieResponse;
import com.hussain.mymovies.response.Result;
import com.hussain.mymovies.utils.Credential;
import com.hussain.mymovies.utils.OnFetchDataListener;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceReq {
   public static String LANGUAGE = "en-US";
   public static int PAGE =1;
   public static String CATEGORY ="popular";
   Context context;
   Retrofit retrofit= new Retrofit.Builder().baseUrl(Credential.BASE_URL)
           .addConverterFactory(GsonConverterFactory.create()).build();

   public ServiceReq(Context context) {
      this.context = context;
   }

//   public static MovieApi getMovieApi(){
//      return movieApi;
//   }

   public void getPopularMovieList(OnFetchDataListener onFetchDataListener){


      MovieApi movieApi = retrofit.create(MovieApi.class);
//        MovieApi movieApi=  ServiceReq.getMovieApi();
      Call<PopularMovieResponse> responseCall = movieApi.getPopularMovieList(CATEGORY,Credential.API_KEY,LANGUAGE,PAGE);
     try{ responseCall.enqueue(new Callback<PopularMovieResponse>() {
         @Override
         public void onResponse(Call<PopularMovieResponse> call, Response<PopularMovieResponse> response) {
            PopularMovieResponse popularMovieResponse = response.body();
            List<Result> list= popularMovieResponse.getResults();
            Result result = list.get(0);
            Log.d("suc","Title is "+result.getTitle());
            onFetchDataListener.onFetchPopularMovieList(list);
         }

         @Override
         public void onFailure(Call<PopularMovieResponse> call, Throwable t) {

         }
      });}
     catch (Exception e){
        e.printStackTrace();
     }
   }
}
