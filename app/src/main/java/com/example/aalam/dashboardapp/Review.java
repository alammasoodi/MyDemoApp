package com.example.aalam.dashboardapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by aalam on 28/4/17.
 */

public class Review extends Fragment {
    View v;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        v = inflater.inflate(R.layout.review_layout,container,false);
        DatePicker simpleDatePicker = (DatePicker)v.findViewById(R.id.simpleDatePicker);
        simpleDatePicker.setSpinnersShown(false);
        simpleDatePicker.setMaxDate(System.currentTimeMillis());

        return v;
    }
}
