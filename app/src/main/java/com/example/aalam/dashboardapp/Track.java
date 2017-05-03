package com.example.aalam.dashboardapp;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by aalam on 28/4/17.
 */

public class Track extends Fragment {
    View v;
    TextView setMood;
    int dayPos, pos;
    Button bday, bMood;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        SharedPreferences getMoodPos = getActivity().getSharedPreferences("StoreMoodStatus", MODE_PRIVATE);
        SharedPreferences getDayPos = getActivity().getSharedPreferences("StoreDayStatus", MODE_PRIVATE);
        SharedPreferences.Editor editor = getActivity().getSharedPreferences("StorePos", MODE_PRIVATE).edit();
        dayPos = getDayPos.getInt("Dayloc", 0);
        pos = getMoodPos.getInt("Itemloc", 0);
        editor.putInt("retDayPos", dayPos);
        editor.putInt("retPos", pos);
        editor.commit();

        v = inflater.inflate(R.layout.track_layout, container, false);
        bday = (Button) v.findViewById(R.id.trackDay);
        bMood = (Button) v.findViewById(R.id.trackMood);
        bday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), TrackDayActivity.class);
                startActivity(intent);
            }
        });
        bMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrackMoodActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}


