package com.example.aalam.dashboardapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class EditRaceActivity extends AppCompatActivity {
    Spinner spinner;
    Button select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_race);
        spinner = (Spinner)findViewById(R.id.spinner2);
        select = (Button)findViewById(R.id.bRace);
        List<String> list = new ArrayList<>();
        list.add("USA");
        list.add("India");
        list.add("others");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }
}
