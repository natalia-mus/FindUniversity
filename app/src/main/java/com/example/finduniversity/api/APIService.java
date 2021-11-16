package com.example.finduniversity.api;

import com.example.finduniversity.data.University;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    // http://universities.hipolabs.com/search?country=Poland

    @GET("{search}")
    Call<ArrayList<University>> getUniversities(@Path("search") String search, @Query("country") String country);
}
