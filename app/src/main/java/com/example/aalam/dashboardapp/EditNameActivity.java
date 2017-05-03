package com.example.aalam.dashboardapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditNameActivity extends AppCompatActivity {

    Button bChange;
    EditText eName;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name);
        eName = (EditText) findViewById(R.id.editName);
        bChange = (Button) findViewById(R.id.bChangeName);

        bChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = eName.getText().toString();
                SharedPreferences.Editor editor = getSharedPreferences("StoreName", MODE_PRIVATE).edit();
                editor.putString("name", name);
                editor.commit();

                Intent intent = new Intent(EditNameActivity.this,DashboardActivity.class);
                startActivity(intent);

                //Toast.makeText(EditNameActivity.this,"Name is "+name,Toast.LENGTH_SHORT).show();

            }
        });
    }
}
