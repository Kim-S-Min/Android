package com.example.addressbook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] arrayDatas;
    private static final int REQUEST_SELECT_RESULT = 1;
    private static final int REQUEST_SELECT_CONTACT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView simpleView = findViewById(R.id.main_listView_address);



        ArrayList<HashMap<String, String>> simpleDatas = new ArrayList<>();
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from address_data", null);
        while (cursor.moveToNext()) {
            HashMap<String, String> map = new HashMap<>();
            map.put("name", cursor.getString(1));
            map.put("hp", cursor.getString(2));
            map.put("content", cursor.getString(3));
            simpleDatas.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, simpleDatas, android.R.layout.simple_list_item_1,
                new String[]{"name", "content"}, new int[]{android.R.id.text1, android.R.id.text2});
        simpleView.setAdapter(adapter);


    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Toast t = Toast.makeText(this, arrayDatas[position], Toast.LENGTH_SHORT);
    }

}


