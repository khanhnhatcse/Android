package com.swift.nhat.myexercise;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ConvertActivity extends AppCompatActivity {


    String [] currencys ;
    float [] currencys_values ;
    int input_cur, output_cur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        if(savedInstanceState != null ) {
            currencys = (String[]) savedInstanceState.get("currencys");
            currencys_values = (float[]) savedInstanceState.get("currencys_value");
        }else{
            currencys = new String[] {"USD - US Dollar", "VND - Viet Nam Dong", "EUR - Euro", "GBP - British Pound","INR - Indian Rupee", "AUD - Australian Dollar","CAD - Canadian Dollar"};
            currencys_values = new float[] {22000, 1, 24000, 29000,350, 18000,17000};
        }
        setupData();

    }

    private void setupData(){
        Spinner dropdown1 = (Spinner) findViewById(R.id.spinner_tiente);
        Spinner dropdown2 = (Spinner) findViewById(R.id.spinner_tiente1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, currencys );
        dropdown1.setAdapter(adapter);
        dropdown2.setAdapter(adapter);

        dropdown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ConvertActivity.this, currencys[position].toString(), Toast.LENGTH_SHORT).show();
                input_cur = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                input_cur = 0;
            }
        });
        dropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ConvertActivity.this, currencys[position].toString(), Toast.LENGTH_SHORT).show();
                output_cur = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                output_cur = 0;
            }
        });
    }

    private String format(float value){
        return String.format("%.2f", value);
    }

    public void onConvert(View view ){
        TextView input = (TextView) findViewById(R.id.input_currency);
        TextView output = (TextView) findViewById(R.id.out_currency);
        if(input.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Nhập vào số tiền", Toast.LENGTH_SHORT).show();

        }else{
            float number = Float.valueOf(input.getText().toString());
            float result = (number * currencys_values[input_cur]) / currencys_values[output_cur];
            output.setText(format(result));
        }

    }
}
