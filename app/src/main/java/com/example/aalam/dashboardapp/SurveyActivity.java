package com.example.aalam.dashboardapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
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
        CalligraphyConfig.initDefault(
                new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/HelveticaNeueThin.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build());
        String[] values = new String[]{"Yes, I have had a menstrual period",
                "No, I have not started menstruating"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, android.R.id.text1, values);
        surveyLIST.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        surveyLIST.setAdapter(adapter);
        SharedPreferences getChecked = this.getSharedPreferences("StoreChecked", Context.MODE_PRIVATE);
        SharedPreferences getPosition = this.getSharedPreferences("StoreChecked", Context.MODE_PRIVATE);
        getState = getChecked.getBoolean("checked", false);
        getPos = getPosition.getInt("pos", -1);
        flag2 = false;
        if (flag2 == false) {
            newButton.setVisibility(View.INVISIBLE);
        }
        if (getState == true) {
            flag = true;
        }


        surveyLIST.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (flag == true) {
                            Intent myIntent;
                            if (position == 0) {
                                myIntent = new Intent(SurveyActivity.this, ForwardActivity1.class);
                                flag = false;

                                startActivity(myIntent);
                            } else if (position == 1) {
                                myIntent = new Intent(SurveyActivity.this, ForwardActivity2.class);
                                flag = false;
                                startActivity(myIntent);
                            }


                        }
                    }
                });
    }


    @Override
    public void onResume() {
        super.onResume();
        if (flag2 == true) {
            newButton.setVisibility(View.VISIBLE);
        }
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SurveyActivity.this, ForwardActivity3.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        flag2 = true;
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
