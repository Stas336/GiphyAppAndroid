package com.stasl.giphyapp.api;

import com.stasl.giphyapp.gif.GIF;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GiphyAPI
{
    @GET("v1/gifs/trending")
    Call<GIF> getTrendingGifs(@Query("api_key") String apiKey, @Query("limit") int limit); // publicApiKey dc6zaTOxFJmzC, limit DEFAULT 25 MAX 100
    @GET("v1/gifs/search")
    Call<GIF> searchGifs(@Query("q") String searchTerm, @Query("api_key") String api_key, @Query("limit") int limit);
}
