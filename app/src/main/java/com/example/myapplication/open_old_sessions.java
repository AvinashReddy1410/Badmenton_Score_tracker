package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;

public class open_old_sessions extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_old_sessions);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}