package com.example.aalam.dashboardapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;
import static android.graphics.Color.BLACK;

/**
 * Created by aalam on 15/5/17.
 */

class EfficientAdapter extends ArrayAdapter {

    private LayoutInflater mInflater;

    private String[] mStrings;

    public Context context;

    private int mViewResourceId;

    public boolean[] checked;
    boolean getState, flag;
    int getPos;
    public int count;

    public EfficientAdapter(Context ctx, int viewResourceId, String[] strings) {
        super(ctx, viewResourceId, strings);

        mInflater = (LayoutInflater) ctx.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        mStrings = strings;

        context = ctx;

        mViewResourceId = viewResourceId;

        checked = new boolean[strings.length];
        SharedPreferences getChecked = context.getSharedPreferences("StoreChecked", MODE_PRIVATE);
        getState = getChecked.getBoolean("checked", false);
        getPos = getChecked.getInt("pos",0);
        count = getPos;
    }

    @Override
    public int getCount() {
        return mStrings.length;
    }

    @Override
    public String getItem(int position) {
        return mStrings[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = mInflater.inflate(mViewResourceId, null);
        if (getState == true) {
            flag = true;
        }

        final int pos = position;
        convertView.setMinimumHeight(150);
        final TextView tv = (TextView) convertView.findViewById(R.id.textList);
        tv.setText(mStrings[position]);
        tv.setTextColor(BLACK);
        final CheckBox cBox = (CheckBox) convertView.findViewById(R.id.checkBox1);
        cBox.setTag(Integer.valueOf(position));

       // cBox.setChecked(checked[position]);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == true) {
                    if (pos == 0) {
                        Intent intent = new Intent(context, ForwardActivity1.class);
                        context.startActivity(intent);
                        tv.setTextColor(Color.RED);
                        cBox.setChecked(true);
                        flag = false;

                    } else if (pos == 1) {
                        Intent intent = new Intent(context, ForwardActivity2.class);
                        context.startActivity(intent);
                        flag = false;
                        cBox.setChecked(true);
                        tv.setTextColor(Color.RED);

                    }
                    }


                }
        });

        return convertView;

    }

}


