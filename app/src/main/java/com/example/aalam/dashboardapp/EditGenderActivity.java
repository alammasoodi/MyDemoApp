package com.example.aalam.dashboardapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class EditGenderActivity extends AppCompatActivity {
    Button genderChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_gender);
        genderChange = (Button)findViewById(R.id.genderChange);
        RadioGroup radio_select = (RadioGroup) findViewById(R.id.rg);
        final SharedPreferences.Editor editor = getSharedPreferences("StoreGender", MODE_PRIVATE).edit();

        radio_select.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                                                    @Override
                                                    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                                                        switch (checkedId) {
                                                            case R.id.male:{
                                                                String male = "male";
                                                                editor.putString("gender", male);
                                                                editor.commit();
                                                                break;}
                                                            case R.id.female:{
                                                                String female = "female";
                                                                editor.putString("gender", female);
                                                                editor.commit();
                                                                break;
                                                        }
                                                        }
                                                    }
                                                });
                genderChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent intent = new Intent(EditGenderActivity.this, DashboardActivity.class);
                        startActivity(intent);
                    }
                });
            }

    }




