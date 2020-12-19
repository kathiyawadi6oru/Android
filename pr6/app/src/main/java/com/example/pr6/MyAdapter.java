package com.example.pr6;

import android.app.Activity;
import android.content.Context;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MyData> arrayList;
    private TextView name, message, rating;
    
    Button button;
    public MyAdapter(Context context, ArrayList<MyData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        View row = inflater.inflate(R.layout.row,parent,false);
        name = row.findViewById(R.id.name);
        message = row.findViewById(R.id.message);
        rating = row.findViewById(R.id.rating);

/*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb.isChecked()){
                    Toast.makeText(context, "checked", Toast.LENGTH_SHORT).show();
                }
            }
        });
*/
        name.setText(arrayList.get(position).getname());
        message.setText(arrayList.get(position).getmessage());
        rating.setText(arrayList.get(position).getRating());
        return row;
    }
    public void removeitem(List<MyData> items){
        for (MyData item : items){
            arrayList.remove(item);
        }
        notifyDataSetChanged();
    }



    /*public void Selectall(){
        int c=arrayList.size();
        if (int i=0;i<c;i++){
            arrayList.
        }*/

    }

