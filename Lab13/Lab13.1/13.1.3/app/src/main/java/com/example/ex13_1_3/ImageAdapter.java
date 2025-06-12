package com.example.ex13_1_3;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private Integer []Anh;

    public ImageAdapter(Context context) {
        this.context = context;
    }

    public ImageAdapter(Context context, Integer[] anh) {
        this.context = context;
        Anh = anh;
    }

    @Override
    public int getCount() {
        return Anh.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgView;
        if(convertView == null){
            imgView = new ImageView(context);
            imgView.setLayoutParams(new ViewGroup.LayoutParams(85, 85));
            imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgView.setPadding(8, 8, 8, 8);
        }
        else {
            imgView = (ImageView) convertView;
        }
        imgView.setImageResource(Anh[position]);
        return imgView;
    }
}