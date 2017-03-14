package com.swift.nhat.myexercise.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.swift.nhat.myexercise.Model.TiGia;
import com.swift.nhat.myexercise.R;

import java.util.List;

/**
 * Created by nhat on 3/14/17.
 */

public class TiGiaApdapter extends ArrayAdapter<TiGia> {
        Context context;
        int layoutResourceId;
        TiGia data[]=null;

        public TiGiaApdapter(Context context,int layoutResourceId,TiGia []data){
                super(context,layoutResourceId,data);
                this.layoutResourceId=layoutResourceId;
                this.context=context;
                this.data=data;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
                View row=convertView;
                PlaceHoder holder=null;

                if(row==null)
                {
                    LayoutInflater inflater=((Activity)context).getLayoutInflater();
                    row=inflater.inflate(layoutResourceId,parent,false);

                    holder=new PlaceHoder();
                    holder.txtName=(TextView)row.findViewById(R.id.tenTiGia);
                    holder.txtValue=(TextView)row.findViewById(R.id.giaTriTiGia);

                    row.setTag(holder);
                }
                else
                {
                    holder=(PlaceHoder)row.getTag();
                }

                TiGia d=data[position];
                holder.txtName.setText(d.getName());
                holder.txtValue.setText(String.valueOf(d.getValue()));

                return row;
        }

        static class PlaceHoder {
            TextView txtName;
            TextView txtValue;
        }

}