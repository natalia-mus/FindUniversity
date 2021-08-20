package com.example.finduniversity.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finduniversity.R;
import com.example.finduniversity.data.University;

public class SingleUniversityActivity extends AppCompatActivity {

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
            Log.e("single university", university.getName());
        }
    }
}
