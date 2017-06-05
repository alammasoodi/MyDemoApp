package com.example.aalam.dashboardapp;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aalam on 29/5/17.
 */

public class CustomGridAdapter extends BaseAdapter {
    private Context mContext;
    List<GridItems> mGridItemsList;
    int selectedIndex;
    Button validateButton;
    String value="";
    int n = 0;
    public ArrayList<Integer> selectedIds = new ArrayList<Integer>();

    public CustomGridAdapter(Context c,List<GridItems> itemsList,Button val ) {
        mContext = c;
        mGridItemsList = itemsList;
        selectedIndex = -1;
        validateButton = val;
    }


    @Override
    public int getCount() {
        return mGridItemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }
    public void setSelectedIndex(int ind) {
        selectedIndex = ind;
        notifyDataSetChanged();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }



    public class ViewHolder {
        TextView tLabel,tID;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
         View grid = convertView;

        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        holder = new ViewHolder();
        if (convertView == null) {
            grid = inflater.inflate(R.layout.custom_grid_list_layout, null);
           // grid = LayoutInflater.from(mContext).inflate(R.layout.listitem_layout, null);
            holder.tLabel = (TextView) grid.findViewById(R.id.grid_text);
            holder.img = (ImageView) grid.findViewById(R.id.grid_image);
            holder.tID = (TextView)grid.findViewById(R.id.gridItem_id);



            grid.setTag(holder);

        } else {

            holder = (ViewHolder) grid.getTag();
        }
           holder.tLabel.setText(mGridItemsList.get(position).getLabel());
           holder.img.setImageResource(mGridItemsList.get(position).getImgRes());


        if (selectedIndex != -1 && position == selectedIndex) {
         //  n =  mGridItemsList.get(position).getImgId();
         value = String.valueOf(mGridItemsList.get(position).getImgId());

            grid.setBackgroundColor(Color.RED);

        }
        else
        {
//            holder.tID.setText("");

            grid.setBackgroundColor(Color.TRANSPARENT);

        }
        grid.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setSelectedIndex(position);

            }
        });
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value==""){
                  Toast t =  Toast.makeText(mContext,"plz select",Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER,0,0);
                    t.show();
                }
                else{
                    Toast t =     Toast.makeText(mContext,"You have clicked icon"+value,Toast.LENGTH_SHORT);
                t.setGravity(Gravity.CENTER,0,0);
                t.show();

            }}
        });
        return grid;
}}
