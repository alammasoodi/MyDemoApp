package com.example.aalam.dashboardapp;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TrackDayActivity extends AppCompatActivity {
    ListView listView;
    String dayStatus;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_day);
        final FragmentManager fragmentManager = getFragmentManager();

        listView = (ListView)findViewById(R.id.list);
        String[] values = new String[] { "Boring",
                "Exciting",
                "Great",
                "Energetic",
                "Not Good"
        };
        SharedPreferences getPos = getSharedPreferences("StorePos",MODE_PRIVATE);
        pos = getPos.getInt("retDayPos",0);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,android.R.id.text1,values);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);
        listView.setSelection(pos);
        listView.setItemChecked(pos,true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                dayStatus = (String) listView.getItemAtPosition(position);
                                                SharedPreferences.Editor editor = getSharedPreferences("StoreDayStatus", MODE_PRIVATE).edit();
                                                editor.putString("DayStatus", dayStatus);
                                                editor.putInt("Dayloc",position);
                                                editor.commit();


                                                Intent intent = new Intent(TrackDayActivity.this,DashboardActivity.class);
                                                startActivity(intent);

                                            }
                                        }

        );
    }
    }

