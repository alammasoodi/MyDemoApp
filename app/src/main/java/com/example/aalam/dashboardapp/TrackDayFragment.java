package com.example.aalam.dashboardapp;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by aalam on 2/5/17.
 */

public class TrackDayFragment extends Fragment {
    Button bDay;
    View v;
    int dayPos;
    TextView setDay;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){

        v = inflater.inflate(R.layout.trackday_fragment_layout,container,false);
        bDay = (Button)v.findViewById(R.id.trackDay);
        SharedPreferences getDay = getActivity().getSharedPreferences("StoreDayStatus", MODE_PRIVATE);
        SharedPreferences getDayPos = getActivity().getSharedPreferences("StoreDayStatus", MODE_PRIVATE);
        SharedPreferences.Editor editor = getActivity().getSharedPreferences("StorePos", MODE_PRIVATE).edit();
        dayPos = getDayPos.getInt("Dayloc",0);
        editor.putInt("retDayPos",dayPos);
        editor.commit();
        String day = getDay.getString("DayStatus",null);
        setDay = (TextView)v.findViewById(R.id.setDayStatus);
        setDay.setText(day);
        bDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),TrackDayActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }
}
