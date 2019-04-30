package com.example.alarmtake2;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.provider.AlarmClock;
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
    AlarmManager manager;

//    Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmTime = findViewById(R.id.alarmTimePicker);
        currentTime = findViewById(R.id.textClock);
//        currentTime.setFormat24Hour("hh:mm a");
//        alarmTrigger = findViewById(R.id.alarmTrigger);
//        manager = (AlarmManager) getSystemService(ALARM_SERVICE);
//        alarmTrigger.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    if (alarmTime().contains(currentTime.getText().toString())) {
//                        r.play();
//                    }
//                } else {
//                    r.stop();
//                }
//            }
//        });
//    }
        final Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            //Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
            @Override
            public void run() {
                if (currentTime.getText().toString().equals(AlarmTime())) {
                    System.out.println("current" + currentTime.getText().toString());
                    System.out.println("alarm" + AlarmTime());
                    r.play();
                } else {
                    System.out.println("current" + currentTime.getText().toString());
                    System.out.println("alarm" + AlarmTime());
                    r.stop();

                }
            }
        }, 0, 1000);
    }
//    public void MathPage() {
//        Intent intent = new Intent(this, MathPage.class);
//        //setContentView(R.layout.math);
//        startActivity(intent);
//
//    }
    public String AlarmTime() {
//        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT-5:00"));
//        Date d = c.getTime();
//        DateFormat date = new SimpleDateFormat("hh:mm a");
//        date.setTimeZone(TimeZone.getTimeZone("GMT-5:00"));
//        String now = date.format(d);
        Integer hours = alarmTime.getHour();
        Integer minutes = alarmTime.getMinute();
        String alarmMin;
        if (minutes < 10) {
            alarmMin = "0";
            alarmMin = alarmMin.concat(minutes.toString());
        } else {
            alarmMin = minutes.toString();
        }
        String AT;
        if (hours > 12) {
            hours = hours - 12;
            AT = hours.toString().concat(":").concat(alarmMin).concat(" PM");
        } else {
            AT = hours.toString().concat(":").concat(alarmMin).concat(" AM");
        }
        return AT;
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
