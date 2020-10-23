package com.example.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


  //  CountDownTimer countDownTimer;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.button);

      //  countDownTimer.cancel();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlert();
            }
        });

    }

    public void startAlert(){
        EditText text = findViewById(R.id.startText);
        int i = Integer.parseInt(text.getText().toString());




        Intent intent = new Intent(this, BroadcastReciver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 1000), pendingIntent);

      //  for (CountDownTimer=0; countDownTimer<i; countDownTimer--){




        Toast.makeText(this, "Alarm set in " + i + "Seconds", Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, j, Toast.LENGTH_SHORT).show();

    }

}