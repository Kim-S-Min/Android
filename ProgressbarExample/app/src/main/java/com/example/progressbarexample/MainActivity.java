package com.example.progressbarexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressCircle;
    private ProgressBar progressHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  참조 연결
        progressCircle = findViewById(R.id.progressCircle);
        progressHorizontal = findViewById(R.id.progressHorizontal);
    }

    public void onButtonClick(View v) {
        int buttonId = v.getId();

        switch (buttonId) {
            case R.id.buttonToggleProgressCircle:
                ToggleButton tb = (ToggleButton)v;  //  다운 캐스팅
                //  토글 버튼 체크 여부 확인
                boolean isChecked = tb.isChecked();
                progressCircle.setVisibility(isChecked ? View.INVISIBLE : View.VISIBLE);
                break;

            case R.id.buttonProgressBarPrimaryIncrease: //  주 프로그래스 바 증가
                progressHorizontal.incrementProgressBy(10);
                break;

            case R.id.buttonProgressBarPrimaryDecrease: //  주 프로그래스 바 감소
                progressHorizontal.incrementProgressBy(-10);
                break;

            case R.id.buttonProgressBarSecondaryIncrease:   //  보조 프로그래스 바 증가
                progressHorizontal.incrementSecondaryProgressBy(10);
                break;

            case R.id.buttonProgressBarSecondaryDecrease:   //  보조 프로그래스 바 감소
                progressHorizontal.incrementSecondaryProgressBy(-10);
                break;

        }
    }
}