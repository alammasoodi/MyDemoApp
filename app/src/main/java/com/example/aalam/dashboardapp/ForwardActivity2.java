package com.example.aalam.dashboardapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ForwardActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forward2);
        SharedPreferences.Editor editor = getSharedPreferences("StoreChecked", MODE_PRIVATE).edit();
        editor.putBoolean("checked", true);
        editor.putInt("pos",1);
        editor.commit();
    }
}
