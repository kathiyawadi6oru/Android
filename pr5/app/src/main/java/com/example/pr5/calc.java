package com.example.pr5;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class calc extends AppCompatActivity {
TextView et1,et2,textView;
Button button;
CharacterPickerDialog cpd=null;
String operator = "+-*/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
    et1=(TextView)findViewById(R.id.et1);
    et2=(TextView)findViewById(R.id.et2);
    textView=(TextView)findViewById(R.id.textView);
    button=(Button)findViewById(R.id.button);

    button.setOnClickListener(new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onClick(View v) {
            cpd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            cpd.show();
            /*int num1 = Integer.parseInt(et1.getText().toString());
            int num2 = Integer.parseInt(et2.getText().toString());
            int ans = num1+num2;
            textView.setText(Integer.toString(ans));*/

        }
    });

    cpd = new CharacterPickerDialog(this,new View(this),null,operator,false){
      public void onClick(View v){
          int num1 = Integer.parseInt(et1.getText().toString());
          int num2 = Integer.parseInt(et2.getText().toString());
          String c= ((Button)v).getText().toString();
         if (c.equals("+")){
             int sum = num1 + num2;
             textView.setText("addition == "+sum);
         }else if (c.equals("-")){
             int sub = num1 - num2;
             textView.setText("substrection == "+sub);
         }else if (c.equals("*")){
             int mul = num1 * num2;
             textView.setText("multiplication == "+mul);
         }else if(c.equals("/")) {
             int div = num1 / num2;
             textView.setText("divition == "+div);
         }else {
             textView.setText("Please Select anyone operater...");
         }



             /*
         switch (num1 != num2){
             case c == "+":
                 int sum = num1 + num2;
                 textView.setText(sum);

         }*/

         // String ans = num1+c+num2;
          //textView.setText(ans);
          //Toast.makeText(getApplicationContext(),ans,Toast.LENGTH_SHORT).show();
          dismiss();
      }


    };
    }
}