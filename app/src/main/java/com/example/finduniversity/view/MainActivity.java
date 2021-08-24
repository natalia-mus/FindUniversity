package com.example.finduniversity.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.finduniversity.R;
import com.example.finduniversity.data.University;
import com.example.finduniversity.viewmodel.MainActivityViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;
    private EditText countryEditText;
    private Button findUniversitiesButton;
    private Boolean findUniversitiesButtonClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setView();
    }

    private void setView() {
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.universities.observe(this, universitiesObserver);
        viewModel.error.observe(this, errorObserver);

        countryEditText = findViewById(R.id.activity_main_country);
        findUniversitiesButton = findViewById(R.id.activity_main_find_universities_button);

        findUniversitiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findUniversitiesButtonClicked = true;
                String country = countryEditText.getText().toString();
                viewModel.getUniversities(country);
            }
        });
    }

    Observer<ArrayList<University>> universitiesObserver = new Observer<ArrayList<University>>() {
        @Override
        public void onChanged(ArrayList<University> universities) {

            if (findUniversitiesButtonClicked.equals(true)) {
                findUniversitiesButtonClicked = false;
                Intent intent = new Intent(MainActivity.this, UniversitiesListActivity.class);
                intent.putParcelableArrayListExtra("universities", universities);
                startActivity(intent);
            }

        }
    };

    Observer<Boolean> errorObserver = new Observer<Boolean>() {
        @Override
        public void onChanged(Boolean error) {
            if (error) {
                Toast.makeText(MainActivity.this, getString(R.string.error), Toast.LENGTH_LONG).show();
            }
        }
    };
}