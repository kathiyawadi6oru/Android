package com.example.pr6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
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
                            case R.id.listdemo: {
                                Intent intent=new Intent(MainActivity.this,listdemo.class);
                                startActivity(intent);
                                return true;

                            }
                            case R.id.customadapter: {
                                Intent intent=new Intent(MainActivity.this,customadapter.class);
                                startActivity(intent);

                                return true;
                            }
                            case R.id.recycleview: {
                                Intent intent=new Intent(MainActivity.this,recyclerview.class);
                                startActivity(intent);
                                return true;
                            }

                        }
                        return true;
                    }
                });
            }
        });
    }

}

