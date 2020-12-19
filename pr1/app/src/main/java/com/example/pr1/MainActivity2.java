package com.example.pr1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = (TextView)findViewById(R.id.textView);
        String un = getIntent().getStringExtra("username");
        textView.setText(un+" sucessfully login");

    }
}