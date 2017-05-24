package com.example.aalam.dashboardapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


import static android.content.Context.MODE_PRIVATE;

/**
 * Created by aalam on 18/5/17.
 */

public class SurveyFragment2 extends Fragment {
    View v;
    ListView surveyLIST2;
    Button newButton2;
    int QNo, Qn;
    boolean flag2 = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();

        SharedPreferences getQues = getActivity().getSharedPreferences("SurveyQues1", MODE_PRIVATE);
        QNo = getQues.getInt("pos", 0);
        v = inflater.inflate(R.layout.surveyfragment2_layout, container, false);
        newButton2 = (Button) v.findViewById(R.id.newFragmentButton2);
        String[] values = new String[]{"Yes",
                "No"};
        int[] prgmImages = {R.drawable.blackmore, R.drawable.blackmore};
        surveyLIST2 = (ListView) v.findViewById(R.id.surveyFragmentList2);
        surveyLIST2.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        final MyCustomAdapter2 adapter = new MyCustomAdapter2(getActivity(), values, prgmImages, QNo, newButton2);
        surveyLIST2.setAdapter(adapter);
        if (flag2 == false)
            newButton2.setVisibility(View.INVISIBLE);
//
        surveyLIST2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

//            public void setItemSelected(View view) {
//                View rowView = view;
//                TextView tv = (TextView) rowView.findViewById(android.R.id.text1);
//                tv.setTextColor(Color.RED);
//            }
//
//            public void setItemNormal() {
//                for (int i = 0; i < adapter.getCount(); i++) {
//                    View v = surveyLIST2.getChildAt(i);
//                    TextView txtview = ((TextView) v.findViewById(android.R.id.text1));
//                    txtview.setTextColor(Color.BLACK);
//                }
//            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                flag2 = true;
                adapter.setSelectedIndex(position);
            }
        });


        return v;
    }


}
