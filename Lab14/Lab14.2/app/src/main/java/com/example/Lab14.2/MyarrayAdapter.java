package com.example.ex14_2;

import android.app.Activity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyarrayAdapter extends ArrayAdapter<Item> {
    Activity context = null;
    ArrayList<Item>myArray = null;
    int LayoutId;

    public MyarrayAdapter(Activity context, int LayoutId, ArrayList<Item> arr) {
        super(context, LayoutId, arr);
        this.context = context;
        this.LayoutId = LayoutId;
        this.myArray = arr;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(LayoutId, null);
        Item myItem = myArray.get(position);
        ImageView btnlike = convertView.findViewById(R.id.btnlike);
        int thich = myItem.getThich();
        if(thich==1){
            btnlike.setImageResource(R.drawable.heart_like);
        } else {
            btnlike.setImageResource(R.drawable.heart);
        }
        TextView tieude = convertView.findViewById(R.id.txttieude);
        tieude.setText(myItem.getTieude());
        TextView maso = convertView.findViewById(R.id.txtmaso);
        maso.setText(myItem.getMaso());
        return convertView;
    }
}
