package com.example.finduniversity.api;

// http://universities.hipolabs.com/search?country=Poland

import android.util.Log;

import com.example.finduniversity.data.University;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private static final Repository instance = new Repository();
    private static final String BASE_URL = "http://universities.hipolabs.com/";
    private static final String SEARCH = "search";

    ArrayList<University> universities;

    private Repository() {
    }

    ;

    public static Repository getInstance() {
        return instance;
    }

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final APIService apiService = retrofit.create(APIService.class);

    public ArrayList<University> getUniversities(String country, RepositoryCallback<ArrayList<University>> repositoryCallback) {

        Call<ArrayList<University>> call = apiService.getUniversities(SEARCH, country);

        call.enqueue(new Callback<ArrayList<University>>() {
            @Override
            public void onResponse(Call<ArrayList<University>> call, Response<ArrayList<University>> response) {
                if (!response.isSuccessful()) {
                    Log.e("response", "not successful");
                    repositoryCallback.onError();
                } else {
                    Log.e("response", response.body().toString());
                    universities = response.body();
                    repositoryCallback.onSuccess(universities);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<University>> call, Throwable t) {
                Log.e("error", t.toString());
                repositoryCallback.onError();
            }
        });

        return universities;
    }
}
