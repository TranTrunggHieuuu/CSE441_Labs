package com.example.lab073;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    // Các biến thành viên
    private EditText txta, txtb, txtKetQua;
    private Button btnKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các view
        txta = findViewById(R.id.txta);
        txtb = findViewById(R.id.txtb);
        txtKetQua = findViewById(R.id.txtKetQua); // Thêm ánh xạ cho EditText Kết quả
        btnKetQua = findViewById(R.id.btnketqua);

        // Thiết lập OnClickListener cho nút "Yêu cầu kết quả"
        btnKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ EditText
                String strA = txta.getText().toString().trim();
                String strB = txtb.getText().toString().trim();

                // Kiểm tra dữ liệu
                if (strA.isEmpty() || strB.isEmpty()) {
                    txtKetQua.setText("Vui lòng nhập đủ a và b"); // Hiển thị lỗi trên EditText
                    return;
                }

                try {
                    int a = Integer.parseInt(strA);
                    int b = Integer.parseInt(strB);

                    // Tạo Intent để chuyển sang ResultActivity
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                    // Truyền dữ liệu qua Bundle
                    Bundle bundle = new Bundle();
                    bundle.putInt("soa", a);
                    bundle.putInt("sob", b);
                    intent.putExtras(bundle);

                    startActivityForResult(intent, 1); // Sử dụng startActivityForResult

                } catch (NumberFormatException e) {
                    txtKetQua.setText("a và b phải là số nguyên"); // Hiển thị lỗi trên EditText
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Kiểm tra requestCode và resultCode
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                // Lấy kết quả trả về từ ResultActivity
                String ketQua = data.getStringExtra("ketqua");
                txtKetQua.setText(ketQua); // Hiển thị kết quả lên EditText
            } else {
                txtKetQua.setText("Không có kết quả"); // Xử lý trường hợp không có kết quả
            }
        }
    }
}

