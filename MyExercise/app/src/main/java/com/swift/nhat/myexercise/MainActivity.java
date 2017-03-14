package com.swift.nhat.myexercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.swift.nhat.myexercise.Adapter.TiGiaApdapter;
import com.swift.nhat.myexercise.Model.TiGia;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fill();
    }

    public void fill(){
        TiGia tiGia[] = new TiGia[]{
                new TiGia(1, "USD", 22000),
                new TiGia(2, "Rup" , 10000),
                new TiGia(3, "NNT", 1000)
        };
        ListView listView = (ListView) findViewById(R.id.lvTiGia);
        TiGiaApdapter tiGiaApdapter = new TiGiaApdapter(this, R.layout.layout_tigia, tiGia);
        listView.setAdapter(tiGiaApdapter);

    }

    public void convertMoney(View view){

        startActivity(new Intent(this,convert.class));

    }
}
