package com.example.aalam.dashboardapp;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        final FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.frame_layout2,new SurveyFragment1()).commit();
    }


}

