package com.example.aalam.dashboardapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;
import static java.security.AccessController.getContext;

/**
 * Created by aalam on 17/5/17.
 */

public class MyCustomAdapter2 extends BaseAdapter {
    String[] survey2Questions;
    Context context;
    int[] imageId;
    int selectedIndex, getQues;
    Button newButton2;
    boolean alternateColor = true, moveToNext;
    int quesNoFromListClick, quesNoFromButton, send, option;

    public MyCustomAdapter2(Context surveyActivity2, String[] prgmNameList, int[] prgmImages, int Qno, Button b1) {

        survey2Questions = prgmNameList;
        context = surveyActivity2;
        imageId = prgmImages;
        selectedIndex = -1;
        newButton2 = b1;
        getQues = Qno;
        moveToNext = true;
        SharedPreferences.Editor editor = context.getSharedPreferences("SurveyQues1", MODE_PRIVATE).edit();
        SharedPreferences getPos = context.getSharedPreferences("SurveyQues1", MODE_PRIVATE);
        SharedPreferences getPos1 = context.getSharedPreferences("SurveyQues", MODE_PRIVATE);
        editor.putInt("setQues", getQues);
        editor.commit();
        quesNoFromListClick = getPos.getInt("pos", 0);
        send = getPos1.getInt("send", 0);
        quesNoFromButton = getPos1.getInt("pos", 0);
        if (send == 0) {
            option = quesNoFromListClick;
        } else {
            option = quesNoFromButton;
        }


    }

    public void setSelectedIndex(int ind) {
        selectedIndex = ind;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return survey2Questions.length;
    }

    @Override
    public Object getItem(int position) {
        return survey2Questions[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;
        MyCustomAdapter2.ViewHolder holder;

        if (convertView == null) {
            v = LayoutInflater.from(context).inflate(R.layout.listitem2_layout, null);
            v.setMinimumHeight(150);
            holder = new MyCustomAdapter2.ViewHolder();
            holder.tv = (TextView) v.findViewById(R.id.customTextView2);
            holder.img = (ImageView) v.findViewById(R.id.customImageView2);
            v.setTag(holder);
        } else {
            holder = (MyCustomAdapter2.ViewHolder) v.getTag();
        }
        if (selectedIndex != -1 && position == selectedIndex) {
            holder.tv.setTextColor(Color.parseColor("#C6545E"));
            holder.img.setImageResource(R.drawable.redmore);
        } else {
            holder.tv.setTextColor(Color.BLACK);
            if (alternateColor == true)
                holder.img.setImageResource(R.drawable.blackmore);
            else
                holder.img.setImageResource(R.drawable.transparent);
        }
        holder.tv.setText(survey2Questions[position]);
        holder.tv.setTextSize(18);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent;
                newButton2.postDelayed(new Runnable() {
                    public void run() {
                        newButton2.setVisibility(View.VISIBLE);
                    }
                }, 250);
                MyCustomAdapter2.ViewHolder holder1 = new MyCustomAdapter2.ViewHolder();
                holder1.tv = (TextView) v.findViewById(R.id.customTextView2);
                holder1.img = (ImageView) v.findViewById(R.id.customImageView2);
                if (moveToNext == true) {
                    if (position == 0) {
                        if (option == 0) {
                            myIntent = new Intent(context, EligibleActivity.class);
                            holder1.tv.setTextColor(Color.parseColor("#C6545E"));
                            holder1.img.setImageResource(R.drawable.redmore);
                            moveToNext = false;
                            alternateColor = false;
                            context.startActivity(myIntent);
                        } else {
                            myIntent = new Intent(context, InEligibleActivity.class);
                            holder1.tv.setTextColor(Color.parseColor("#C6545E"));
                            holder1.img.setImageResource(R.drawable.redmore);
                            moveToNext = false;
                            alternateColor = false;
                            context.startActivity(myIntent);
                        }
                    } else if (position == 1) {
                        if (option == 0) {
                            myIntent = new Intent(context, ControlActivity.class);
                            holder1.tv.setTextColor(Color.parseColor("#C6545E"));
                            holder1.img.setImageResource(R.drawable.redmore);
                            moveToNext = false;
                            alternateColor = false;
                            context.startActivity(myIntent);
                        } else {

                            myIntent = new Intent(context, InEligibleActivity.class);
                            holder1.tv.setTextColor(Color.parseColor("#C6545E"));
                            holder1.img.setImageResource(R.drawable.redmore);
                            moveToNext = false;
                            alternateColor = false;
                            context.startActivity(myIntent);

                        }

                    }

                } else {
                    setSelectedIndex(position);
                }
                newButton2.setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View v) {

                        Intent myIntent;
                        if (position == 0) {
                            myIntent = new Intent(context, EligibleActivity.class);
                            context.startActivity(myIntent);

                        } else {
                            myIntent = new Intent(context, InEligibleActivity.class);
                            context.startActivity(myIntent);
                        }
                    }
                });
            }
        });


        return v;
    }


}


