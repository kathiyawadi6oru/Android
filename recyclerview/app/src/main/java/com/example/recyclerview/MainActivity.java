package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
RecyclerAdapter recyclerAdapter;
List<String[]> myListData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =(RecyclerView)findViewById(R.id.recyclerView);

        myListData=new ArrayList<>();
        for(int i=0;i<100;i++){
            myListData.add(i, new String[]{"Gmail No - "+(i+1), "Subject is : "+(i+1)});
        }

        recyclerAdapter =new RecyclerAdapter(myListData);
       // recyclerView.setLayoutManager(new LinearLayoutManager(this));  assign in xml file or here
        DividerItemDecoration did= new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(did);
        recyclerView.setAdapter(recyclerAdapter);

    }
}