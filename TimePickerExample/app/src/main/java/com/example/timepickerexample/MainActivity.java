package com.example.timepickerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TimePicker timePicker;
    private TextView timeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  컨트롤 연결
        timeText = findViewById(R.id.timeText);
        timePicker = findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                timeText.setText(String.format("%02d:%02d", hourOfDay, minute));
            }
        });

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int hour, minute;

                hour = timePicker.getCurrentHour();
                minute = timePicker.getCurrentMinute();

                Toast.makeText(MainActivity.this,
                        String.format("%02d:%02d", hour, minute),
                        Toast.LENGTH_LONG)
                        .show();

            }
        });
    }
}