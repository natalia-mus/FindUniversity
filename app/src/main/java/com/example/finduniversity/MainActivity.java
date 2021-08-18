package com.example.finduniversity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.finduniversity.api.Repository;
import com.example.finduniversity.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Repository repo = Repository.getInstance();
        //repo.getUniversities("Poland");

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.getUniversities("Poland");
    }
}