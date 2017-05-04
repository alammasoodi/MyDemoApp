package com.example.aalam.dashboardapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by aalam on 4/5/17.
 */

public class TrackDayAdapter extends RecyclerView.Adapter<TrackDayAdapter.ViewHolder> {
    List<TrackDayQuestions> mDayQuestionsList;
    String[] ques;
    String[] ans;
    Context mContext;
    View mView;
    TrackDayAdapter.ViewHolder mViewHolder;

    public TrackDayAdapter(Context context,List<TrackDayQuestions> trackDayQuestionsList){
        mDayQuestionsList = trackDayQuestionsList;
        mContext = context;
    }



    @Override
    public TrackDayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.day_questions_layout,parent,false);
        mViewHolder = new ViewHolder(mView);
        return mViewHolder;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tQ;
        public TextView tA;
        public ImageView im;
        public ViewHolder(View itemView) {
            super(itemView);
            tQ = (TextView)itemView.findViewById(R.id.dayQuesText);
            tA = (TextView)itemView.findViewById(R.id.dayAnsText);
            im = (ImageView)itemView.findViewById(R.id.overflow);
            im.setVisibility(View.INVISIBLE);
        }


        @Override
        public void onClick(View v) {
        }
    }

    @Override
    public void onBindViewHolder(TrackDayAdapter.ViewHolder holder, int position) {

        holder.tQ.setText(mDayQuestionsList.get(position).getQuestion());
        holder.tA.setText(mDayQuestionsList.get(position).getAnswer());
    }

    @Override
    public int getItemCount() {
        return mDayQuestionsList.size();
    }



}

