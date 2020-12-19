package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tven,tvname,tvdetail;
    Button btnadd,btndelete,btnupdate,btnsearch;
    List<student> liststudent;
    CheckBox cbstatus;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         }

    @Override
    protected void onStart() {
        super.onStart();
        liststudent = new ArrayList<>(10);
        cbstatus=(CheckBox)findViewById(R.id.cbstatus);
        tven=(TextView)findViewById(R.id.tven);
        tvname=(TextView)findViewById(R.id.tvname);
        tvdetail=(TextView)findViewById(R.id.tvdetail);
        btnadd=(Button)findViewById(R.id.btnadd);
        btndelete=(Button)findViewById(R.id.btndelete);
        btnupdate=(Button)findViewById(R.id.btnupdate);
        btnsearch=(Button)findViewById(R.id.btnsearch);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                student std =new student();
                std.setEnroll(Integer.parseInt(tven.getText().toString()));
                std.setFullname(tvname.getText().toString());
                std.setStatus(cbstatus.isChecked());
                liststudent.add(std);
                displayall();
                resetfield();
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tveno = Integer.parseInt(tven.getText().toString());
                int flag=0;
                for (int i=0;i<liststudent.size();i++) {
                    student std = liststudent.get(i);
                    if (tveno == std.getEnroll()) {
                        liststudent.remove(i);
                        displayall();
                        resetfield();
                        flag=1;
                        break;

                    }
                }
                if (flag==0) {
                    Toast.makeText(MainActivity.this, "no record found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tveno = Integer.parseInt(tven.getText().toString());
                int flag=0;
                for (int i=0;i<liststudent.size();i++) {
                    student std = liststudent.get(i);
                    if (tveno == std.getEnroll()) {
                        liststudent.remove(i);
                        student stdtemp = new student();
                        stdtemp.setEnroll(Integer.parseInt(tven.getText().toString()));
                        stdtemp.setFullname(tvname.getText().toString());
                        stdtemp.setStatus(cbstatus.isChecked());
                        liststudent.add(i,stdtemp);
                        displayall();
                        resetfield();
                        flag=1;
                        break;

                    }
                }
                if (flag==0) {
                    Toast.makeText(MainActivity.this, "no record found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tveno = Integer.parseInt(tven.getText().toString());
                int flag=0;
                for (int i=0;i<liststudent.size();i++) {
                    student std = liststudent.get(i);
                    if (tveno == std.getEnroll()) {

                        tvname.setText(std.getFullname());
                        cbstatus.setChecked(std.isStatus());
                        flag=1;
                        break;
                    }
                }
                if (flag==0) {
                    Toast.makeText(MainActivity.this, "no record found", Toast.LENGTH_SHORT).show();
                    resetfield();
                }
            }
        });
    }
    private void displayall(){
        tvdetail.setText("");
        String temp="";
        for (int i=0;i<liststudent.size();i++){
            student std = liststudent.get(i);
            temp = temp+"no: "+std.getEnroll()+"  name: "+std.getFullname()+"  status: "+std.isStatus()+"\n";
            tvdetail.setText(temp);
        }
    }
    private void resetfield(){
        tven.setText("");
        tvname.setText("");
        cbstatus.setChecked(false);

    }
}