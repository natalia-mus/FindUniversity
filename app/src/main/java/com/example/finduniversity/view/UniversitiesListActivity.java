package com.example.finduniversity.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finduniversity.R;
import com.example.finduniversity.data.University;
import com.example.finduniversity.view.adapter.UniversitiesListAdapter;
import com.example.finduniversity.view.interfaces.OnUniversityItemClick;

import java.util.ArrayList;

public class UniversitiesListActivity extends AppCompatActivity implements OnUniversityItemClick {

    private RecyclerView universitiesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universities_list);

        setView();
    }

    private void setView() {
        Intent intent = getIntent();

        if (intent.hasExtra("universities")) {
            ArrayList<University> universities = intent.getParcelableArrayListExtra("universities");
            universitiesList = findViewById(R.id.activity_universities_list_recyclerView);
            universitiesList.setLayoutManager(new LinearLayoutManager(this));
            universitiesList.setAdapter(new UniversitiesListAdapter(this, universities, this));
        }
    }

    @Override
    public void onUniversityItemClicked(University university) {
        Intent intent = new Intent(this, SingleUniversityActivity.class);
        intent.putExtra("university", university);
        startActivity(intent);
    }
}