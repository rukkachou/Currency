package com.home.currency;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final float EXCHANGE_RATE_US = 30.9f;

    private EditText edtNTD;
    private TextView textUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNTD = findViewById(R.id.ntd_edt);
        textUs = findViewById(R.id.us_text);
    }

    public void converter(View view) {
        if (edtNTD.getText().toString().isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.problem)
                    .setMessage(R.string.error_message)
                    .setPositiveButton(getString(R.string.ok), null)
                    .show();
        } else {
            float fNtd = Float.parseFloat(edtNTD.getText().toString());
            float fUs = fNtd/EXCHANGE_RATE_US;
            new AlertDialog.Builder(this)
                    .setTitle(R.string.result)
                    .setMessage(getString(R.string.result_message) + fUs)
                    .setPositiveButton(R.string.ok, null)
                    .show();
            textUs.setText(String.valueOf(fUs));
        }
    }
}