package com.example.aalam.dashboardapp;

import android.app.Fragment;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by aalam on 28/4/17.
 */

public class Citizen extends Fragment {
    View v;
    TextView tdate;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        String date = DateFormat.getDateInstance().format(new Date());
        v = inflater.inflate(R.layout.citizen_layout,container,false);
        tdate = (TextView) v.findViewById(R.id.date);
        tdate.setText(date);
        tdate.setTextSize(30);
        return v;
    }
}


