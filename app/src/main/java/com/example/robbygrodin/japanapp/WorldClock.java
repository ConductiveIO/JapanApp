package com.example.robbygrodin.japanapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextClock;


public class WorldClock extends ActionBarActivity {

    public static final CharSequence DEFAULT_FORMAT_12_HOUR = "h:mm aa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_clock);

        TextClock japanClock = (TextClock) findViewById(R.id.japanClock);
        TextClock bostonClock = (TextClock) findViewById(R.id.bostonClock);

        japanClock.setFormat12Hour(DEFAULT_FORMAT_12_HOUR);
        bostonClock.setFormat12Hour(DEFAULT_FORMAT_12_HOUR);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_world_clock, menu);
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
}
