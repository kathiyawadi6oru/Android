package com.example.registrationlogin;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Calendar;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    TextView tvheader,tvno,tvname,tvaddress,tvcity,tvgender,tvbdate,tvselectbdate,tvcno,tvmail,tvcourse,tvinterest,tvrating,tvtoggle;
    Button submit;
    EditText etno,etname,etaddress,etcity,etcno,etmail;
    RadioButton rb;
    RadioGroup radioGroup;
    Spinner spinner;
    CheckBox cbdesign,cbdevlop,cbandroid,cbios;
    RatingBar ratingBar;
    ToggleButton toggleButton;
    float rate;
    String select;
    Context context;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etno = (EditText) findViewById(R.id.etno);
        etname = (EditText) findViewById(R.id.etname);
        etaddress = (EditText) findViewById(R.id.etaddress);
        etcity = (EditText) findViewById(R.id.etcity);
        etcno = (EditText) findViewById(R.id.etcno);
        etmail = (EditText) findViewById(R.id.etmail);
        radioGroup = (RadioGroup)findViewById(R.id.rbgoup);
        spinner = (Spinner)findViewById(R.id.spinner);
        cbandroid = (CheckBox)findViewById(R.id.cbandroid);
        cbios = (CheckBox)findViewById(R.id.cbios);
        cbdesign = (CheckBox)findViewById(R.id.cbwebdesigning);
        cbdevlop = (CheckBox)findViewById(R.id.cbwebdevlopment);
        tvselectbdate = (TextView)findViewById(R.id.tvselectbdate);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        changestatusofcontrol(View.INVISIBLE);
        toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        submit = (Button)findViewById(R.id.bsubmit);
        tvcourse = (TextView)findViewById(R.id.tvcourse);

        //course =(String[])findViewById(R.array[course]);
        //toggleButton.setChecked(false);
        context=this;
        tvselectbdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        tvselectbdate.setText(i2+"/"+i1+"/"+i);
                    }
                },1999,10,02);
                datePickerDialog.show();
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                select = adapterView.getItemAtPosition(i).toString();
                // tvcourse.setText(select);
                //Toast.makeText(MainActivity.this,"selected==="+adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Toast.makeText(MainActivity.this,"please select", LENGTH_SHORT).show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int select_id = radioGroup.getCheckedRadioButtonId();
                rb = (RadioButton)findViewById(select_id);
                StringBuffer result = new StringBuffer();
                result.append("\n android : ").append(cbandroid.isChecked());
                result.append("\n ios : ").append(cbios.isChecked());
                result.append("\n web devloapment : ").append(cbdevlop.isChecked());
                result.append("\n web designing : ").append(cbdesign.isChecked());

                ratingBar.setOnRatingBarChangeListener(
                        new RatingBar.OnRatingBarChangeListener() {
                            @Override
                            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                                rate = ratingBar.getRating();
                            }
                        }
                );

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("no",etno.getText().toString());
                intent.putExtra("name",etname.getText().toString());
                intent.putExtra("address",etaddress.getText().toString());
                intent.putExtra("city",etcity.getText().toString());
                intent.putExtra("gender",rb.getText().toString());
                intent.putExtra("cno",etcno.getText().toString());
                intent.putExtra("mail",etmail.getText().toString());
                intent.putExtra("intrest",result.toString());
                Intent rating = intent.putExtra("rating", String.valueOf(rate));
                intent.putExtra("course",select);
                intent.putExtra("bdate",tvselectbdate.getText().toString());
                startActivity(intent);
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) changestatusofcontrol(View.VISIBLE);
                else changestatusofcontrol(View.INVISIBLE);
            }
        });


    }

    private void changestatusofcontrol(int MYVISIBILITY) {
        //tvcourse.setVisibility(MYVISIBILITY);
        spinner.setVisibility(MYVISIBILITY);
        // tvinterest.setVisibility(MYVISIBILITY);
        cbios.setVisibility(MYVISIBILITY);
        cbdevlop.setVisibility(MYVISIBILITY);
        cbdesign.setVisibility(MYVISIBILITY);
        cbandroid.setVisibility(MYVISIBILITY);
    }
}