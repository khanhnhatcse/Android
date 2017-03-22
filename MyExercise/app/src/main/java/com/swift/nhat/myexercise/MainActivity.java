package com.swift.nhat.myexercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.swift.nhat.myexercise.Adapter.TiGiaApdapter;
import com.swift.nhat.myexercise.Model.TiGia;

public class MainActivity extends AppCompatActivity {

    private String [] currencys = new String[] {"USD - US Dollar", "VND - Viet Nam Dong", "EUR - Euro", "GBP - British Pound","INR - Indian Rupee", "AUD - Australian Dollar","CAD - Canadian Dollar"};
    private float [] currencys_values = new float[] {22000, 1, 24000, 29000,350, 18000,17000};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fill();
    }


    private String format(float value){
        return String.format("%.2f", value);
    }
    public void fill(){
        // Offline




        TiGia tiGia[] = new TiGia[currencys.length];
        for(int i = 0; i < currencys.length;i++){
            tiGia[i] = new TiGia(i + 1, currencys[i], currencys_values[i]);
        }

        ListView listView = (ListView) findViewById(R.id.lvTiGia);
        TiGiaApdapter tiGiaApdapter = new TiGiaApdapter(this, R.layout.layout_tigia, tiGia);
        listView.setAdapter(tiGiaApdapter);

    }

    public void convertMoney(View view){

        Intent intent = new Intent(this,ConvertActivity.class);
        intent.putExtra("currencys", currencys);
        intent.putExtra("currencys_value", currencys_values);
        startActivity(new Intent(this,ConvertActivity.class));

    }
}
