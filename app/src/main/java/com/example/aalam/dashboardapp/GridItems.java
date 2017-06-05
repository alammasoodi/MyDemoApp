package com.example.aalam.dashboardapp;

/**
 * Created by aalam on 29/5/17.
 */

public class GridItems {
    String label;
    int imgRes,imgId;

    public GridItems(String label,int imgRes,int imgId){
        this.label = label;
        this.imgId = imgId;
        this.imgRes = imgRes;

    }
    public String getLabel(){
        return label;
    }
    public int getImgRes(){
        return imgRes;
    }
    public int getImgId(){
        return imgId;
    }
}
