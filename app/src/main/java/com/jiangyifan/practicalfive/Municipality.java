package com.jiangyifan.practicalfive;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
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
        ImageView municipalityImage = findViewById(R.id.municipality_image);
        TextView municipalityInfo = findViewById(R.id.municipality_info);
        Button visitSite = findViewById(R.id.visit_site);

        int image;
        int colour;
        int summaryIndex;

        // The summaries are ordered: Beijing, Shanghai, Chongqing, Tianjin.
        if (name.equals("Beijing")) {
            image = R.drawable.beijing;
            colour = R.color.municipality_beijing;
            summaryIndex = 0;
        } else if (name.equals("Shanghai")) {
            image = R.drawable.shanghai;
            colour = R.color.municipality_shanghai;
            summaryIndex = 1;
        } else if (name.equals("Chongqing")) {
            image = R.drawable.chongqing;
            colour = R.color.municipality_chongqing;
            summaryIndex = 2;
        } else {
            // TextProcessor has already checked that the name is valid.
            image = R.drawable.tianjin;
            colour = R.color.municipality_tianjin;
            summaryIndex = 3;
        }

        String[] summaries = getResources().getStringArray(R.array.municipalities_array);
        int municipalityColour = getColor(colour);

        municipalityName.setText(name);
        municipalityName.setBackgroundColor(municipalityColour);
        municipalityImage.setImageResource(image);
        municipalityImage.setContentDescription(getString(R.string.municipality_photo, name));
        municipalityInfo.setText(summaries[summaryIndex]);
        municipalityInfo.setTextColor(municipalityColour);
        visitSite.setBackgroundColor(municipalityColour);
    }
}
