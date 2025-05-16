package com.example.lab07;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button openChildButton = findViewById(R.id.openChildActivityButton);
        openChildButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ChildActivity.class);
            startActivity(intent);
        });
    }
}