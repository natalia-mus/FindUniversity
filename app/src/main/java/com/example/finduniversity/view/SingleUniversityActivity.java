package com.example.finduniversity.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finduniversity.R;
import com.example.finduniversity.data.University;

public class SingleUniversityActivity extends AppCompatActivity {

    TextView name, country;
    RecyclerView links;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_university);

        setView();
    }

    private void setView() {
        Intent intent = getIntent();

        if (intent.hasExtra("university")) {
            University university = intent.getParcelableExtra("university");

            name = findViewById(R.id.activity_single_university_name);
            country = findViewById(R.id.activity_single_university_country);

            String universityName = university.getName();
            String universityCountry = university.getCountry();

            name.setText(universityName);
            country.setText(universityCountry);
        }
    }
}
