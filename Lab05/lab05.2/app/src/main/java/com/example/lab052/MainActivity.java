package com.example.lab052; // Đặt đúng package của bạn ở đây

import androidx.appcompat.app.AppCompatActivity; // Nên kế thừa AppCompatActivity

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.lang.Math;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edita, editb, editc;
    TextView tvketqua;
    Button btntieptuc, btngiaipt, btnthoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edita = findViewById(R.id.edita);
        editb = findViewById(R.id.editb);
        editc = findViewById(R.id.editc);
        tvketqua = findViewById(R.id.tvketqua);
        btntieptuc = findViewById(R.id.btntieptuc);
        btngiaipt = findViewById(R.id.btngiaipt);
        btnthoat = findViewById(R.id.btnthoat);

        btngiaipt.setOnClickListener(this);
        btntieptuc.setOnClickListener(this);
        btnthoat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btngiaipt) {
            giaiPhuongTrinhBacHai();
        } else if (id == R.id.btntieptuc) {
            edita.setText("");
            editb.setText("");
            editc.setText("");
            tvketqua.setText("");
            edita.requestFocus();
        } else if (id == R.id.btnthoat) {
            finish();
        }
    }

    private void giaiPhuongTrinhBacHai() {
        String sa = edita.getText().toString().trim();
        String sb = editb.getText().toString().trim();
        String sc = editc.getText().toString().trim();

        if (sa.isEmpty() || sb.isEmpty() || sc.isEmpty()) {
            tvketqua.setText("Vui lòng nhập đủ hệ số a, b, c");
            return;
        }

        try {
            double a = Double.parseDouble(sa);
            double b = Double.parseDouble(sb);
            double c = Double.parseDouble(sc);

            DecimalFormat dcf = new DecimalFormat("#.##");

            if (a == 0) {
                if (b == 0) {
                    if (c == 0) {
                        tvketqua.setText("PT vô số nghiệm");
                    } else {
                        tvketqua.setText("PT vô nghiệm");
                    }
                } else {
                    double x = -c / b;
                    tvketqua.setText("PT có 1 No: x = " + dcf.format(x));
                }
            } else {
                double delta = b * b - 4 * a * c;
                if (delta < 0) {
                    tvketqua.setText("PT vô nghiệm");
                } else if (delta == 0) {
                    double x = -b / (2 * a);
                    tvketqua.setText("PT có nghiệm kép x1 = x2 = " + dcf.format(x));
                } else {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    tvketqua.setText("PT có 2 No: x1 = " + dcf.format(x1) + "; x2 = " + dcf.format(x2));
                }
            }

        } catch (NumberFormatException e) {
            tvketqua.setText("Lỗi nhập liệu. Vui lòng nhập số");
        }
    }
}