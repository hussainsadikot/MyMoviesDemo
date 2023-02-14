package com.hussain.mymovies.utils.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hussain.mymovies.ModelForMovie;

import java.util.List;

public class MovieListViewModel extends ViewModel {
    private MutableLiveData<List<ModelForMovie>> mutableLiveData = new MutableLiveData<>();
    MovieListViewModel(){}
    public LiveData<List<ModelForMovie>> getMovie(){
        return mutableLiveData;
    }
}
