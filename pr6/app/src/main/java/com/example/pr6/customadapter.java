package com.example.pr6;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.os.IResultReceiver;
import android.text.style.BackgroundColorSpan;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class customadapter extends AppCompatActivity {
    ListView listView;
    ArrayList<MyData> arrayList = new ArrayList<>();
    MyAdapter adapter;

    Button delete,selectall;
    List<MyData> userselection=new ArrayList<MyData>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customadapter);
        delete=(Button)findViewById(R.id.delete);
        selectall=(Button)findViewById(R.id.selectall);
        listView = findViewById(R.id.list);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(modeListener);

       // listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        //listView.setMultiChoiceModeListener(modeListener);
        arrayList.add(new MyData("mayank", " stud 1","9"));
        arrayList.add(new MyData("keyur", " stud 2","8"));
        arrayList.add(new MyData("maybhgfrtur", " stud 3","6"));
        arrayList.add(new MyData("mhbayur", " stud 4","6"));
        arrayList.add(new MyData("mur", " stud 5","3"));
        arrayList.add(new MyData("yur", " stud 6","2"));
        arrayList.add(new MyData("maur", " stud 7","4"));


        adapter = new MyAdapter(this, arrayList);
        listView.setAdapter(adapter);




    }

    //String[] items = getResources().getStringArray(listView);
    final AbsListView.MultiChoiceModeListener modeListener = new AbsListView.MultiChoiceModeListener() {
        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

           /* switch (){
                case userselection.contains(arrayList.get(position)):
                    if (userselection.contains(arrayList.get(position))) {

                        //userselection.containsAll(arrayList.addAll(mode));
                        userselection.remove(arrayList.get(position));

                    } else {
                        userselection.add(arrayList.get(position));
                    }
                    mode.setTitle(userselection.size() + " item selected.");
                case userselection.containsAll(arrayList):
                    if (userselection.containsAll(arrayList)) {
                        userselection.removeAll(arrayList);
                    } else {
                        userselection.addAll(arrayList);
                    }
                    mode.setTitle(userselection.size() + " all item selected.");
           }*/


            if (userselection.contains(arrayList.get(position))) {

                //userselection.containsAll(arrayList.addAll(mode));
                userselection.remove(arrayList.get(position));


            } else {
                userselection.add(arrayList.get(position));
            }
            mode.setTitle(userselection.size() + " item selected.");

            /*selectall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });*/
/*
                if (userselection.containsAll(arrayList)) {
                    userselection.removeAll(arrayList);
                } else {
                    userselection.addAll(arrayList);
                }
                mode.setTitle(userselection.size() + " all item selected.");

*/


        }



        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater menuInflater = mode.getMenuInflater();
            menuInflater.inflate(R.menu.context_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.delete:
                    adapter.removeitem(userselection);
                    mode.finish();
                    return true;
                case R.id.selectall:
                    userselection.clear();
                    userselection.addAll(arrayList);
                    mode.setTitle(userselection.size() + " item selected.");
                    //userselection.contains(arrayList);
                    return true;
                default:
                    return false;
            }

        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            userselection.clear();
        }
    };
    /*public void selectall(List<MyData> userselection, ActionMode mode) {
        if (userselection.containsAll(arrayList)) {
            userselection.removeAll(arrayList);
        } else {
            userselection.addAll(arrayList);
        }
        mode.setTitle(userselection.size() + " all item selected.");
    }*/
}
