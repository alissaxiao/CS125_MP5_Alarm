package com.example.alarmtake2;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TimePicker;
import android.util.TimeUtils;
import android.app.AlarmManager;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button alarmTime;
    Button currentTime;
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        alarmTime = findViewById(R.id.switch1);
        currentTime = findViewById(R.id.alarmTimePicker);
        final Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (currentTime.getText().toString().equals(alarmTime())) {
                    r.play();
                } else {
                    r.stop();
                }
            }
        }, 0, 1000);
    }
    public String alarmTime() {
        Integer hours = alarmTime.getCurrentHour();
        Integer minutes = alarmTime.getCurrentMinute();
        String setAlarmTime;
        String alarmMin;
        if (minutes < 10) {
            alarmMin = "0";
            alarmMin = alarmMin.concat(alarmMin.toString());
        } else {
            alarmMin = minutes.toString();
        }
        if (hours > 12) {
            hours = hours - 12;
            setAlarmTime = hours.toString().concat(":").concat(minutes.toString()).concat("PM");
        } else {
            setAlarmTime = hours.toString().concat(":").concat(minutes.toString()).concat("AM");
        }
        return setAlarmTime;

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "add alarm", Snackbar.LENGTH_LONG)
                        .setAction("add alarm", null).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
