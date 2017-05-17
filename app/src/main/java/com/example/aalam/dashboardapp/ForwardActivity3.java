package com.example.aalam.dashboardapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ForwardActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forward3);
        Toast.makeText(ForwardActivity3.this,"Welcome",Toast.LENGTH_SHORT).show();
    }

}
