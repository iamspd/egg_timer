package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
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

        String secondsZero = Integer.toString(seconds);

        if (!minutesZero.equals("10")){
            minutesZero = "0" + minutesZero;
        }

        if (seconds <= 9){
            secondsZero = "0" + secondsZero;
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

                Log.i("Timer Countdown: ", "finished!");

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