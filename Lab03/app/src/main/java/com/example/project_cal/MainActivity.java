package com.example.project_cal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2, edt3;
    Button btncong, btntru, btnnhan, btnchia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.edta);
        edt2 = findViewById(R.id.edtb);
        edt3 = findViewById(R.id.edtc);
        btncong = findViewById(R.id.btncong);
        btntru = findViewById(R.id.btntru);
        btnchia = findViewById(R.id.btnchia);
        btnnhan = findViewById(R.id.btnnhan);

        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String num1Str = edt1.getText().toString();
                    String num2Str = edt2.getText().toString();

                    if (num1Str.isEmpty() || num2Str.isEmpty()) {
                        edt3.setText("Please enter both numbers");
                        return;
                    }

                    int a = Integer.parseInt(num1Str);
                    int b = Integer.parseInt(num2Str);
                    edt3.setText("a + b = " + (a + b));
                } catch (NumberFormatException e) {
                    edt3.setText("Invalid input. Please enter numbers only.");
                }
            }
        });

        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String num1Str = edt1.getText().toString();
                    String num2Str = edt2.getText().toString();

                    if (num1Str.isEmpty() || num2Str.isEmpty()) {
                        edt3.setText("Please enter both numbers");
                        return;
                    }

                    int a = Integer.parseInt(num1Str);
                    int b = Integer.parseInt(num2Str);
                    edt3.setText("a - b = " + (a - b));
                } catch (NumberFormatException e) {
                    edt3.setText("Invalid input. Please enter numbers only.");
                }
            }
        });

        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String num1Str = edt1.getText().toString();
                    String num2Str = edt2.getText().toString();

                    if (num1Str.isEmpty() || num2Str.isEmpty()) {
                        edt3.setText("Please enter both numbers");
                        return;
                    }

                    int a = Integer.parseInt(num1Str);
                    int b = Integer.parseInt(num2Str);
                    edt3.setText("a * b = " + (a * b));
                } catch (NumberFormatException e) {
                    edt3.setText("Invalid input. Please enter numbers only.");
                }
            }
        });

        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String num1Str = edt1.getText().toString();
                    String num2Str = edt2.getText().toString();

                    if (num1Str.isEmpty() || num2Str.isEmpty()) {
                        edt3.setText("Please enter both numbers");
                        return;
                    }

                    int a = Integer.parseInt(num1Str);
                    int b = Integer.parseInt(num2Str);

                    if (b == 0) {
                        edt3.setText("B phai khac 0");
                    } else {
                        // Consider using double for more precise division
                        double result = (double) a / b;
                        edt3.setText("a / b = " + result);
                    }
                } catch (NumberFormatException e) {
                    edt3.setText("Invalid input. Please enter numbers only.");
                }
            }
        });
    }
}