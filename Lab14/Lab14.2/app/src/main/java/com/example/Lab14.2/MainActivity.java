package com.example.ex14_2;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TabHost.OnTabChangeListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edittim;
    TabHost tab;
    ListView lv1, lv2, lv3;
    ArrayList<Item> list1, list2, list3;
    MyarrayAdapter myarray1, myarray2, myarray3;
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
        addControl();
        addEvent();
    }

    private void addEvent() {
        tab.setOnTabChangedListener(new OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if(tabId.equalsIgnoreCase("t1")){
                    list1.clear();
                    list1.add(new Item("52300", "Em la ai Toi la ai", 0));
                    list1.add(new Item("52600", "Chen Dang", 1));
                    myarray1.notifyDataSetChanged();
                }
                if(tabId.equalsIgnoreCase("t2")){
                    list2.clear();
                    list2.add(new Item("57236", "Gui em o cuoi song Hong", 0));
                    list2.add(new Item("51548", "Say tinh", 0));
                    myarray2.notifyDataSetChanged();
                }
                if(tabId.equalsIgnoreCase("t3")){
                    list3.clear();
                    list3.add(new Item("57678", "Hat voi dong song", 1));
                    list1.add(new Item("53468", "Chen Dang_Remix", 0));
                    myarray3.notifyDataSetChanged();
                }
            }
        });
    }

    private void addControl() {
        tab = (TabHost) findViewById(R.id.tabhost);
        tab.setup();
        TabHost.TabSpec tab1=tab.newTabSpec("t1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("", getResources().getDrawable(R.drawable.search1));
        tab.addTab(tab1);
        TabHost.TabSpec tab2=tab.newTabSpec("t2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("", getResources().getDrawable(R.drawable.list));
        tab.addTab(tab2);
        TabHost.TabSpec tab3=tab.newTabSpec("t3");
        tab3.setContent(R.id.tab3);
        tab3.setIndicator("", getResources().getDrawable(R.drawable.heart_like));
        tab.addTab(tab3);
        edittim = (EditText) findViewById(R.id.editTextText);
        lv1 = (ListView) findViewById(R.id.lv1);
        lv2 = (ListView) findViewById(R.id.lv2);
        lv3 = (ListView) findViewById(R.id.lv3);
        list1 = new ArrayList<Item>();
        list2 = new ArrayList<Item>();
        list3 = new ArrayList<Item>();
        myarray1 = new MyarrayAdapter(MainActivity.this, R.layout.listitem, list1);
        myarray2 = new MyarrayAdapter(MainActivity.this, R.layout.listitem, list2);
        myarray3 = new MyarrayAdapter(MainActivity.this, R.layout.listitem, list3);
        lv1.setAdapter(myarray1);
        lv2.setAdapter(myarray2);
        lv3.setAdapter(myarray3);
    }
}