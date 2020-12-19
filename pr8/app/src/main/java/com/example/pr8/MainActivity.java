package com.example.pr8;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    Button btnfindone,btnall;
    Button btnAdd, btnDelete, btnUpdate;
    EditText edEnroll, edName;
    MyCoreDatabase md;
    TextView display;
    @Override
    protected void onStart() {
        super.onStart();
        btnall=(Button)findViewById(R.id.bfindall);
        btnfindone=(Button)findViewById(R.id.bfindenno);
        edEnroll = (EditText) findViewById(R.id.etno);
        edName = (EditText) findViewById(R.id.etname);
        btnAdd = (Button) findViewById(R.id.badd);
        btnUpdate = (Button) findViewById(R.id.bupdate);
        btnDelete = (Button) findViewById(R.id.bdelete);
        display=(TextView)findViewById(R.id.tvdisplay);
        md = new MyCoreDatabase(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                md.myInsert(edEnroll.getText().toString(), edName.getText().toString());
                Toast.makeText(MainActivity.this, "inserted", Toast.LENGTH_SHORT).show();
                reset();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                md.myUpdate(edEnroll.getText().toString(), edName.getText().toString());
                Toast.makeText(MainActivity.this, "updated", Toast.LENGTH_SHORT).show();
                reset();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                md.myDelete(edEnroll.getText().toString());
                Toast.makeText(MainActivity.this, "deleted", Toast.LENGTH_SHORT).show();
                reset();
            }
        });
        btnfindone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String[]> mydata = md.getstudent(Integer.parseInt(edEnroll.getText().toString().trim()));
                if (mydata.size()>0){
                    String myTempStudent[] = mydata.get(0);
                    edEnroll.setText(myTempStudent[0]);
                    edName.setText(myTempStudent[1]);
                }else {
                    Toast.makeText(MainActivity.this, "sorry no record found", Toast.LENGTH_SHORT).show();
                    reset();
                }
            }
        });

        btnall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String[] myTempStudent;
                ArrayList<String[]> mydata = md.getall();
                if (mydata.size() > 0){
                    String tempAllStudent ="";
                    display.setText("");
                    for (int i=0;i < mydata.size();i++){
                        String myTempStudent[] = mydata.get(i);
                        tempAllStudent=tempAllStudent+"\n"+myTempStudent[0] + " : "+myTempStudent[1];
                    }
                    display.setText(tempAllStudent);
                  //  myTempStudent = (String[]) mydata.get(0);
                    //display.setText(""+myTempStudent[0]+"  "+myTempStudent[1]);

                    // display.setText((CharSequence) mydata);
                }else {
                    Toast.makeText(MainActivity.this, "sorry no record found", Toast.LENGTH_SHORT).show();
                    reset();

                }
            }
        });

    }
        public void reset(){
            edEnroll.setText("");
            edName.setText("");
        }

}