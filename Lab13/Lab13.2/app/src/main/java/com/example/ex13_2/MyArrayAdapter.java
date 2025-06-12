package com.example.ex13_2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<phone> {
    Activity context;
    int idlayout;
    ArrayList<phone> mylist;

    public MyArrayAdapter(Activity context, int idlayout, ArrayList<phone> mylist) {
        super(context, idlayout, mylist);
        this.context = context;
        this.idlayout = idlayout;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myInflactor = context.getLayoutInflater();
        convertView = myInflactor.inflate(idlayout, null);
        phone myphone = mylist.get(position);
        ImageView imgphone = convertView.findViewById(R.id.imagePhone);
        imgphone.setImageResource(myphone.getImagephone());
        TextView txtmanephone = convertView.findViewById(R.id.txtNamephone);
        txtmanephone.setText(myphone.getNamephone());
        return convertView;
    }
}
