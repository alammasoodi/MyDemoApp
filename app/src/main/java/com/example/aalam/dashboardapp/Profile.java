package com.example.aalam.dashboardapp;

import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by aalam on 28/4/17.
 */

public class Profile extends Fragment {
    TextView setName,setGender,setWeight;
    View v;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        SharedPreferences getName = getActivity().getSharedPreferences("StoreName", Context.MODE_PRIVATE);
        SharedPreferences getGender = getActivity().getSharedPreferences("StoreGender", Context.MODE_PRIVATE);
        SharedPreferences getWeight = getActivity().getSharedPreferences("StoreWeight", Context.MODE_PRIVATE);
        v = inflater.inflate(R.layout.profile_layout,container,false);
        setName = (TextView)v.findViewById(R.id.setNameView);
        setGender = (TextView)v.findViewById(R.id.setGenderView);
        setWeight = (TextView)v.findViewById(R.id.setWeightView);
        String name = getName.getString("name",null);
        String gender = getGender.getString("gender",null);
        String weight = getWeight.getString("weight",null);
        setName.setText(name);
        setGender.setText(gender);
        setWeight.setText(weight);
        return v;
    }
}
