package com.example.pr3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.*;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    Button bsize,bcolor,bimage;
    TextView textView,tvdate,tvtime;
    ImageView imageView;
    private int current_img_index;
    int [] images ={R.drawable.img1,R.drawable.ty};
    private int current_tv_color;
    int [] color = {Color.RED,Color.GREEN,Color.BLUE};
    private int current_tv_size;
    int [] size = {10,30,50};
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bcolor = (Button)findViewById(R.id.btextcolor);
        bimage = (Button)findViewById(R.id.bimage);
        bsize = (Button)findViewById(R.id.bfontsize);
        textView = (TextView)findViewById(R.id.textView);
        imageView = (ImageView)findViewById(R.id.imageView);
        tvdate = (TextView)findViewById(R.id.tvdate);
        tvtime = (TextView)findViewById(R.id.tvtime);
        context = this;

        bcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current_tv_color++;
                current_tv_color = current_tv_color % color.length;
                textView.setTextColor(color[current_tv_color]);
            }
        });
        bimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current_img_index++;
                current_img_index = current_img_index % images.length;
                imageView.setImageResource(images[current_img_index]);
            }

        });

        bsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current_tv_size++;
                current_tv_size = current_tv_size % size.length;
                textView.setTextSize(size[current_tv_size]);
            }
        });


        tvdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        tvdate.setText(i+"/"+i1+"/"+i2);
                    }
                },1990,10,21);
                datePickerDialog.show();
            }
        });
        SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd");
        String currentDate = sf.format(new Date());
        tvdate.setText(currentDate);
        SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
        String currentTime = sd.format(new Date());
        tvtime.setText(currentTime);
       tvtime.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               TimePickerDialog timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                   @Override
                   public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        tvtime.setText(i+":"+i1);
                   }
               },9,39,false);
               timePickerDialog.show();
           }
       });

    }

}
