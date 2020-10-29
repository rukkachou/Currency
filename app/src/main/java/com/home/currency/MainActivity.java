package com.home.currency;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final float EXCHANGE_RATE_US = 30.9f;
    private static final float EXCHANGE_RATE_JP = 0.2773f;

    private EditText edtNTD;
    private TextView textUs;
    private TextView textJp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNTD = findViewById(R.id.ntd_edt);
        textUs = findViewById(R.id.us_text);
        textJp = findViewById(R.id.jp_text);
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
            float fJp = fNtd/EXCHANGE_RATE_JP;

            new AlertDialog.Builder(this)
                    .setTitle(R.string.result)
                    .setMessage(getString(R.string.usd_is) + fUs + "\n" + getString(R.string.jpy_is) + fJp)
                    .setPositiveButton(R.string.ok, null)
                    .show();
            textUs.setText(String.valueOf(fUs));
            textJp.setText(String.valueOf(fJp));
        }
    }
}