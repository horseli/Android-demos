package com.example.asus.alarmclock;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText hour;
    private EditText minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_alarm = (Button) findViewById(R.id.buttonSetAlarm);
        hour=(EditText)findViewById(R.id.hour);
        minute=(EditText)findViewById(R.id.minute);
        String h=hour.getText().toString();
        String m=minute.getText().toString();
        int ho= Integer.parseInt(h);
        int mi= Integer.parseInt(m);
        final int hh=21;
        final int mm=6;
        btn_alarm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                creatAlarm("Alarm Testing", 21, 6);
            }
        });
    }
    public void creatAlarm(String message,int hour,int minute)
    {
        Intent intent=new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE,message);
        intent.putExtra(AlarmClock.EXTRA_HOUR,hour);
        intent.putExtra(AlarmClock.EXTRA_MINUTES,minute);
        if(intent.resolveActivity(getPackageManager())!=null){
        startActivity(intent);
    }
    }
}

