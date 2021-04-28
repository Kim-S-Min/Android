package com.example.widget01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvMessage;
    private EditText editTextMessage;
    private Button btnShow;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  컨트롤 연결
        tvMessage = findViewById(R.id.tvMessage);
        editTextMessage = findViewById(R.id.editTextMessage);
        btnShow = findViewById(R.id.btnShow);

        btnShow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //  editTextMessage -> Text
                String message = editTextMessage.getText().toString();
                //  Text -> tvMessage
                tvMessage.setText(message);
            }

        });

        spinner = findViewById(R.id.spinner);
        //  선택 결과는 OnItemSelectdListener로 전달
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //  선택한 아이템의 인덱스가 position매개변수로 전달
                //  데이터는 parent AdapterView를 통해 전달된다
                String selectedSeason = (String)adapterView.getItemAtPosition(position);
                tvMessage.setText(selectedSeason);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //  아무것도 선택되지 않았을 때의 콜백
                tvMessage.setText("아무 것도 선택되지 않았습니다.");
            }
        });

    }
}