package com.example.lab072;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edta, edtb;
    private Button btnkq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các view
        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        btnkq = findViewById(R.id.btnkq);

        btnkq.setOnClickListener(v -> {
            // Lấy dữ liệu từ EditText
            String strA = edta.getText().toString().trim();
            String strB = edtb.getText().toString().trim();

            // Kiểm tra dữ liệu
            if (strA.isEmpty() || strB.isEmpty()) {
                Toast.makeText(MainActivity.this, "Vui lòng nhập đủ a và b", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                float a = Float.parseFloat(strA);
                float b = Float.parseFloat(strB);

                // Tạo Intent để chuyển sang ResultActivity
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                // Truyền dữ liệu qua Bundle
                Bundle bundle = new Bundle();
                bundle.putFloat("a", a);
                bundle.putFloat("b", b);
                intent.putExtras(bundle);

                startActivity(intent);

            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "a và b phải là số", Toast.LENGTH_SHORT).show();
            }
        });
    }
}