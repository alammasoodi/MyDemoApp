package com.example.aalam.dashboardapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by aalam on 18/5/17.
 */

public class SurveyFragment1 extends Fragment {
    View v;
    boolean getState;
    ListView surveyLIST;
    Button newButton;
    int getPos;
    boolean nextButtonVisible = false;
    int p;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.surveyfragment1_layout, container, false);
        surveyLIST = (ListView) v.findViewById(R.id.surveyFragmentList);
        newButton = (Button) v.findViewById(R.id.newFragmentButton);


        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/HelveticaNeueThin.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
        String[] values = new String[]{"Yes, I have had a menstrual period",
                "No, I have not started menstruating"};
        int[] prgmImages = {R.drawable.blackmore, R.drawable.blackmore};

        surveyLIST.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        SurveyFragment2 fragment2 = new SurveyFragment2();
        final MyCustomAdapter adapter = new MyCustomAdapter(getActivity(), values, prgmImages, fragment2, newButton);
        surveyLIST.setAdapter(adapter);
        SharedPreferences getChecked = getActivity().getSharedPreferences("StoreChecked", MODE_PRIVATE);
        getState = getChecked.getBoolean("checked", false);
        getPos = getChecked.getInt("pos", 0);
        if (nextButtonVisible == false)
            newButton.setVisibility(View.INVISIBLE);


        surveyLIST.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        nextButtonVisible = true;

                        adapter.setSelectedIndex(position);

                    }


                });


        return v;
    }


}
