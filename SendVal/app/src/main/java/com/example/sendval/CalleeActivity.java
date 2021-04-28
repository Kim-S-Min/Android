package com.example.sendval;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.Toast;

public class CalleeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callee);

        //  액티비티를 호출한 Intent 확인
        Intent intent = getIntent();

        Toast.makeText(CalleeActivity.this,
                intent.getExtras().get("data_int").toString(),
                Toast.LENGTH_LONG)
                .show();

        Toast.makeText(CalleeActivity.this,
                intent.getStringExtra("data_string"),
                Toast.LENGTH_LONG)
                .show();
    }
}