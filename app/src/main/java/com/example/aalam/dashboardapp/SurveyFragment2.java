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
import android.widget.ListView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by aalam on 18/5/17.
 */

public class SurveyFragment2 extends Fragment{
    View v;
    ListView surveyLIST2;
    int QNo,Qn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        QNo = intent.getIntExtra("quesNo",0);
        Qn = intent.getIntExtra("nextButtonValue",0);
        SharedPreferences getQues = getActivity().getSharedPreferences("SurveyQues1", MODE_PRIVATE);
        QNo = getQues.getInt("pos", 0);
        v = inflater.inflate(R.layout.surveyfragment2_layout, container, false);
        String[] values = new String[]{"Yes",
                "No"};
        int[] prgmImages = {R.drawable.blackmore, R.drawable.blackmore};
        surveyLIST2 = (ListView)v. findViewById(R.id.surveyFragmentList2);
        surveyLIST2.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        final MyCustomAdapter2 adapter = new MyCustomAdapter2(getActivity(), values, prgmImages,QNo);
        surveyLIST2.setAdapter(adapter);
//        SharedPreferences getQuest = getSharedPreferences("SurveyQues1", MODE_PRIVATE);
//        getQues = getQuest.getInt("ques", 0);
//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values) {
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                View view = super.getView(position, convertView, parent);
//                TextView tv = (TextView) view.findViewById(android.R.id.text1);
//                tv.setTextColor(Color.BLACK);
//                return view;
//            }
//        };
        // final  int pos = getIntent().getIntExtra("nextButtonValue",0);

//        surveyLIST2.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
//        surveyLIST2.setAdapter(adapter);
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
//                setItemNormal();
//                View rowView = view;
//                setItemSelected(rowView);
//                if (position == 0) {
//                    if (getQues == 0) {
//                        Intent myIntent = new Intent(SurveyActivity2.this, EligibleActivity.class);
//                        startActivity(myIntent);
//                    } else {
//                        Intent myIntent = new Intent(SurveyActivity2.this, InEligibleActivity.class);
//                        startActivity(myIntent);
//                    }
//
//                } else if (position == 1) {
//                    if (getQues == 0) {
//                        Intent myIntent = new Intent(SurveyActivity2.this, ControlActivity.class);
//                        startActivity(myIntent);
//                    } else {
//                        Intent myIntent = new Intent(SurveyActivity2.this, InEligibleActivity.class);
//                        startActivity(myIntent);
//                    }
//                }
//            }
//        });
                adapter.setSelectedIndex(position);
            }
        });



        return v;
    }




}
