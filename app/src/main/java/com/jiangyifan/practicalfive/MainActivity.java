package com.jiangyifan.practicalfive;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText municipalityInput;
    private final TextProcessor processor = new TextProcessor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        municipalityInput = findViewById(R.id.municipality_input);
        municipalityInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                // Handle physical Enter once, when the key is pressed down.
                if (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN
                            && event.getRepeatCount() == 0) {
                        openMunicipality();
                    }
                    return true;
                }

                if (actionId == EditorInfo.IME_ACTION_GO
                        || actionId == EditorInfo.IME_ACTION_DONE) {
                    openMunicipality();
                    return true;
                }

                return false;
            }
        });
    }

    private void openMunicipality() {
        String name = processor.processMunicipality(municipalityInput.getText().toString());

        if (name == null) {
            municipalityInput.setError(getString(R.string.invalid_municipality));
            municipalityInput.requestFocus();
            return;
        }

        municipalityInput.setError(null);
        Intent intent = new Intent(MainActivity.this, Municipality.class);
        intent.putExtra(Municipality.EXTRA_MUNICIPALITY, name);
        startActivity(intent);
    }
}
