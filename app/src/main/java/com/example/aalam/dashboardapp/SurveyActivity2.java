package com.example.aalam.dashboardapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class SurveyActivity2 extends AppCompatActivity {
    ListView surveyLIST2;
    int getQues;
    int QNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey2);
        Intent intent = getIntent();
        QNo = intent.getIntExtra("quesNo",0);
        surveyLIST2 = (ListView) findViewById(R.id.surveyList2);
        CalligraphyConfig.initDefault(
                new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/HelveticaNeueThin.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build());
        String[] values = new String[]{"Yes",
                "No"};
        int[] prgmImages = {R.drawable.blackmore, R.drawable.blackmore};
        surveyLIST2.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        final MyCustomAdapter2 adapter = new MyCustomAdapter2(SurveyActivity2.this, values, prgmImages,QNo);
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

    }}


//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
//    }

