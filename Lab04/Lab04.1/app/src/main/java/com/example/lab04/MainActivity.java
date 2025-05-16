package com.example.lab04; // Đặt đúng package của bạn ở đây

import androidx.appcompat.app.AppCompatActivity; // Nên kế thừa AppCompatActivity

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity { // Kế thừa AppCompatActivity

    EditText edtdoC, edtdoF;
    Button btncf, btnfc , btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtdoC = findViewById(R.id.edtdoC);
        edtdoF = findViewById(R.id.edtdoF);
        btncf = findViewById(R.id.btncf);
        btnfc = findViewById(R.id.btnfc);
        btnClear = findViewById(R.id.btnClear); // Ánh xạ nút Clear

        btncf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String doCStr = edtdoC.getText().toString().trim();
                    if (!doCStr.isEmpty()) {
                        DecimalFormat dcf = new DecimalFormat("#.##");
                        int doC = Integer.parseInt(doCStr);
                        double doF = (doC * 1.8) + 32;
                        edtdoF.setText(dcf.format(doF));
                    } else {
                        edtdoF.setText(""); // Xóa kết quả nếu ô nhập rỗng
                    }
                } catch (NumberFormatException e) {
                    edtdoF.setText("Lỗi nhập liệu"); // Hiển thị lỗi nếu không phải số
                }
            }
        });

        btnfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String doFStr = edtdoF.getText().toString().trim();
                    if (!doFStr.isEmpty()) {
                        DecimalFormat dcf = new DecimalFormat("#.##");
                        int doF = Integer.parseInt(doFStr);
                        double doC = (doF - 32) / 1.8;
                        edtdoC.setText(dcf.format(doC));
                    } else {
                        edtdoC.setText(""); // Xóa kết quả nếu ô nhập rỗng
                    }
                } catch (NumberFormatException e) {
                    edtdoC.setText("Lỗi nhập liệu"); // Hiển thị lỗi nếu không phải số
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtdoC.setText(""); // Đặt nội dung về rỗng thay vì " "
                edtdoF.setText(""); // Đặt nội dung về rỗng thay vì " "
            }
        });
    }
}