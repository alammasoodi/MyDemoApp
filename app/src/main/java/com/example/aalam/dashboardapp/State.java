package com.example.aalam.dashboardapp;

/**
 * Created by aalam on 8/5/17.
 */

public final class State {
    static boolean somethingIsChecked = false;

    static boolean isSomethingChecked(){
        return somethingIsChecked;
    }

    static void setSomethingIsChecked(boolean isChecked){
        somethingIsChecked = isChecked;
    }
}
