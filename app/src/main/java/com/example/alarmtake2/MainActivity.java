package com.example.alarmtake2;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;
import android.content.Intent;
import android.util.TimeUtils;
import android.app.AlarmManager;
import android.widget.ToggleButton;
import android.app.PendingIntent;

import org.w3c.dom.Text;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TimePicker alarmTime;
    TextClock currentTime;
    ToggleButton alarmTrigger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmTime = findViewById(R.id.alarmTimePicker);
        currentTime = findViewById(R.id.textClock);
        alarmTrigger = findViewById(R.id.alarmTrigger);
        alarmTrigger.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                }
            }
        });

        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));

            @Override
            public void run() {
                r.stop();
                if (alarmTime().contains(currentTime.getText().toString())) {
                    r.play();
                }
            }
        }, 0, 1000);
    }
    public void MathPage() {
        Intent intent = new Intent(this, MathPage.class);
        //setContentView(R.layout.math);
        startActivity(intent);

    }
    public String alarmTime() {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT-5:00"));
        Date d = c.getTime();
        DateFormat date = new SimpleDateFormat("hh:mm a");
        date.setTimeZone(TimeZone.getTimeZone("GMT-5:00"));
        String now = date.format(d);
//        Integer hours = Calendar.HOUR;
//        Integer minutes = Calendar.MINUTE;
//        String alarmMin;
//        if (minutes < 10) {
//            alarmMin = "0";
//            alarmMin = alarmMin.concat(alarmMin.toString());
//        } else {
//            alarmMin = minutes.toString();
//        }
//        if (hours > 12) {
//            hours = hours - 12;
//            setAlarmTime = hours.toString().concat(":").concat(minutes.toString()).concat("PM");
//        } else {
//            setAlarmTime = hours.toString().concat(":").concat(minutes.toString()).concat("AM");
//        }

        return now;
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
