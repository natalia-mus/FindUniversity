package com.example.finduniversity.api;

// http://universities.hipolabs.com/search?country=Poland

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.finduniversity.data.University;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private static final Repository instance = new Repository();
    private static final String BASE_URL = "http://universities.hipolabs.com/";
    private static final String SEARCH = "search";

    List<University> universities;

    private Repository() { };

    public static Repository getInstance() {
        return instance;
    }

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final APIService apiService = retrofit.create(APIService.class);

    public List<University> getUniversities(String country) {

        Call<List<University>> call = apiService.getUniversities(SEARCH, country);

        call.enqueue(new Callback<List<University>>() {
            @Override
            public void onResponse(Call<List<University>> call, Response<List<University>> response) {
                if (!response.isSuccessful()) {
                    Log.e("response", "not successful");
                } else {
                    Log.e("response", response.body().toString());
                    universities = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<University>> call, Throwable t) {
                Log.e("error", "error");
                Log.e("t", t.toString());
            }
        });

        return universities;
    }
}
