package com.example.aalam.dashboardapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by aalam on 30/4/17.
 */

public class GenderFragment extends Fragment {
    View v;
    Button genderEdit;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){

        v = inflater.inflate(R.layout.gender_fragment_layout,container,false);
        genderEdit = (Button) v.findViewById(R.id.genderEdit);
        genderEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),EditGenderActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }
}
