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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SurveyActivity extends AppCompatActivity {
    ListView surveyLIST;
    boolean getState, flag, flag2;
    int getPos;
    Button newButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        surveyLIST = (ListView) findViewById(R.id.surveyList);
        newButton = (Button) findViewById(R.id.newButton);
        final SharedPreferences.Editor editor = getSharedPreferences("SurveyQues1", MODE_PRIVATE).edit();

        // nextButton = (Button) findViewById(R.id.nextButton);
        CalligraphyConfig.initDefault(
                new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/HelveticaNeueThin.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build());
        String[] values = new String[]{"jnj, I have had a menstrual period",
                "No, I have not started menstruating"};
        int[] prgmImages = {R.drawable.blackmore, R.drawable.blackmore};
//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values) {
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                View view = super.getView(position, convertView, parent);
//                TextView tv = (TextView) view.findViewById(android.R.id.text1);
//                tv.setTextColor(Color.BLACK);
//
//                return view;
//            }
//        };
//        surveyLIST.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
//        surveyLIST.setAdapter(adapter);
        surveyLIST.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
       // final MyCustomAdapter adapter = new MyCustomAdapter(SurveyActivity.this, values, prgmImages);
       // surveyLIST.setAdapter(adapter);
        SharedPreferences getChecked = getSharedPreferences("StoreChecked", MODE_PRIVATE);
        // getState = getChecked.getBoolean("checked", false);
        getPos = getChecked.getInt("pos", 0);
        flag2 = false;
        if (flag2 == false) {
            newButton.setVisibility(View.INVISIBLE);
        }


        surveyLIST.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    //                    public void setItemSelected(View view) {
//                        View rowView = view;
//                        TextView tv = (TextView) rowView.findViewById(android.R.id.text1);
//                        tv.setTextColor(Color.RED);
//                    }
//
//                    public void setItemNormal() {
//                        for (int i = 0; i < adapter.getCount(); i++) {
//                            View v = surveyLIST.getChildAt(i);
//                            TextView txtview = ((TextView) v.findViewById(android.R.id.text1));
//                            txtview.setTextColor(Color.BLACK);
//                        }
//                    }
//
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                       // adapter.setSelectedIndex(position);
                    }
                    // adapter.setSelectedItem(view);

// if (flag == true) {
//                            Intent myIntent;
//                            if (position == 0) {
//                                editor.putInt("ques", 0);
//                                editor.commit();
//                                TextView tv = (TextView) view.findViewById(android.R.id.text1);
//                                tv.setTextColor(Color.RED);
//                                myIntent = new Intent(SurveyActivity.this, SurveyActivity2.class);
//                                flag = false;
//
//                                startActivity(myIntent);
//                            } else if (position == 1) {
//                                TextView tv = (TextView) view.findViewById(android.R.id.text1);
//                                tv.setTextColor(Color.RED);
//                                editor.putInt("ques", 1);
//                                editor.commit();
//                                myIntent = new Intent(SurveyActivity.this, SurveyActivity2.class);
//                                flag = false;
//                                startActivity(myIntent);
//                            }
//                        } else {
//                            setItemNormal();
//                           View rowView = view;
//                            setItemSelected(rowView);
//
//
//                        }

                });

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("pos", surveyLIST.getCheckedItemPosition());
                editor.commit();
                Intent i = new Intent(SurveyActivity.this, SurveyActivity2.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        if (flag2 == true) {
            newButton.setVisibility(View.VISIBLE);
        }

    }


    @Override
    public void onPause() {
        super.onPause();
        flag2 = true;
    }
}

//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
//    }
//}
