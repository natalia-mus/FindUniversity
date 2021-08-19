package com.example.finduniversity.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finduniversity.api.Repository;
import com.example.finduniversity.api.RepositoryCallback;
import com.example.finduniversity.data.University;

import java.util.ArrayList;

public class MainActivityViewModel extends ViewModel {

    private static final Repository repository = Repository.getInstance();

    public MutableLiveData<ArrayList<University>> universities = new MutableLiveData<>();

    public void getUniversities(String city) {

        repository.getUniversities(city, new RepositoryCallback<ArrayList<University>>() {
            @Override
            public void onSuccess(ArrayList<University> data) {
                universities.setValue(data);
                Log.e("ViewModel", universities.getValue().toString());
            }

            @Override
            public void onError() {
                Log.e("ViewModel", "error");
            }
        });
    }
}
