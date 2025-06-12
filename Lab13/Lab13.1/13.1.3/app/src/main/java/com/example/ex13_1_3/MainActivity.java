package com.example.ex13_1_3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.AdapterView.OnItemClickListener;
public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    TextView tvMsg;
    GridView gv;
    TextView tvSolo;
    Integer[]Anh;
    ImageAdapter adapter=null;
    ImageView ivSoloPicture;
    Button btnBack;
    Bundle myBackupBundle;
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
        tvMsg = (TextView) findViewById(R.id.textView);
        Anh=new Integer[]{
                R.drawable.avatar, R.drawable.avatar2, R.drawable.avatar5, R.drawable.cai_dat, R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground};
        gv = (GridView) findViewById(R.id.gridView);
        adapter = new ImageAdapter(this, Anh);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        showdetail(position);
    }
    public void showdetail(int position){
        setContentView(R.layout.activity_image_adapter);
        tvSolo=(TextView) findViewById(R.id.txtSolo);
        tvSolo.setText("Image at: " + position);
        ivSoloPicture.setImageResource(Anh[position]);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreate(myBackupBundle);
            }
        });
    }
}