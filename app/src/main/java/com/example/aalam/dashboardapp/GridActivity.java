package com.example.aalam.dashboardapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {
    List<GridItems> mGridItemsList = new ArrayList<>();
    GridView grid;
    String value;
    Button valButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        valButton = (Button)findViewById(R.id.validateButton);
        GridItems item1 = new GridItems("icon1",R.drawable.redfilled,1);
        mGridItemsList.add(item1);
        GridItems item2 = new GridItems("icon2",R.drawable.redfilled,2);
        mGridItemsList.add(item2);
        GridItems item3 = new GridItems("icon3",R.drawable.redfilled,3);
        mGridItemsList.add(item3);
        GridItems item4 = new GridItems("icon4",R.drawable.redfilled,4);
        mGridItemsList.add(item4);
        GridItems item5 = new GridItems("icon5",R.drawable.redfilled,5);
        mGridItemsList.add(item5);
        GridItems item6 = new GridItems("icon6",R.drawable.redfilled,6);
        mGridItemsList.add(item6);
        GridItems item7 = new GridItems("icon7",R.drawable.redfilled,7);
        mGridItemsList.add(item7);
       final CustomGridAdapter adapter = new CustomGridAdapter(GridActivity.this, mGridItemsList,valButton);
        grid=(GridView)findViewById(R.id.grid);
       grid.setChoiceMode(GridView.CHOICE_MODE_MULTIPLE_MODAL);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.setSelectedIndex(position);

            }
        });

    }
}
