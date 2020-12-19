package com.example.pr7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button b1,bupdate,bdelete,bsearch;
    TextView textView;

    public static final String MyPREFERENCES = "MyPref" ;
    public static final String Name = "name";
    public static final String city = "city";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        textView=(TextView)findViewById(R.id.textView);
        bupdate=(Button)findViewById(R.id.bupdate);
        bdelete=(Button)findViewById(R.id.bdelete);
        bsearch=(Button)findViewById(R.id.bsearch);
        b1=(Button)findViewById(R.id.button);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        textView.setText("Name : "+sharedpreferences.getString("name","no name")+"    city : "+sharedpreferences.getString("city","no city"));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Name, ed1.getText().toString());
                editor.putString(city, ed2.getText().toString());
                editor.apply();
                Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();
                textView.setText("Name : "+sharedpreferences.getString("name","no name")+"    city : "+sharedpreferences.getString("city","no city"));
            }
        });
        bupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1.getText().toString().equals(sharedpreferences.getString("name", ""))) {
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(Name, ed1.getText().toString());
                    editor.putString(city, ed2.getText().toString());
                    editor.apply();
                    Toast.makeText(MainActivity.this, "updated", Toast.LENGTH_LONG).show();
                    textView.setText("Name : " + sharedpreferences.getString("name", "no name") + "    city : " + sharedpreferences.getString("city", "no city"));
                }else{
                    Toast.makeText(MainActivity.this, "not found", Toast.LENGTH_LONG).show();
                }
            }
        });
        bdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.remove("name");
                //edit.putString("username","");
                editor.remove("city");
                // edit.putString("password","");

                editor.commit();
                Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();
                textView.setText("Name : "+sharedpreferences.getString("name","no name")+"    city : "+sharedpreferences.getString("city","no city"));
            }
        });
        bsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1.getText().toString().equals(sharedpreferences.getString("name",""))) {
                    ed1.setText(sharedpreferences.getString("name", ""));
                    ed2.setText(sharedpreferences.getString("city", ""));
                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    editor.putString(Name, ed1.getText().toString());
                    editor.putString(city, ed2.getText().toString());
                    editor.apply();
                }else {
                    ed1.setText("");
                    ed2.setText("");
                    Toast.makeText(MainActivity.this,"not found",Toast.LENGTH_LONG).show();
                }
                //Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();
                textView.setText("Name : "+sharedpreferences.getString("name","no name")+"    city : "+sharedpreferences.getString("city","no city"));
            }
        });
    }

}