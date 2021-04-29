package com.example.seekbarexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textView);

        //  OnSeekBarChange
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("[SEEKBAR]", "터치 시작");
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("[SEEKBAR]", "현재 진행 위치" + progress);
                textView.setText("Current Volume: " + progress);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("[SEEKBAR]", "터치 완료");
            }

        });
    }
}