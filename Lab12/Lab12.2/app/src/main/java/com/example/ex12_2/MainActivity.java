package com.example.ex12_2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    String str;
    SharedPreferences share;
    SharedPreferences.Editor editor;
    ListView lv;
    ArrayList<String> arraywork;
    ArrayAdapter<String> arrayAdapter;
    EditText editwork, edithour, editminute;
    TextView txtdate;
    Button btn;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edithour = findViewById(R.id.edithour);
        editwork = findViewById(R.id.editwork);
        editminute = findViewById(R.id.editminute);
        txtdate = findViewById(R.id.textView2);
        btn = findViewById(R.id.button);
        lv = findViewById(R.id.listView);
        arraywork = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraywork);
        lv.setAdapter(arrayAdapter);
        Date currentDate = Calendar.getInstance().getTime();
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText("Hom nay: " + simpleDateFormat.format(currentDate));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editwork.getText().toString().equals("")||editwork.getText().toString().equals("")||editminute.getText().toString().equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Info missing");
                    builder.setMessage("Please enter all information of the work");
                    builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                }
                else {
                    str = editwork.getText().toString() + " - " + edithour.getText().toString() + ":" + editminute.getText().toString();
                    arraywork.add(str);
                    arrayAdapter.notifyDataSetChanged();
                    edithour.setText("");
                    editminute.setText("");
                    editwork.setText("");
                }
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                arraywork.remove(position);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        share = PreferenceManager.getDefaultSharedPreferences(this);
        editor = share.edit();
        editor.putString("Notes", str);
        editor.apply();
    }
}