package com.example.pr10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText edid,edname;
Spinner ssem,scourse;
RadioButton rmale,rfemale;
Button badd,bupdate,bdelete,bsearch;
MyCoreDatabase md;
String selectsem,selectcourse;
RadioGroup radioGroup;
RadioButton rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edid=(EditText)findViewById(R.id.etid);
        edname=(EditText)findViewById(R.id.etname);
        ssem=(Spinner)findViewById(R.id.spinnersem);
        scourse=(Spinner)findViewById(R.id.spinnercourse);
        rmale=(RadioButton)findViewById(R.id.rbmale);
        rfemale=(RadioButton)findViewById(R.id.rbfemale);
        radioGroup = (RadioGroup)findViewById(R.id.rbgroup);
        badd=(Button)findViewById(R.id.badd);
        bupdate=(Button)findViewById(R.id.bupdate);
        bdelete=(Button)findViewById(R.id.bdelete);
        bsearch=(Button)findViewById(R.id.bsearch);
        md = new MyCoreDatabase(this);

        ssem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectsem = adapterView.getItemAtPosition(i).toString();
                // tvcourse.setText(select);
                //Toast.makeText(MainActivity.this,"selected==="+adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                 Toast.makeText(MainActivity.this,"please select semester", Toast.LENGTH_SHORT).show();

            }
        });

        scourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectcourse = adapterView.getItemAtPosition(i).toString();
                // tvcourse.setText(select);
                //Toast.makeText(MainActivity.this,"selected==="+adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                 Toast.makeText(MainActivity.this,"please select course", Toast.LENGTH_SHORT).show();

            }
        });


        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int select_id = radioGroup.getCheckedRadioButtonId();
                rb = (RadioButton)findViewById(select_id);
                md.myInsert(Integer.parseInt(edid.getText().toString()),edname.getText().toString(),selectsem,selectcourse,rb.getText().toString());
                reset();
            }
        });


        bupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int select_id = radioGroup.getCheckedRadioButtonId();
                rb = (RadioButton)findViewById(select_id);
                md.myupdate(Integer.parseInt(edid.getText().toString()),edname.getText().toString(),selectsem,selectcourse,rb.getText().toString());
                reset();
            }
        });

        bdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                md.mydelete(Integer.parseInt(edid.getText().toString()));
                reset();
            }
        });

        bsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String[]> mydata = md.getstudent(Integer.parseInt(edid.getText().toString().trim()));
                if (mydata.size()>0){

                    String myTempStudent[] = mydata.get(0);
                    edid.setText(myTempStudent[0]);
                    edname.setText(myTempStudent[1]);
                    //rb.isChecked();

                    ssem.setSelection(Integer.parseInt(myTempStudent[2]));
                    String compareValue=myTempStudent[3];
                    //noinspection rawtypes
/*                    int pos = scourse.getAdapter().indexOf(myTempStudent[3]);
                    scourse.setSelection(pos);*/
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.courses,R.layout.support_simple_spinner_dropdown_item);
                    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                    scourse.setAdapter(adapter);

                    if (compareValue != null){
                        int spinnerposition=adapter.getPosition(compareValue);
                        scourse.setSelection(spinnerposition);
                    }
                   if (myTempStudent[4].equals(rmale.getText().toString())){
                       rmale.setChecked(true);
                   }else{
                       rfemale.setChecked(true);
                   }
                    // scourse.setSelection(Integer.parseInt(myTempStudent[3]));
                    //scourse.setSelection(Integer.parseInt((String) as));
                    //rb.setSelected(Boolean.parseBoolean(myTempStudent[4]));
                    //rb.setChecked(Boolean.parseBoolean(myTempStudent[5]));
                }else {
                    Toast.makeText(MainActivity.this, "sorry no record found", Toast.LENGTH_SHORT).show();
                    reset();
                }
            }
        });

    }
    public void reset(){
        edid.setText("");
        edname.setText("");
        ssem.setSelection(0);
        scourse.setSelection(0);
       // ssem.clearFocus();
       // scourse.childDrawableStateChanged(ssem);
        radioGroup.clearCheck();

    }
}