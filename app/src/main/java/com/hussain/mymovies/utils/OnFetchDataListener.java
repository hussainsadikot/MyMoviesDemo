package com.hussain.mymovies.utils;

import com.hussain.mymovies.response.Result;

import java.util.List;

public interface OnFetchDataListener<Result> {
    void onFetchPopularMovieList(List<Result> list);

}
