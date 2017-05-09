package com.example.aalam.dashboardapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class EditWeightActivity extends AppCompatActivity {
    Button bChange;
    EditText eWeight;
    String wt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_weight);
        bChange = (Button)findViewById(R.id.bWeight);
        eWeight = (EditText)findViewById(R.id.weightChange);

        RadioGroup radio_select = (RadioGroup) findViewById(R.id.rg1);
        final SharedPreferences.Editor editor1 = getSharedPreferences("StoreWeightScale", MODE_PRIVATE).edit();

        radio_select.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                switch (checkedId) {
                    case R.id.kg:{
                        String kg = "Kg";
                        editor1.putString("weightScale", kg);
                        editor1.commit();
                        break;}
                    case R.id.pound:{
                        String pound = "Pounds";
                        editor1.putString("weightScale", pound);
                        editor1.commit();
                        break;
                    }
                }
            }
        });
        bChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wt = eWeight.getText().toString();
               final SharedPreferences.Editor editor = getSharedPreferences("StoreWeight", MODE_PRIVATE).edit();
                editor.putString("weight", wt);
                editor.commit();

                Intent intent = new Intent(EditWeightActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
