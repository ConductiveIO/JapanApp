package com.example.robbygrodin.japanapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class YenConverter extends ActionBarActivity {
    boolean isYenToDollar = true;
    final double yenToDollarRate = 0.0084;
    final double dollarToYenRate = 118.99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yen_converter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_yen_converter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void convertCurrency(View view) {
        EditText inputText = (EditText) findViewById(R.id.input_value);
        double input = Integer.parseInt(inputText.getText().toString().replaceAll("[^\\d.]", ""));
        String output;
        if (isYenToDollar) {
            double value = Math.round((input * yenToDollarRate) * 1000) / 1000;
            output = getString(R.string.dollar_sign) +  String.valueOf(value);
        } else {
            double value = Math.round((input * dollarToYenRate) * 100) / 100;
            output = getString(R.string.yen_sign) + String.valueOf(value);
        }
        EditText outputText = (EditText) findViewById(R.id.conversionResult);
        outputText.setText(output);
    }

    public void switchConversion(View view) {
        isYenToDollar = !isYenToDollar;

        EditText inputText = (EditText) findViewById(R.id.input_value);
        EditText outputText = (EditText) findViewById(R.id.conversionResult);

        if(isYenToDollar) {
            inputText.setText(getString(R.string.yen_sign));
            outputText.setText(getString(R.string.dollar_sign));
        } else {
            inputText.setText(getString(R.string.dollar_sign));
            outputText.setText(getString(R.string.yen_sign));
        }
    }
}
