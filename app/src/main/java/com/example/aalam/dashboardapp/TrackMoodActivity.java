package com.example.aalam.dashboardapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

public class TrackMoodActivity extends AppCompatActivity {
    ListView listView;
    String moodStatus;
    int pos;
    View previouslySelectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_mood);
        listView = (ListView) findViewById(R.id.moodList);
        String[] values = new String[]{"Happy",
                "Excited",
                "Angry",
                "Anxious",
                "Sad"
        };
        SharedPreferences getPos = getSharedPreferences("StorePos", MODE_PRIVATE);
        pos = getPos.getInt("retPos", 0);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, android.R.id.text1, values);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);
        listView.setSelection(pos);
        listView.setItemChecked(pos, true);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


//                                                CheckedTextView textView = (CheckedTextView)view;
//                                                textView.setChecked(!textView.isChecked());
                                                moodStatus = (String) listView.getItemAtPosition(position);

                                                SharedPreferences.Editor editor = getSharedPreferences("StoreMoodStatus", MODE_PRIVATE).edit();
                                                editor.putString("MoodStatus", moodStatus);
                                                editor.putInt("Itemloc", position);
                                                editor.commit();

//                                               fragmentManager.findFragmentById(R.layout.track_layout);
//                                               fragmentManager.beginTransaction().commit();
                                                Intent intent = new Intent(TrackMoodActivity.this, DashboardActivity.class);
                                                startActivity(intent);

                                            }
                                        }

        );
    }
}



