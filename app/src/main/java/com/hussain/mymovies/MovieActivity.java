package com.hussain.mymovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.hussain.mymovies.response.MovieResponse;
import com.hussain.mymovies.response.PopularMovieResponse;
import com.hussain.mymovies.response.Result;
import com.hussain.mymovies.retrofit.MovieApi;
import com.hussain.mymovies.retrofit.ServiceReq;
import com.hussain.mymovies.utils.Credential;
import com.hussain.mymovies.utils.OnFetchDataListener;
import com.hussain.mymovies.utils.viewmodel.MovieListViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<ModelForMovie> recyclerDataArrayList;
    public static String LANGUAGE = "en-US";
    public static int PAGE =1;
    public static String CATEGORY ="popular";
    public List<Result> resultList;
    public MovieListViewModel movieListViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        recyclerView=findViewById(R.id.idRV);
        recyclerDataArrayList=new ArrayList<>();

//        getApiResponse();
//        setRecyclerView();
        
        // added data to array list
        recyclerDataArrayList.add(new ModelForMovie("DSA",R.drawable.ic_launcher_foreground));
        recyclerDataArrayList.add(new ModelForMovie("JAVA",R.drawable.ic_launcher_foreground));
        recyclerDataArrayList.add(new ModelForMovie("C++",R.drawable.ic_launcher_foreground));
        recyclerDataArrayList.add(new ModelForMovie("Python",R.drawable.ic_launcher_background));
        recyclerDataArrayList.add(new ModelForMovie("Node Js",R.drawable.ic_launcher_foreground));

//        RecyclerViewAdapter adapter=new RecyclerViewAdapter(recyclerDataArrayList,this);
//        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
        ServiceReq serviceReq =new ServiceReq(this);
        serviceReq.getPopularMovieList(listener);
    }

    private final OnFetchDataListener<Result> listener = new OnFetchDataListener<Result>() {
        @Override
        public void onFetchPopularMovieList(List<Result> list) {
            showPopularMovieList(list);
        }
    };

    private void showPopularMovieList(List<Result> list) {
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(list,this);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void ObserveAnyChange(){
        movieListViewModel.getMovie().observe(this, new Observer<List<ModelForMovie>>() {
            @Override
            public void onChanged(List<ModelForMovie> modelForMovies) {

            }
        });
    }

//    private void setRecyclerView() {
//
//    }

//    private void getApiResponse() {
//          Retrofit retrofit= new Retrofit.Builder().baseUrl(Credential.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create()).build();
//          MovieApi movieApi = retrofit.create(MovieApi.class);
////        MovieApi movieApi=  ServiceReq.getMovieApi();
//        Call<PopularMovieResponse> responseCall = movieApi.getPopularMovieList(CATEGORY,Credential.API_KEY,LANGUAGE,PAGE);
//        responseCall.enqueue(new Callback<PopularMovieResponse>() {
//            @Override
//            public void onResponse(Call<PopularMovieResponse> call, Response<PopularMovieResponse> response) {
//                PopularMovieResponse popularMovieResponse = response.body();
//                List<Result> list= popularMovieResponse.getResults();
//                Result result = list.get(0);
//                Log.d("suc","Title is "+result.getTitle());
//            }
//
//            @Override
//            public void onFailure(Call<PopularMovieResponse> call, Throwable t) {
//
//            }
//        });
//    }
}