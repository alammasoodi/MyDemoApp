package com.example.aalam.dashboardapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OnBackActivity extends AppCompatActivity {
    protected OnBackActivity.OnBackPressedListener onBackPressedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_back);

    }
        public interface OnBackPressedListener {
            void doBack();
        }

    public void setOnBackPressedListener(OnBackActivity.OnBackPressedListener onBackPressedListener) {
        this.onBackPressedListener = onBackPressedListener;
    }

    @Override
    public void onBackPressed() {
        if (onBackPressedListener != null)
            onBackPressedListener.doBack();
        else
            super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        onBackPressedListener = null;
        super.onDestroy();
    }

        }
