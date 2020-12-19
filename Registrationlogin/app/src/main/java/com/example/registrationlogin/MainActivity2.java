package com.example.registrationlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView tuser,tpass;
    EditText euser,epass;
    Button blogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginbutton();
        String name = getIntent().getStringExtra("name").toString();
    }
    public void loginbutton(){
        euser = (EditText)findViewById(R.id.etuser);
        epass = (EditText)findViewById(R.id.etpass);
        blogin = (Button)findViewById(R.id.btnlogin);
        String name = getIntent().getStringExtra("name").toString();
        String city = getIntent().getStringExtra("city").toString();
        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(euser.getText().toString().equals(name)&&epass.getText().toString().equals(city)){
                    Toast.makeText(getApplicationContext(),"username and password are correct",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
                    intent.putExtra("username",euser.getText().toString());
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"username or password are incorrect",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}