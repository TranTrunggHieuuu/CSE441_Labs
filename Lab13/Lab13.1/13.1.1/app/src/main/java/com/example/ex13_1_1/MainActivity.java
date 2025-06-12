package com.example.ex13_1_1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView selection;
    AutoCompleteTextView singleComplete;
    MultiAutoCompleteTextView multiComple;
    String arr[] = {"Hà Noi", "Hue", "Sai Gon", "Ha Giang", "Hoi An", "Kien Giang", "Lam Dong", "Long Khanh"};
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
        selection = (TextView) findViewById(R.id.selection);
        singleComplete = (AutoCompleteTextView) findViewById(R.id.editauto);
        ArrayAdapter myadapter = new ArrayAdapter<String>
                (this,
                        android.R.layout.simple_list_item_1,
                        arr
                );
        singleComplete.setAdapter(myadapter);
        multiComple = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        multiComple.setAdapter(new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_list_item_1,
                        arr
                ));
        multiComple.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        singleComplete.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                selection.setText(singleComplete.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}