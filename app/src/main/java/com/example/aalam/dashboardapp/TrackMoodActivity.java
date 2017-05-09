package com.example.aalam.dashboardapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class TrackMoodActivity extends AppCompatActivity {
    ListView listView;
    String moodStatus;
    int pos;
    Button getChoice, clearAll;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyUserChoice" ;
    ArrayList<String> selectedItems = new ArrayList<String>();
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
        getChoice = (Button) findViewById(R.id.getchoice);
        clearAll = (Button) findViewById(R.id.clearall);
//        SharedPreferences getPos = getSharedPreferences("StorePos", MODE_PRIVATE);
//        pos = getPos.getInt("retPos", 0);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, android.R.id.text1, values);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if (sharedpreferences.contains(MyPREFERENCES)) {
            LoadSelections();

        }
        getChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selected = "";
                int cntChoice = listView.getCount();
                SparseBooleanArray sparseBooleanArray = listView.getCheckedItemPositions();
                for (int i = 0; i < cntChoice; i++) {
                    if (sparseBooleanArray.get(i)) {

                        selected += listView.getItemAtPosition(i).toString() + "\n";
                        SaveSelections();
                    }
                }
            }
        });


        clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClearSelections();
            }
        });
    }

        private void SaveSelections(){

        SharedPreferences.Editor prefEditor = sharedpreferences.edit();
        String savedItems = getSavedItems();
        prefEditor.putString(MyPREFERENCES.toString(),savedItems);
        prefEditor.commit();
            finish();
    }

    private String getSavedItems(){

        String savedItems="";
        int count = this.listView.getAdapter().getCount();
        for(int i=0;i<count;i++){
            if(this.listView.isItemChecked(i)){
                if(savedItems.length()>0){
                    savedItems+=","+this.listView.getItemAtPosition(i);
                }
                else{
                    savedItems+=this.listView.getItemAtPosition(i);
                }
            }
        }
        return savedItems;
    }
        private void LoadSelections(){
            if(sharedpreferences.contains(MyPREFERENCES.toString())){
                String savedItems = sharedpreferences.getString(MyPREFERENCES.toString(),"");
                selectedItems.addAll(Arrays.asList(savedItems.split(",")));
                int count = this.listView.getAdapter().getCount();
            for(int i=0;i<count;i++){
                String currentItem = (String)listView.getAdapter().getItem(i);
                if(selectedItems.contains(currentItem)){
                    listView.setItemChecked(i,true);
                }
                else {
                    listView.setItemChecked(i,false);
                }
            }
            }
        }
        private void ClearSelections(){
            int count = this.listView.getAdapter().getCount();
            for(int i = 0; i<count;i++){
                this.listView.setItemChecked(i,false);
            }
            SaveSelections();
        }}
//
//        listView.setSelection(pos);
//        listView.setItemChecked(pos, true);
//
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//
////                                                CheckedTextView textView = (CheckedTextView)view;
////                                                textView.setChecked(!textView.isChecked());
//                                                moodStatus = (String) listView.getItemAtPosition(position);
//
//                                                SharedPreferences.Editor editor = getSharedPreferences("StoreMoodStatus", MODE_PRIVATE).edit();
//                                                editor.putString("MoodStatus", moodStatus);
//                                                editor.putInt("Itemloc", position);
//                                                editor.commit();
//
////                                               fragmentManager.findFragmentById(R.layout.track_layout);
////                                               fragmentManager.beginTransaction().commit();
//                                                Intent intent = new Intent(TrackMoodActivity.this, DashboardActivity.class);
//                                                startActivity(intent);
//
//                                            }
//                                        }
//
//        );
//    }





