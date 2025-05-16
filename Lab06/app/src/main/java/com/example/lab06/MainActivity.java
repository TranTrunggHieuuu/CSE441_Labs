package com.example.lab06;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {

    // Các biến thành viên để tham chiếu đến các view trong layout
    private EditText editHoTen, editCMND, editBosung;
    private TextView textViewThongTinCaNhan, textViewBangCap, textViewSoThich, textViewThongTinBoSung;
    private RadioGroup radioGroupBangCap;
    private RadioButton radtc, radcd, raddh;
    private CheckBox chkdocbao, chkdocsach, chkdoccoding;
    private Spinner spinnerNgheNghiep;
    private Button btnGuiThongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các view từ layout vào các biến thành viên
        anhXaCacView();

        // Thiết lập listener cho nút Gửi thông tin
        btnGuiThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hienThiThongTinCaNhan();
            }
        });
    }

    private void anhXaCacView() {
        textViewThongTinCaNhan = findViewById(R.id.textViewThongTinCaNhan);
        editHoTen = findViewById(R.id.editHoTen);
        editCMND = findViewById(R.id.editCMND);
        textViewBangCap = findViewById(R.id.textViewBangCap);
        radioGroupBangCap = findViewById(R.id.radioGroup1);
        radtc = findViewById(R.id.radtc);
        radcd = findViewById(R.id.radcd);
        raddh = findViewById(R.id.raddh);
        textViewSoThich = findViewById(R.id.textViewSoThich);
        chkdocbao = findViewById(R.id.chkdocbao);
        chkdocsach = findViewById(R.id.chkdocsach);
        chkdoccoding = findViewById(R.id.chkdoccoding);
        editBosung = findViewById(R.id.editBosung);
        btnGuiThongTin = findViewById(R.id.btnguitt);

    }

    private void hienThiThongTinCaNhan() {
        // 1. Lấy dữ liệu từ các view
        String hoTen = editHoTen.getText().toString().trim();
        String cmnd = editCMND.getText().toString().trim();
        String bangCap = layBangCap();  // Hàm riêng để lấy bằng cấp
        String soThich = laySoThich();    // Hàm riêng để lấy sở thích
        String ngheNghiep = spinnerNgheNghiep.getSelectedItem().toString();
        String thongTinBoSung = editBosung.getText().toString().trim();

        // 2. Kiểm tra dữ liệu đầu vào
        if (!kiemTraDuLieuHopLe(hoTen, cmnd, bangCap)) {
            return; // Nếu dữ liệu không hợp lệ, dừng lại và hiển thị thông báo
        }

        // 3. Xây dựng thông báo
        String message = "Họ tên: " + hoTen + "\n"
                + "CMND: " + cmnd + "\n"
                + "Bằng cấp: " + bangCap + "\n"
                + "Sở thích: " + soThich + "\n"
                + "Nghề nghiệp: " + ngheNghiep + "\n"
                + "Thông tin bổ sung: " + thongTinBoSung;

        // 4. Hiển thị thông báo bằng AlertDialog
        hienThiAlertDialog(message);
    }

    private String layBangCap() {
        if (radtc.isChecked()) {
            return radtc.getText().toString();
        } else if (radcd.isChecked()) {
            return radcd.getText().toString();
        } else if (raddh.isChecked()) {
            return raddh.getText().toString();
        }
        return ""; // Trả về chuỗi rỗng nếu không có RadioButton nào được chọn
    }

    private String laySoThich() {
        StringBuilder soThich = new StringBuilder();
        if (chkdocbao.isChecked()) {
            soThich.append(chkdocbao.getText()).append(", ");
        }
        if (chkdocsach.isChecked()) {
            soThich.append(chkdocsach.getText()).append(", ");
        }
        if (chkdoccoding.isChecked()) {
            soThich.append(chkdoccoding.getText()).append(", ");
        }
        if (soThich.length() > 2) {
            soThich.setLength(soThich.length() - 2); // Xóa ", " cuối cùng
        }
        return soThich.toString();
    }

    private boolean kiemTraDuLieuHopLe(String hoTen, String cmnd, String bangCap) {
        if (hoTen.length() < 3) {
            Toast.makeText(this, "Họ tên phải có ít nhất 3 ký tự", Toast.LENGTH_LONG).show();
            return false;
        }
        if (cmnd.length() != 9 || !cmnd.matches("\\d+")) {
            Toast.makeText(this, "CMND phải là 9 chữ số", Toast.LENGTH_LONG).show();
            return false;
        }
        if (bangCap.isEmpty()) {
            Toast.makeText(this, "Vui lòng chọn bằng cấp", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private void hienThiAlertDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân")
                .setMessage(message)
                .setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        builder.create().show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Question")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        builder.create().show();
    }
}
