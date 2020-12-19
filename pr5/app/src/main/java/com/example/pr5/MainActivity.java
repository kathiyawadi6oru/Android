package com.example.pr5;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.os.Handler;
import android.os.Message;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.nio.file.OpenOption;
import java.util.Arrays;

import static com.example.pr5.R.layout.activity_main;
import static com.example.pr5.R.menu.custommenu;
import static com.example.pr5.R.menu.popup;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout c1;
    ProgressDialog progressDoalog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        c1 = (ConstraintLayout)findViewById(R.id.constraintLayout);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(custommenu,menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.bgcolor:{
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // Set a title for alert dialog
                builder.setTitle("Choose a background color...");

                // Initializing an array of colors
                final String[] colors = new String[]{
                        "Red",
                        "Green",
                        "Blue",
                        "Yellow",
                        "pink"
                };

                // Set the list of items for alert dialog
                builder.setItems(colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String selectedColor = Arrays.asList(colors).get(which);
                        // Set the layout background color as user selection
                        c1.setBackgroundColor(Color.parseColor(selectedColor));
                    }
                });

                AlertDialog dialog = builder.create();
                // Display the alert dialog on interface
                dialog.show();

                //popupmenu();
                return true;


            }
            case R.id.newactivity:{
                download();
                return true;
            }
            case R.id.calc:{
                Intent intent = new Intent(MainActivity.this,calc.class);
                startActivity(intent);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*public boolean popupmenu() {
        PopupMenu popup = new PopupMenu(this, c1);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.popup, popup.getMenu());
        popup.show();
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.red: {
                        c1.setBackgroundColor(Color.RED);
                        return true;

                    }
                    case R.id.blue: {
                        c1.setBackgroundColor(Color.BLUE);
                        return true;
                    }
                    case R.id.green: {
                        c1.setBackgroundColor(Color.GREEN);
                        return true;
                    }

                }
                return true;
            }
        });
        return true;
    }*/
    public void download() {
        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMax(100);
        progressDoalog.setTitle("Opening New Activity");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDoalog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (progressDoalog.getProgress() < progressDoalog
                            .getMax()) {
                        Thread.sleep(200);
                        handle.sendMessage(handle.obtainMessage());
                        if (progressDoalog.getProgress() == progressDoalog
                                .getMax()) {
                            progressDoalog.dismiss();
                            Intent intent = new Intent(MainActivity.this,newactivity.class);
                            startActivity(intent);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
    Handler handle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progressDoalog.incrementProgressBy(1);
        }
    };
}