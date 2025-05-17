package com.example.lab073;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class ResultActivity extends AppCompatActivity {

    // Các biến thành viên
    private TextView txtNhanA, txtNhanB, txtKetQua;
    private Button btnTong, btnHieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Ánh xạ các view
        txtNhanA = findViewById(R.id.txtNhanA);
        txtNhanB = findViewById(R.id.txtNhanB);
        txtKetQua = findViewById(R.id.txtKetQua);
        btnTong = findViewById(R.id.btnTong);
        btnHieu = findViewById(R.id.btnHieu);

        // Lấy dữ liệu từ Intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int a = bundle.getInt("soa");
            int b = bundle.getInt("sob");

            // Hiển thị giá trị a và b
            txtNhanA.setText(String.valueOf(a));
            txtNhanB.setText(String.valueOf(b));

            // Thiết lập OnClickListener cho nút "Trả về tổng"
            btnTong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tong = a + b;
                    Intent intent = new Intent();
                    intent.putExtra("ketqua", "Tổng: " + tong);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });

            // Thiết lập OnClickListener cho nút "Trả về hiệu"
            btnHieu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int hieu = a - b;
                    Intent intent = new Intent();
                    intent.putExtra("ketqua", "Hiệu: " + hieu);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }
    }
}

