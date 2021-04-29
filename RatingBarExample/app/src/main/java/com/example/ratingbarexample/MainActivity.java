package com.example.ratingbarexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  RatingBar 이벤트: OnRationBarChange
        RatingBar rb = findViewById(R.id.ratingBar1);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                //  rating 값으로 선택한 등급 확인
                ((TextView)findViewById(R.id.editText)).setText("rating:" + rating);
            }
        });
    }
}