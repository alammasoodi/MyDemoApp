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
import android.widget.ImageView;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by aalam on 28/4/17.
 */

public class Track extends Fragment {
    View v;
    TextView setMood;
    int dayPos, pos;
    Button bday, bMood,bChange;
    ImageView image,image2,image3;
    boolean flag = true,flag2 = true,flag3 = true;

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
        image = (ImageView) v.findViewById(R.id.imageView);
        image2 = (ImageView) v.findViewById(R.id.redImage);
        image3 = (ImageView) v.findViewById(R.id.greenImage);
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
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    image.setImageResource(R.drawable.happy);
                    flag = false;
                } else {
                    image.setImageResource(R.drawable.sad);
                    flag = true;
                }
                return;
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag2){
                    image2.setImageResource(R.drawable.redfilled);
                    image3.setImageResource(R.drawable.greenfilled);
                    flag2 = false;
                }
                else
                {
                    image2.setImageResource(R.drawable.greenfilled);
                    image3.setImageResource(R.drawable.redfilled);
                    flag2 =true;
                }
            }
        });


        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag3){
                    image3.setImageResource(R.drawable.redfilled);
                    image2.setImageResource(R.drawable.greenfilled);
                    flag3 = false;
                }
                else
                {
                    image3.setImageResource(R.drawable.greenfilled);
                    image2.setImageResource(R.drawable.redfilled);
                    flag3 =true;
                }
            }
        });
        return v;
    }




}

