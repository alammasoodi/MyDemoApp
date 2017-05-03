package com.example.aalam.dashboardapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        bChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wt = eWeight.getText().toString();
                SharedPreferences.Editor editor = getSharedPreferences("StoreWeight", MODE_PRIVATE).edit();
                editor.putString("weight", wt);
                editor.commit();

                Intent intent = new Intent(EditWeightActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
