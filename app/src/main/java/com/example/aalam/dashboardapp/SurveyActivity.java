package com.example.aalam.dashboardapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SurveyActivity extends AppCompatActivity {
    ListView surveyLIST;
    int selectedItem = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        surveyLIST = (ListView) findViewById(R.id.surveyList);
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
        surveyLIST.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent myIntent;
                        if (selectedItem == -1 || selectedItem != position)
                        {


                        if (position == 0) {

                            myIntent = new Intent(SurveyActivity.this, ForwardActivity1.class);
                            selectedItem = position;
                            startActivity(myIntent);
                        } else if (position == 1) {
                            myIntent = new Intent(SurveyActivity.this, ForwardActivity2.class);
                            selectedItem = position;
                            startActivity(myIntent);
                        }}
                        else
                        {

                         {
                             System.out.print("position is %d"+selectedItem);
                         }
                        }



                    }


                });
    }




    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
