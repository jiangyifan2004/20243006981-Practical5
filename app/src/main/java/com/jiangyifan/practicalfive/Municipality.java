package com.jiangyifan.practicalfive;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Municipality extends Activity {

    public static final String EXTRA_MUNICIPALITY = "municipality";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String input = getIntent().getStringExtra(EXTRA_MUNICIPALITY);
        TextProcessor processor = new TextProcessor();
        String name = processor.processMunicipality(input);

        if (name == null) {
            Toast.makeText(this, R.string.missing_municipality, Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        setContentView(R.layout.activity_municipality);
        TextView municipalityName = findViewById(R.id.municipality_name);
        municipalityName.setText(name);
    }
}
