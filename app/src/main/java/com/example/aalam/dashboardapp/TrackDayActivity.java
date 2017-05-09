package com.example.aalam.dashboardapp;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TrackDayActivity extends AppCompatActivity {
    List<TrackDayQuestions> mQuestionList = new ArrayList<>();
    String dayStatus;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RecyclerView recyclerView;
        TrackDayAdapter trackDayAdapter;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_day);
     //   final FragmentManager fragmentManager = getFragmentManager();
//        SharedPreferences getPos = getSharedPreferences("StorePos",MODE_PRIVATE);
//        pos = getPos.getInt("retDayPos",0);
        RecyclerView.LayoutManager recylerViewLayoutManager;
        TrackDayQuestions q1 = new TrackDayQuestions("Your Day", "Great",true);
        mQuestionList.add(q1);
        TrackDayQuestions q2 = new TrackDayQuestions("Weather", "Good",false);
        mQuestionList.add(q2);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recylerViewLayoutManager = new LinearLayoutManager(this);
        //State.isSomethingChecked();
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        trackDayAdapter = new TrackDayAdapter(this,mQuestionList);
        recyclerView.setAdapter(trackDayAdapter);


                                            }
                                        }





