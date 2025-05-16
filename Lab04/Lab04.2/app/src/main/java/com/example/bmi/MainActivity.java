package com.example.bmi; // Đặt đúng package của bạn ở đây

import androidx.appcompat.app.AppCompatActivity; // Nên kế thừa AppCompatActivity

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener { // Implement OnClickListener

    EditText editTen, editChieuCao, editCannang;
    TextView editBMI, editChuandoan;
    Button btnTinhBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTen = findViewById(R.id.editTextName);
        editChieuCao = findViewById(R.id.editTextHeight);
        editCannang = findViewById(R.id.editTextWeight);
        editBMI = findViewById(R.id.editTextBMI);
        editChuandoan = findViewById(R.id.editTextDiagnosis);
        btnTinhBMI = findViewById(R.id.buttonCalculateBMI);

        btnTinhBMI.setOnClickListener(this); // Thiết lập OnClickListener cho nút Tính BMI
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonCalculateBMI) {
            calculateBMI();
        }
    }

    private void calculateBMI() {
        String chieuCaoStr = editChieuCao.getText().toString().trim();
        String canNangStr = editCannang.getText().toString().trim();

        if (chieuCaoStr.isEmpty()) {
            editBMI.setText("Vui lòng nhập chiều cao");
            editChuandoan.setText("");
            return;
        }

        if (canNangStr.isEmpty()) {
            editBMI.setText("Vui lòng nhập cân nặng");
            editChuandoan.setText("");
            return;
        }

        try {
            double chieuCao = Double.parseDouble(chieuCaoStr) / 100.0; // Đổi từ cm sang mét
            double canNang = Double.parseDouble(canNangStr);

            if (chieuCao <= 0 || canNang <= 0) {
                editBMI.setText("Giá trị không hợp lệ");
                editChuandoan.setText("");
                return;
            }

            double bmi = canNang / (chieuCao * chieuCao);
            DecimalFormat df = new DecimalFormat("#.##");
            editBMI.setText(df.format(bmi));

            String chuandoan = "";
            if (bmi < 18.5) {
                chuandoan = "Bạn gầy";
            } else if (bmi < 25) {
                chuandoan = "Bạn bình thường";
            } else if (bmi < 30) {
                chuandoan = "Bạn béo phì độ 1";
            } else if (bmi < 35) {
                chuandoan = "Bạn béo phì độ 2";
            } else {
                chuandoan = "Bạn béo phì độ 3";
            }
            editChuandoan.setText(chuandoan);

        } catch (NumberFormatException e) {
            editBMI.setText("Lỗi nhập liệu");
            editChuandoan.setText("");
        }
    }
}