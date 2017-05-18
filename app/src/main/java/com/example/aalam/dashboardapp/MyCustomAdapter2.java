package com.example.aalam.dashboardapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by aalam on 17/5/17.
 */

public class MyCustomAdapter2 extends BaseAdapter {
    String[] result;
    Context context;
    int[] imageId;
    int selectedIndex,getQues;
    boolean f = true;

    public MyCustomAdapter2(Context surveyActivity2, String[] prgmNameList, int[] prgmImages,int Qno) {

        result = prgmNameList;
        context = surveyActivity2;
        imageId = prgmImages;
        selectedIndex = -1;
        getQues = Qno;




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
        MyCustomAdapter2.ViewHolder holder;

        if (convertView == null) {
            v = LayoutInflater.from(context).inflate(R.layout.listitem2_layout, null);
            v.setMinimumHeight(150);
            holder = new MyCustomAdapter2.ViewHolder();
            holder.tv = (TextView) v.findViewById(R.id.customTextView2);
            holder.img = (ImageView)v.findViewById(R.id.customImageView2);
            v.setTag(holder);
        } else {
            holder = (MyCustomAdapter2.ViewHolder) v.getTag();
        }
        if (selectedIndex != -1 && position == selectedIndex) {
            holder.tv.setTextColor(Color.parseColor("#C6545E"));
            holder.img.setImageResource(R.drawable.redmore);
        } else {
            holder.tv.setTextColor(Color.BLACK);
            if(f == true)
            holder.img.setImageResource(R.drawable.blackmore);
            else
                holder.img.setImageResource(R.drawable.transparent);
        }
        holder.tv.setText(result[position]);
        holder.tv.setTextSize(18);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectedIndex(position);
                Intent myIntent;
                MyCustomAdapter2.ViewHolder holder1 = new MyCustomAdapter2.ViewHolder();
                holder1.tv = (TextView) v.findViewById(R.id.customTextView2);
                holder1.img = (ImageView) v.findViewById(R.id.customImageView2);
                if (position == 0) {
                    if(getQues == 0) {
                        myIntent = new Intent(context, EligibleActivity.class);
                        holder1.tv.setTextColor(Color.parseColor("#C6545E"));
                        holder1.img.setImageResource(R.drawable.redmore);
                        f = false;
                        context.startActivity(myIntent);
                    }else{
                        myIntent = new Intent(context, InEligibleActivity.class);
                        holder1.tv.setTextColor(Color.parseColor("#C6545E"));
                        holder1.img.setImageResource(R.drawable.redmore);
                        f = false;
                        context.startActivity(myIntent);
                    }
                    } else if (position == 1) {
                    if(getQues == 0){
                        myIntent = new Intent(context,ControlActivity.class);
                        holder1.tv.setTextColor(Color.parseColor("#C6545E"));
                        holder1.img.setImageResource(R.drawable.redmore);
                        f = false;
                        context.startActivity(myIntent);
                    }
                    else
                    {
                        myIntent = new Intent(context,InEligibleActivity.class);
                        holder1.tv.setTextColor(Color.parseColor("#C6545E"));
                        holder1.img.setImageResource(R.drawable.redmore);
                        f = false;
                        context.startActivity(myIntent);

                    }
                    }

            }});



        return v;
    }




}


