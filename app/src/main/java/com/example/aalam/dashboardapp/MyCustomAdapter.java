package com.example.aalam.dashboardapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by aalam on 17/5/17.
 */

public class MyCustomAdapter extends BaseAdapter {
    String[] result;
    Context context;
    int[] imageId;
    boolean getState, flag;
    int getPos;
    private LayoutInflater inflater;
    int selectedIndex;
    int selectedColor = Color.BLACK;
    SurveyFragment2 mFragment2;
    Button newButton;

    public MyCustomAdapter(Context surveyActivity, String[] prgmNameList, int[] prgmImages,SurveyFragment2 fragment2,Button b1) {

        result = prgmNameList;
        context = surveyActivity;
        imageId = prgmImages;
        selectedIndex = -1;
        mFragment2 = fragment2;
        newButton = b1;

        SharedPreferences getChecked = context.getSharedPreferences("StoreChecked", MODE_PRIVATE);
        getState = getChecked.getBoolean("checked", false);
       // getPos = getChecked.getInt("pos", 0);
        if (getState == true) {
            flag = true;
        }

    }

    public void setSelectedIndex(int ind) {
        selectedIndex = ind;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return result[position];
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
        ViewHolder holder;

        if (convertView == null) {
            v = LayoutInflater.from(context).inflate(R.layout.listitem_layout, null);
            v.setMinimumHeight(120);
            holder = new ViewHolder();
            holder.tv = (TextView) v.findViewById(R.id.customTextView);
            holder.img = (ImageView)v.findViewById(R.id.customImageView);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        if (selectedIndex != -1 && position == selectedIndex) {
            holder.tv.setTextColor(Color.parseColor("#C6545E"));
            holder.img.setImageResource(R.drawable.redmore);
        } else {
            holder.tv.setTextColor(Color.BLACK);
            if (flag == true)
                holder.img.setImageResource(R.drawable.blackmore);
            else
                holder.img.setImageResource(R.drawable.transparent);
        }
        holder.tv.setText(result[position]);

        holder.tv.setTextSize(18);
     final SharedPreferences.Editor editor = context.getSharedPreferences("SurveyQues1", MODE_PRIVATE).edit();
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = ((Activity)context).getFragmentManager();
                FragmentTransaction fragmentTransaction =  fm.beginTransaction();
                newButton.setVisibility(View.VISIBLE);
                Intent myIntent;
                if (flag == true) {
                    ViewHolder holder1 = new ViewHolder();
                    if (position == 0) {
                       // myIntent = new Intent(context, SurveyActivity2.class);
                        editor.putInt("pos", 0);

                        holder1.tv = (TextView) v.findViewById(R.id.customTextView);
                        holder1.img = (ImageView)v.findViewById(R.id.customImageView);
                        holder1.tv.setTextColor(Color.parseColor("#C6545E"));
                        holder1.img.setImageResource(R.drawable.redmore);
                        flag = false;
                        editor.commit();
                        fragmentTransaction.add(R.id.frame_layout2, mFragment2).addToBackStack(null);
                        fragmentTransaction.commit();
                        //context.startActivity(myIntent);

                    } else if (position == 1) {
                        //myIntent = new Intent(context, SurveyActivity2.class);
                        editor.putInt("pos", 1);
                        holder1.tv = (TextView) v.findViewById(R.id.customTextView);
                        holder1.img = (ImageView)v.findViewById(R.id.customImageView);
                        holder1.tv.setTextColor(Color.parseColor("#C6545E"));
                        holder1.img.setImageResource(R.drawable.redmore);

                        flag = false;
                        editor.commit();
                        fragmentTransaction.add(R.id.frame_layout2, mFragment2).addToBackStack(null);
                        fragmentTransaction.commit();
                    //    context.startActivity(myIntent);
                    }

                }else {

                    setSelectedIndex(position);
                }
            }});



        return v;
    }




    }



