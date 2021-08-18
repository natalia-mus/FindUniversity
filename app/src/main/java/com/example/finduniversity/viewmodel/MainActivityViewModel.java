package com.example.finduniversity.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finduniversity.api.Repository;
import com.example.finduniversity.data.University;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private static final Repository repository = Repository.getInstance();

    MutableLiveData<List<University>> universities = new MutableLiveData<>();

    public void getUniversities(String city) {
        List<University> data = repository.getUniversities(city);
        universities.setValue(data);
        Log.e("universities", universities.getValue().toString());
    }
}
