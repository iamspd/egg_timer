package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // widgets
    private SeekBar seekBarTimer;
    private TextView tvTime;

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

                int minutes = progress / 60;
                int seconds = progress - minutes * 60;

                String minutesZero = Integer.toString(minutes);

                if (!minutesZero.equals("10")){
                    minutesZero = "0" + minutesZero;
                }

                String secondsZero = Integer.toString(seconds);

                if (secondsZero.equals("0")){
                    secondsZero = "00";
                }

                String timerText = minutesZero + ":" + secondsZero;

                tvTime.setText(timerText);
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