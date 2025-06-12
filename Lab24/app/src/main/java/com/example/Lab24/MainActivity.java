package com.example.ex223;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ListView lvTygia;
    TextView txtdate;
    ArrayList<Tygia> dstygia;
    MyArrayAdapter myadapter;
    @SuppressLint("MissingInflatedId")
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
        lvTygia = (ListView) findViewById(R.id.lv);
        txtdate = (TextView) findViewById(R.id.txtdate);
        getdate();
        dstygia = new ArrayList<Tygia>();
        myadapter = new MyArrayAdapter(MainActivity.this, R.layout.item, dstygia);
        lvTygia.setAdapter(myadapter);
    }

    private void getdate() {
        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat simpledate = new SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText("Hom nay: " + simpledate.format(currentDate));
    }
    class TyGiaTask extends AsyncTask<Void, Void, ArrayList<Tygia>>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            myadapter.clear();
        }

        @Override
        protected void onPostExecute(ArrayList<Tygia> tygias) {
            super.onPostExecute(tygias);
            myadapter.clear();
            myadapter.addAll(tygias);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<Tygia> doInBackground(Void... voids) {
            ArrayList<Tygia> ds = new ArrayList<Tygia>();
            try{
                URL url = new URL("http://dongabank.com.vn/exchange/export");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-type", "application/json; charset=utf-8");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible)");
                connection.setRequestProperty("Accept", "*/*");
                InputStream is = connection.getErrorStream();
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                BufferedReader br = new BufferedReader(isr);
                String line = br.readLine();
                StringBuilder builder = new StringBuilder();
                while(line!=null){
                    builder.append(line);
                    line = br.readLine();
                }
                String json = builder.toString();
                json = json.replace("(", "");
                json = json.replace("(", "");
                JSONObject jsonObject = new JSONObject(json);
                JSONArray jsonArray = jsonObject.getJSONArray("items");
                for(int i=0; i<jsonArray.length(); i++) {
                    JSONObject item = jsonArray.getJSONObject(i);
                    Tygia tygia = new Tygia();
                    tygia.setType(item.getString("type"));
                    if (item.has("imageurl")) {
                        tygia.setImageurl(item.getString("imageurl"));
                        url = new URL(tygia.getImageurl());
                        connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setRequestProperty("User-Agent", "Mozilla/5.0 ( compatible ) ");
                        connection.setRequestProperty("Accept", "*/*");
                        Bitmap bitmap = BitmapFactory.decodeStream(connection.getInputStream());
                        tygia.setBitmap(bitmap);
                    }
                    if (item.has("muatienmat")) {
                        tygia.setMuatienmat(item.getString("muatienmat"));
                    }
                    if (item.has("muack")) {
                        tygia.setMuack(item.getString("muack"));
                    }
                    if (item.has("bantienmat")) {
                        tygia.setMuatienmat(item.getString("bantienmat"));
                    }
                    if (item.has("banck")) {
                        tygia.setMuack(item.getString("banck"));
                    }
                    ds.add(tygia);
                }
                Log.d("JSON_DONGIA", json);
            }
            catch (Exception ex){
                Log.e("Loi", ex.toString());
            }
            return ds;
        }
    }
}