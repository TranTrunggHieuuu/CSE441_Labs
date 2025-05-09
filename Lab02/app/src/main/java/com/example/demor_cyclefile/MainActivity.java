package com.example.demor_cyclefile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btncall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "CR424 - onCreate()", Toast.LENGTH_SHORT).show();

        btncall = findViewById(R.id.btncall);
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, Subactivity.class);
                startActivity(intent1);
            }
        });
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(this,"CSE441 - onDestroy",Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(this,"CSE441 - onStop",Toast.LENGTH_SHORT).show();
//
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(this,"CSE441 - onStart",Toast.LENGTH_SHORT).show();
//
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Toast.makeText(this,"CSE441 - onPause",Toast.LENGTH_SHORT).show();
//
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(this,"CSE441 - onResume",Toast.LENGTH_SHORT).show();
//
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Toast.makeText(this,"CSE441 - onRestart",Toast.LENGTH_SHORT).show();
//
//    }
}