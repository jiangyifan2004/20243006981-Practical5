package com.jiangyifan.practicalfive;

import android.app.Activity;
import android.os.Bundle;

/** The initial Java and XML entry point for PracticalFive. */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Show the screen defined in activity_main.xml.
        setContentView(R.layout.activity_main);
    }
}
