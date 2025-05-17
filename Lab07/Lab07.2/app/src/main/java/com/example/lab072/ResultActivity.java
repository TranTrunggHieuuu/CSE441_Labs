package com.example.lab072;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    private TextView txtKetQua;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Ánh xạ các view
        txtKetQua = findViewById(R.id.txtketqua);
        btnBack = findViewById(R.id.btnBack);

        // Lấy dữ liệu từ Intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            float a = bundle.getFloat("a");
            float b = bundle.getFloat("b");

            // Giải phương trình bậc 1: ax + b = 0
            if (a == 0) {
                if (b == 0) {
                    txtKetQua.setText("Phương trình vô số nghiệm");
                } else {
                    txtKetQua.setText("Phương trình vô nghiệm");
                }
            } else {
                float x = -b / a;
                DecimalFormat df = new DecimalFormat("#.##"); // Định dạng kết quả
                txtKetQua.setText("x = " + df.format(x));
            }
        } else {
            txtKetQua.setText("Không có dữ liệu để giải phương trình.");
        }

        btnBack.setOnClickListener(v -> {
            finish(); // Quay lại MainActivity
        });
    }
}