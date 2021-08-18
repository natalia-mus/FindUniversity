package com.example.finduniversity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.finduniversity.data.University;
import com.example.finduniversity.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.universities.observe(this, universitiesObserver);
        viewModel.getUniversities("Poland");
    }

    Observer<List<University>> universitiesObserver = new Observer<List<University>>() {
        @Override
        public void onChanged(List<University> universities) {
            Log.e("obs", universities.get(1).getName());
        }
    };
}