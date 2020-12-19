package com.example.pr2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView label;
    EditText editText;
    Button submit;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    label = (TextView)findViewById(R.id.textView);
    editText = (EditText)findViewById(R.id.etemail);
    submit = (Button)findViewById(R.id.bsubmit);

    submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (editText.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"enter email address",Toast.LENGTH_SHORT).show();
            }else{
                if (editText.getText().toString().trim().matches(emailPattern)){
                    Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
                }else{
                    submit.setEnabled(false);
                }
            }
        }
    });
    }

}

