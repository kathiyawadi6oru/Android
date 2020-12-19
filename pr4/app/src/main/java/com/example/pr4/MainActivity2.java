package com.example.pr4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView no,vno,name,vname,address,vaddress,city,vcity,gender,vgender,bdate,vbdate,cno,vcno,mail,vmail,course,vcourse,interest,vinterest,rating,vrating;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        vno = (TextView)findViewById(R.id.vno);
        vname = (TextView)findViewById(R.id.vname);
        vaddress = (TextView)findViewById(R.id.vaddress);
        vcity = (TextView)findViewById(R.id.vcity);
        vgender = (TextView)findViewById(R.id.vgender);
        vbdate=(TextView)findViewById(R.id.vbdate);
        vcno = (TextView)findViewById(R.id.vcno);
        vmail = (TextView)findViewById(R.id.vmail);
        vcourse = (TextView)findViewById(R.id.vcourse);
        vinterest = (TextView)findViewById(R.id.vinterest);
        vrating = (TextView)findViewById(R.id.vrating);
        button = (Button)findViewById(R.id.button);

        String no = getIntent().getStringExtra("no").toString();
        String name = getIntent().getStringExtra("name").toString();
        String address = getIntent().getStringExtra("address").toString();
        String city = getIntent().getStringExtra("city").toString();
        String gender = getIntent().getStringExtra("gender").toString();
        String cno = getIntent().getStringExtra("cno").toString();
        String mail = getIntent().getStringExtra("mail").toString();
        String intrest = getIntent().getStringExtra("intrest").toString();
        String rating = getIntent().getStringExtra("rating").toString();
        String course = getIntent().getStringExtra("course").toString();
        String bdate = getIntent().getStringExtra("bdate").toString();

        vno.setText(no);
        vname.setText(name);
        vaddress.setText(address);
        vcity.setText(city);
        vgender.setText(gender);
        vcno.setText(cno);
        vmail.setText(mail);
        vinterest.setText(intrest);
        vrating.setText(rating);
        vcourse.setText(course);
        vbdate.setText(bdate);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        AlertDialog.Builder a_Builder = new AlertDialog.Builder(MainActivity2.this);
        a_Builder.setMessage("do you want to close this app?").setCancelable(false).setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                finish();
                onDestroy();

            }
        })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alert = a_Builder.create();
        alert.setTitle("Alert!!!");
        alert.show();
    }
});
    }
}