package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // widgets
    private SeekBar seekBarTimer;
    private TextView tvTime;

    public void updateTimer(int secondsLeft){

        int minutes = secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;

        String minutesZero = Integer.toString(minutes);

        if (minutesZero.equals("10")){
            minutesZero = "0" + minutesZero;
        }

        String secondsZero = Integer.toString(seconds);

        if (secondsZero.equals("0")){
            secondsZero = "00";
        }

        String timerText = minutesZero + ":" + secondsZero;

        tvTime.setText(timerText);

    }

    public void onTimerControllerClick(View view){

        new CountDownTimer(seekBarTimer.getProgress() * 1000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {

                updateTimer((int) millisUntilFinished / 1000);

            }

            @Override
            public void onFinish() {

            }
        }.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTime = findViewById(R.id.tvTime);

        seekBarTimer = findViewById(R.id.seekBarTimer);

        // setting the max value to 600 seconds
        seekBarTimer.setMax(600);

        // setting the progress to 30 seconds
        seekBarTimer.setProgress(30);

        seekBarTimer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                updateTimer(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}