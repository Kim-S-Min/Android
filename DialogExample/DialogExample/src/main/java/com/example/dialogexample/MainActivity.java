package com.example.dialogexample;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button alertBtn;
    Button listBtn;
    Button dateBtn;
    Button timeBtn;
    Button customDialogBtn;
    AlertDialog customDialog;
    AlertDialog listDialog;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  View 객체 생성
        alertBtn = findViewById(R.id.btn_alert);
        listBtn = findViewById(R.id.btn_list);
        dateBtn = findViewById(R.id.btn_date);
        timeBtn = findViewById(R.id.btn_time);
        customDialogBtn = findViewById(R.id.btn_custom);

        //  이벤트 리스너 연결
        alertBtn.setOnClickListener(this);
        listBtn.setOnClickListener(this);
        dateBtn.setOnClickListener(this);
        timeBtn.setOnClickListener(this);
        customDialogBtn.setOnClickListener(this);
    }

    private void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    DialogInterface.OnCancelListener dialogListener = new DialogInterface.OnCancelListener() {
        @Override
        public void onCancel(DialogInterface dialog) {
            if (dialog == customDialog && which == DialogInterface.BUTTON_POSITIVE) {    //  버튼이 positive인지 확인하는 것 (negertive가 아니어야 한다)
                showToast("커스텀 다이얼로그 확인 click....");
            } else if (dialog == listDialog) {
                String[] data = getResources().getStringArray(R.array.dialog_array);
                showToast(data[which] + " 선택하셨습니다.");
            } else if (dialog == alertDialog && which == DialogInterface.BUTTON_POSITIVE) {
                showToast("alert dialog OK click.....");
            }

        }
    };

    @Override
    public void onClick(View v) {
        if (v == alertBtn) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setTitle("알림");
            builder.setMessage("정말 종료하시겠습니까?");
            builder.setPositiveButton("OK", (DialogInterface.OnClickListener) dialogListener);
            builder.setNegativeButton("NOK", null);

            alertDialog = builder.create();
            alertDialog.show();
        } else if (v == listBtn) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("알람 벨소리");
            builder.setSingleChoiceItems(R.array.dialog_array, 0, (DialogInterface.OnClickListener) dialogListener);
            builder.setPositiveButton("확인", null);
            builder.setNegativeButton("취소", null);

            listDialog = builder.create();
            alertDialog.show();

        } else if (v == dateBtn) {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dateDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    showToast(year + ":" + (monthOfYear+1) + ":" + dayOfMonth);
                }
            }, year, month, day);
            dateDialog.show();
        } else if (v == timeBtn) {
            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            TimePickerDialog timeDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    showToast(hourOfDay + ":" + minute);
                }
            }, hour, minute, false);
            timeDialog.show();
        } else if (v == customDialogBtn) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.dialog_layout, null);
            builder.setView(view);

            builder.setPositiveButton("확인", (DialogInterface.OnClickListener) dialogListener);
            builder.setNegativeButton("취소", null);

            customDialog = builder.create();
            customDialog.show();
        }
    }
}