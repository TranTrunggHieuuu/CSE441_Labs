package com.example.lab07; // Đặt đúng package của bạn ở đây

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.content.Intent;

public class ChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child); // Đảm bảo đây là ID chính xác của layout

        // Ánh xạ các view
        Button backToMainButton = findViewById(R.id.backToMainActivityButton); // Sử dụng ID chính xác


        // Thiết lập OnClickListener cho nút Back
        backToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để quay lại MainActivity
                Intent intentToMain = new Intent(ChildActivity.this, MainActivity.class);
                startActivity(intentToMain);
                finish(); // Đóng ChildActivity để người dùng không thể quay lại bằng nút Back của điện thoại
            }
        });
    }
}
