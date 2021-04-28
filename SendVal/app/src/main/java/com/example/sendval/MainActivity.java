package com.example.sendval;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //  버튼 연결
        View btnCallCallee = findViewById(R.id.btnCallCallee);
        btnCallCallee.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                //  데이터를 실어서 명시적 인텐트로 전달
                Intent intent = new Intent(MainActivity.this, CalleeActivity.class);
                //  부가 데이터를 전송할 때는 putExtra를 이용
                intent.putExtra("data_int", 2021);  //  어떤 객체든 전송 가능
                intent.putExtra("data_string", "Android Programming");
                
                startActivity(intent);  //  전달된 데이터는 onCreate에서 확인
            }
        });
    }
}