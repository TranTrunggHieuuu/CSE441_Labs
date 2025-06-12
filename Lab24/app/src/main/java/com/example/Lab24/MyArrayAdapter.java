package com.example.ex223;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyArrayAdapter  extends ArrayAdapter<Tygia> {
    Activity context;
    int resource;
    List<Tygia> objects;

    public MyArrayAdapter(Activity context, int resource, List<Tygia> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View item = inflater.inflate(this.resource, null);
        Tygia tygia = this.objects.get(position);
        ImageView imgHinh = (ImageView) item.findViewById(R.id.imageView);
        TextView txtType = (TextView) item.findViewById(R.id.txtType);
        TextView txtMuaTM = (TextView) item.findViewById(R.id.txtMuaTM);
        TextView txtBanTM = (TextView) item.findViewById(R.id.txtBanCK);
        TextView txtMuaCK = (TextView) item.findViewById(R.id.txtMuaCK);
        TextView txtBanCK = (TextView) item.findViewById(R.id.txtBanCK);
        imgHinh.setImageBitmap(tygia.getBitmap());
        txtType.setText(tygia.getType());
        txtMuaTM.setText(tygia.getMuatienmat());
        txtBanTM.setText(tygia.getBantienmat());
        txtMuaCK.setText(tygia.getMuack());
        txtBanCK.setText(tygia.getBanck());
        return item;
    }
}
