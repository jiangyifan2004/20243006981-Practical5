package com.jiangyifan.practicalfive;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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
        String website;

        // The summaries are ordered: Beijing, Shanghai, Chongqing, Tianjin.
        if (name.equals("Beijing")) {
            image = R.drawable.beijing;
            colour = R.color.municipality_beijing;
            summaryIndex = 0;
            website = getString(R.string.website_beijing);
        } else if (name.equals("Shanghai")) {
            image = R.drawable.shanghai;
            colour = R.color.municipality_shanghai;
            summaryIndex = 1;
            website = getString(R.string.website_shanghai);
        } else if (name.equals("Chongqing")) {
            image = R.drawable.chongqing;
            colour = R.color.municipality_chongqing;
            summaryIndex = 2;
            website = getString(R.string.website_chongqing);
        } else {
            // TextProcessor has already checked that the name is valid.
            image = R.drawable.tianjin;
            colour = R.color.municipality_tianjin;
            summaryIndex = 3;
            website = getString(R.string.website_tianjin);
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

        visitSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));

                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException exception) {
                    Toast.makeText(Municipality.this, R.string.no_browser,
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
