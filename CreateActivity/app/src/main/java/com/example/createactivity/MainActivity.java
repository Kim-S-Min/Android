package com.example.createactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

//  라이프 사이클 확인
public class MainActivity extends AppCompatActivity {
    //  로그 출력을 위한 TAG 설정
    private final String TAG = MainActivity.this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //

        //  버튼 객체 찾기
        View btnNewActivity = findViewById(R.id.btnNewActivity);   //  레이아웃 내에서 id를 이용해서 위젯을 선택
        //  Click Event Listener
        btnNewActivity.setOnClickListener(new.OnClickListener(){
           //   이벤트 처리기 함수 Override
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this,   //  Context
                    "새 액티비티를 호출합니다.",   //  Message
                    Toast.LENGTH_LONG)  //  지속시간
                    .show();            //  토스트 띄우기

            //  새 액티비티를 띄워주기
            //  컴포넌트간 데이터 전송을 위해서 intent필요
            //  명시적 인텐트 : 호출하고자 하는 Activit를 직접 명시한다
            Intent intent = new Intent(packageContext:MainActivity.this,
                    newActivity.class);
            startActivity();
        }
        });
        Log.d(TAG, "[LifeCycle] onCreate() call");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "[LifeCycle] onStart() call");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "[LifeCycle] onStop() call");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "[LifeCycle] onDestroy() call");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "[LifeCycle] onPause() call");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "[LifeCycle] onResume() call");
    }
}