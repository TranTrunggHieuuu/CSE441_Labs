package com.example.ex13_2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String namephone[] = {"Dien thoai Iphone 12", "Dien thoai Samsung S20", "Dien thoai Nokia 6", "Dien thoai Bphone 2020",
    "Dien thoai Oppo 5", "Dien thoai Joy2"};
    ArrayList<phone> mylist;
    MyArrayAdapter myadapter;
    ListView lv;
    int imagephone[] = {R.drawable.phone1, R.drawable.phone2, R.drawable.phone3, R.drawable.phone4, R.drawable.phone5, R.drawable.phone6, R.drawable.phone7};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>();
        for (int i=0; i<namephone.length; i++){
            mylist.add(new phone(namephone[i], imagephone[i]));
        }
        myadapter = new MyArrayAdapter(this, R.layout.layout_listview, mylist);
        lv.setAdapter(myadapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myintent = new Intent(MainActivity.this, SubActivity.class);
                myintent.putExtra("name", namephone[position]);
                startActivity(myintent);
            }
        });
    }
}