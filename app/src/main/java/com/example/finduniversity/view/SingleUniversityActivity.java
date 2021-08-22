package com.example.finduniversity.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finduniversity.R;
import com.example.finduniversity.data.University;
import com.example.finduniversity.view.adapter.SingleUniversityLinksAdapter;

import java.util.List;

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
            links = findViewById(R.id.activity_single_university_links);

            String universityName = university.getName();
            String universityCountry = university.getCountry();
            List<String> webPages = university.getWebPages();
            List<String> domains = university.getDomains();

            name.setText(universityName);
            country.setText(universityCountry);

            links.setLayoutManager(new LinearLayoutManager(this));
            links.setAdapter(new SingleUniversityLinksAdapter(this, webPages, domains));
        }
    }
}
