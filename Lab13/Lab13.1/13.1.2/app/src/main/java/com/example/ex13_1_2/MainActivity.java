package com.example.ex13_1_2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String arr[] = {"Ipad", "Iphone", "New Ipad", "SamSung", "Nokia", "Sony Ericson", "LG", "Q-Mobile", "HTC", "Blackberry", "G Phone", "FPT-Phone", "HK Phone"};
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
        final TextView selection = (TextView) findViewById(R.id.selection);
        final GridView gv = (GridView) findViewById(R.id.gridView);
        ArrayAdapter<String>da=new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_list_item_1,
                        arr
                );
        gv.setAdapter(da);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selection.setText(arr[position]);
            }
        });
    }
}