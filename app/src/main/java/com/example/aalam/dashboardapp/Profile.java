package com.example.aalam.dashboardapp;

import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
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
 * Created by aalam on 28/4/17.
 */

public class Profile extends Fragment {
    TextView setName, setGender, setWeight,setRace,setHeight, nameEdit, genderEdit, bWeight,bRace,bHeight;
    View v;
    Button nu,sur;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SharedPreferences getName = getActivity().getSharedPreferences("StoreName", Context.MODE_PRIVATE);
        SharedPreferences getGender = getActivity().getSharedPreferences("StoreGender", Context.MODE_PRIVATE);
        SharedPreferences getWeight = getActivity().getSharedPreferences("StoreWeight", Context.MODE_PRIVATE);
        SharedPreferences getWeightScale = getActivity().getSharedPreferences("StoreWeightScale",Context.MODE_PRIVATE);
        v = inflater.inflate(R.layout.profile_layout, container, false);
        nameEdit = (TextView) v.findViewById(R.id.setNameView);
        nameEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), EditNameActivity.class);
                startActivity(intent);

            }
        });
        genderEdit = (TextView) v.findViewById(R.id.setGenderView);
        genderEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), EditGenderActivity.class);
                startActivity(intent);
            }
        });
        bWeight = (TextView) v.findViewById(R.id.setWeightView);
        bWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditWeightActivity.class);
                startActivity(intent);
            }
        });
        bRace = (TextView)v.findViewById(R.id.setEthnicity);
        bRace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditRaceActivity.class);
                startActivity(intent);
            }
        });
        bHeight = (TextView)v.findViewById(R.id.setHeightView);
        bHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditHeightActivity.class);
                startActivity(intent);
            }
        });
        nu = (Button)v.findViewById(R.id.nu);
        nu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlreadyRegisteredActivity.class);
                startActivity(intent);
            }
        });

        sur = (Button)v.findViewById(R.id.survey);
        sur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SurveyActivity.class);
                startActivity(intent);
            }
        });
        setName = (TextView) v.findViewById(R.id.setNameView);
        setGender = (TextView) v.findViewById(R.id.setGenderView);
        setWeight = (TextView) v.findViewById(R.id.setWeightView);
        setRace = (TextView)v.findViewById(R.id.setEthnicity);
        setHeight = (TextView)v.findViewById(R.id.setHeightView);
        String name = getName.getString("name", null);
        String gender = getGender.getString("gender", null);
        String weight = getWeight.getString("weight", null);
        String weightScale = getWeightScale.getString("weightScale",null);
        String w = ""+weight+" "+weightScale;
        setName.setText(name);
        setGender.setText(gender);
        setWeight.setText(w);
        return v;
    }
}
