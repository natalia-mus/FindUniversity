package com.example.finduniversity.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finduniversity.R;
import com.example.finduniversity.data.University;

import java.util.ArrayList;

public class UniversitiesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universities_list);

        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        if (intent.hasExtra("universities")) {
            ArrayList<University> universities = intent.getParcelableArrayListExtra("universities");
        }
    }
}
