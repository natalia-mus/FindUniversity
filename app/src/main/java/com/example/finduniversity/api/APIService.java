package com.example.finduniversity.api;

import com.example.finduniversity.University;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @GET("{search}")
    Call<List<University>> getUniversities(@Path("search") String search, @Query("country") String country);
}
