package com.example.eventexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener {

    TextView bellTextView;
    TextView labelTextView;
    CheckBox repeatCheckView;
    CheckBox vibrateCheckView;
    Switch switchView;

    float initX;
    long initTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bellTextView = findViewById(R.id.bell_name);
        labelTextView = findViewById(R.id.label);
        repeatCheckView = findViewById(R.id.repeatCheck);
        vibrateCheckView = findViewById(R.id.vibrate);
        switchView = findViewById(R.id.onOff);

        bellTextView.setOnClickListener(this);
        labelTextView.setOnClickListener(this);

        repeatCheckView.setOnCheckedChangeListener(this);
        vibrateCheckView.setOnCheckedChangeListener(this);
        switchView.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == bellTextView) {
            showToast("bell text click event...");
        } else if (v == labelTextView) {
            showToast("label text click event...");
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView == repeatCheckView) {
            showToast("repeat checkbox is " + isChecked);
        } else if (buttonView == vibrateCheckView) {
            showToast("vibrate checkbox is " + isChecked);
        } else if (buttonView == switchView) {
            showToast ("switch is " + isChecked);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            initX=event.getRawX();
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            float diffx = initX-event.getRawX();
            if (diffx > 30) {
                showToast("???????????? ????????? ???????????????");
            } else if (diffx <- 30) {
                showToast("??????????????? ????????? ???????????????.");
            }
        }
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - initTime > 3000) {
                showToast("??????????????? ?????? ??? ????????????");
                initTime = System.currentTimeMillis();

            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}