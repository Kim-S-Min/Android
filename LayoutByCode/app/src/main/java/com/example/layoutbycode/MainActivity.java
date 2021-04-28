package com.example.layoutbycode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //  Layout XML의 도움 없이 코드를 이용한  UI 구성하기
        LinearLayout layout = new LinearLayout(MainActivity.this);
        layout.setOrientation(LinearLayout.VERTICAL);

        Button button = new Button(MainActivity.this);
        button.setText("Say Hello!");

        tvMessage = new TextView(MainActivity.this);
        tvMessage.setText("Hello, Android!");
        tvMessage.setTextAppearance(MainActivity.this,
                android.R.style.TextAppearance_Large);

        layout.addView(tvMessage);
        layout.addView(button);

        setContentView(layout);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMessage.setText("Button is Clicked!");
            }
        });
    }
}