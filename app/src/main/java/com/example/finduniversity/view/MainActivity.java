package com.example.finduniversity.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.finduniversity.R;
import com.example.finduniversity.data.University;
import com.example.finduniversity.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;
    private EditText countryEditText;
    private Button findUniversitiesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.universities.observe(this, universitiesObserver);

        countryEditText = findViewById(R.id.activity_main_country);
        findUniversitiesButton = findViewById(R.id.activity_main_find_universities_button);

        findUniversitiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String country = countryEditText.getText().toString();
                viewModel.getUniversities(country);
            }
        });
    }

    Observer<List<University>> universitiesObserver = new Observer<List<University>>() {
        @Override
        public void onChanged(List<University> universities) {
            Log.e("obs", universities.get(1).getName());
        }
    };
}