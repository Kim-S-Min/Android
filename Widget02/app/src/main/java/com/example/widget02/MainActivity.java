package com.example.widget02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //  컨트롤
    private RadioGroup radioGroup;
    private CheckBox checkBox;
    private TextView radioChecker;
    private TextView checkboxChecker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  컨트롤 연결
        radioGroup = findViewById(R.id.radioGroup);
        checkBox = findViewById(R.id.checkBox);
        radioChecker = findViewById(R.id.radioChecker);
        checkboxChecker = findViewById(R.id.checkboxChecker);

        // RadioGroup -> OnCheckedChange
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //  선택된 RadioButton의 아이디가 checkedId로 전달
                switch (checkedId) {
                    case R.id.radio1:
                        radioChecker.setText("Female이 선택되었습니다");
                        break;
                    case R.id.radio2:
                        radioChecker.setText("Male이 선택되었습니다.");
                }
            }
        });

        //  checkBox -> OnClickListener 이벤트 발생
        checkBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //  다운 캐스팅
                CheckBox cb = (CheckBox)v;
                boolean checked = cb.isChecked();   //  체크 여부 확인

                checkboxChecker.setText("CheckBox is " + (checked ? "checked" : "unchecked"));
            }
        });
    }
}