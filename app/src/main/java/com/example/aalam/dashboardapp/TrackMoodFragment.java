package com.example.aalam.dashboardapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by aalam on 2/5/17.
 */

public class TrackMoodFragment extends Fragment {
    Button bMood;
    View v;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.trackmood_fragment_layout, container, false);
        bMood = (Button) v.findViewById(R.id.trackMood);

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
