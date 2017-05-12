package com.example.aalam.dashboardapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class DashboardActivity extends AppCompatActivity {
    Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        final FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.frame_layout,new Profile()).commit();
        RadioGroup radio_select = (RadioGroup) findViewById(R.id.radioGroup);
        radio_select.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                switch (checkedId) {
                    case R.id.user:
                        mFragment = new Profile();
                        break;
                    case R.id.review:
                        mFragment = new Review();
                        break;
                    case R.id.mood:
                        mFragment = new Track();
                        break;
                    case R.id.chart:
                        mFragment = new Insight();
                        break;
                    case R.id.calender:
                        mFragment = new Citizen();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.frame_layout,mFragment).commit();




            }
        });



    }


}
