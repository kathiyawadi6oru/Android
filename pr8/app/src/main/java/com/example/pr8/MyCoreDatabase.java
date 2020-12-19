package com.example.pr8;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class MyCoreDatabase extends SQLiteOpenHelper {
    static final private String DB_NAME = "mydatabase";
    static final private String TABLE_NAME = "STUDENT";
    static final private int DB_VERSION = 1;
    SQLiteDatabase myDB;
    Context mycontext;

    public MyCoreDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        mycontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ["+TABLE_NAME+"] (enroll integer NOT NULL PRIMARY KEY UNIQUE,ename text NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }

    public void myInsert(String enroll,String name){
        myDB = getWritableDatabase();
        myDB.execSQL("insert into "+TABLE_NAME+" values("+enroll+",'"+name+"')");
    }
    public void myUpdate(String enroll,String name){
        myDB = getWritableDatabase();
        myDB.execSQL("update  "+TABLE_NAME+" SET ename = '"+name+"' where enroll = "+enroll+"  ");
    }

    public void myDelete(String enroll){

        myDB = getWritableDatabase();
        myDB.execSQL("delete from "+TABLE_NAME+" where enroll = "+enroll+" ");

    }
    public ArrayList<String[]> getstudent(int enroll) {
        myDB = getReadableDatabase();
        ArrayList<String[]> mydata;
        mydata = new ArrayList<>();
        Cursor c;
        c = myDB.rawQuery("select * from " + TABLE_NAME + " where enroll ="+enroll+" ", null);
       /* if (enroll > 0) {
             c = myDB.rawQuery("select * from " + TABLE_NAME + " where enroll=" + enroll + "  ", null);

        }else{
            c = myDB.rawQuery("select * from " + TABLE_NAME + "", null);*/
        //if (c.getCount()!=0){
        if (c.moveToFirst()){
            String myTemp[] = new String[2];
            myTemp[0]=""+c.getInt(0);
            myTemp[1]=""+c.getString(1);
            mydata.add(myTemp);

        }else{
            Toast.makeText(mycontext, "not found", Toast.LENGTH_SHORT).show();
        }
        //return mydata;

        return mydata;
    }
    public ArrayList<String[]> getall() {
        myDB = getReadableDatabase();
        ArrayList<String[]> mydata;
        mydata = new ArrayList<>();
        Cursor c;
        c = myDB.rawQuery("select * from " + TABLE_NAME + "", null);
       /* if (enroll > 0) {
             c = myDB.rawQuery("select * from " + TABLE_NAME + " where enroll=" + enroll + "  ", null);

        }else{
            c = myDB.rawQuery("select * from " + TABLE_NAME + "", null);*/
        //if (c.getCount()!=0){
        while(c.moveToNext()){
            String myTemp[] = new String[2];
            myTemp[0]=""+c.getInt(0);
            myTemp[1]=c.getString(1);
            mydata.add(myTemp);

        }
        //else{
          //  Toast.makeText(mycontext, "not found", Toast.LENGTH_SHORT).show();

        return mydata;


    }
}


