package com.example.aalam.dashboardapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by aalam on 28/4/17.
 */

public class Insight extends Fragment {
    View v;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        v = inflater.inflate(R.layout.insight_layout,container,false);
        BarChart chart = (BarChart) v.findViewById(R.id.bar_chart);
        ArrayList<BarEntry> BarEntry = new ArrayList<BarEntry>();

        BarEntry.add(new BarEntry(2f, 0));
        BarEntry.add(new BarEntry(4f, 1));
        BarEntry.add(new BarEntry(6f, 2));
        BarEntry.add(new BarEntry(8f, 3));
        BarEntry.add(new BarEntry(7f, 4));
        BarEntry.add(new BarEntry(3f, 5));

        BarDataSet dataSet = new BarDataSet(BarEntry, "Projects");
        ArrayList<String> labels = new ArrayList<String>();

        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");


        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData data = new BarData(dataSet);

        chart.setData(data);
        return v;
    }
}


