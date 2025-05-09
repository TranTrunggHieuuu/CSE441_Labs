package com.example.lab01; // Đặt tên package của bạn ở đây

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Khai báo các biến giao diện điện tử tại đây
    EditText edtA, edtB, edtKQ;
    Button btncong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ ID cho các biến giao diện điện tử
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKQ);
        btncong = findViewById(R.id.btnTong);

        // Xử lý tương tác với người dùng
        btncong.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // Lấy dữ liệu từ edtA, ép sang kiểu int và gán vào biến a
        try {
            int a = Integer.parseInt(edtA.getText().toString());
            // Lấy dữ liệu từ edtB, ép sang kiểu int và gán vào biến b
            int b = Integer.parseInt(edtB.getText().toString());

            int c = a + b; // Thực hiện phép cộng
            edtKQ.setText(String.valueOf(c)); // Hiển thị kết quả
        } catch (NumberFormatException e) {
            // Xử lý trường hợp người dùng nhập không phải số
            edtKQ.setText("Lỗi nhập liệu");
        }
    }
}