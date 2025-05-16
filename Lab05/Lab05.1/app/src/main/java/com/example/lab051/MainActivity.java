package com.example.lab051; // Đặt đúng package của bạn ở đây

import androidx.appcompat.app.AppCompatActivity; // Nên kế thừa AppCompatActivity

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editnamduonglich;
    TextView textviewnamamlich;
    Button buttonChuyenDoi;

    private final String[] can = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
    private final String[] chi = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editnamduonglich = findViewById(R.id.editnamduonglich);
        textviewnamamlich = findViewById(R.id.textviewnamamlich);
        buttonChuyenDoi = findViewById(R.id.buttonChuyenDoi);

        buttonChuyenDoi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonChuyenDoi) {
            chuyenDoiNamDuongLich();
        }
    }

    private void chuyenDoiNamDuongLich() {
        String namDuongLichStr = editnamduonglich.getText().toString().trim();

        if (namDuongLichStr.isEmpty()) {
            textviewnamamlich.setText("Vui lòng nhập năm dương lịch");
            return;
        }

        try {
            int namDuongLich = Integer.parseInt(namDuongLichStr);

            if (namDuongLich < 1900) {
                textviewnamamlich.setText("Năm phải từ 1900 trở lên");
                return;
            }

            int canIndex = (namDuongLich - 4) % 10;
            if (canIndex < 0) {
                canIndex += 10;
            }

            int chiIndex = (namDuongLich - 4) % 12;
            if (chiIndex < 0) {
                chiIndex += 12;
            }

            String namAmLich = can[canIndex] + " " + chi[chiIndex];
            textviewnamamlich.setText(namAmLich);

        } catch (NumberFormatException e) {
            textviewnamamlich.setText("Định dạng năm không hợp lệ");
        }
    }
}