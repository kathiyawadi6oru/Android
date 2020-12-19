package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ConstraintLayout c1;
TextView tv,tv2;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c1 = (ConstraintLayout)findViewById(R.id.constraintLayout);
        tv = (TextView)findViewById(R.id.tv);
        tv2 = (TextView)findViewById(R.id.tv2);
        registerForContextMenu(tv);
    tv2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                PopupMenu popup = new PopupMenu(getApplicationContext(), view);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.popup, popup.getMenu());
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.red: {
                                tv2.setTextColor(Color.RED);
                                displayMsg("red is selected.");
                                return true;

                            }
                            case R.id.blue: {
                                tv2.setTextColor(Color.BLUE);
                                displayMsg("blue is selectced.");
                                return true;
                            }
                            case R.id.green: {
                                tv2.setTextColor(Color.GREEN);
                                displayMsg("green is selected.");
                                return true;
                            }

                        }
                        return true;
                    }
                });
        }
    });
}




    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.red: {
                tv.setTextColor(Color.RED);
                displayMsg("red is selected.");
                return true;
            }
            case R.id.blue: {
                tv.setTextColor(Color.BLUE);
                displayMsg("blue is selectced.");
                return true;
            }
            case R.id.green: {
                tv.setTextColor(Color.GREEN);
                displayMsg("green is selected.");
                return true;
            }

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v,menuInfo);
        getMenuInflater().inflate(R.menu.contextmenutv,menu);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custommenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.red:{
                c1.setBackgroundColor(Color.RED);
                displayMsg("red is selected.");
                return true;
            }
            case R.id.blue:{
                c1.setBackgroundColor(Color.BLUE);
                displayMsg("blue is selectced.");
                return true;
            }
            case R.id.green:{
                c1.setBackgroundColor(Color.GREEN);
                displayMsg("green is selected.");
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void displayMsg(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}