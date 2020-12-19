package com.example.pr10;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCoreDatabase extends SQLiteOpenHelper {
    static final private String DB_NAME = "mydatabase";
    static final private String TABLE_NAME = "stud";
    static final private int DB_VERSION = 1;
    SQLiteDatabase myDB;
    Context mycontext;

    public MyCoreDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (stud_id INTEGER PRIMARY KEY NOT NULL,stud_name TEXT NOT NULL,stud_semester TEXT NOT NULL,stud_course TEXT NOT NULL,gender TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

    public void myInsert(int id, String name, String semester, String course, String gender) {
        myDB = getWritableDatabase();
        myDB.execSQL("insert into " + TABLE_NAME + " values(" + id + ",'" + name + "'," + semester + ",'" + course + "','" + gender + "')");
    }
    public void myupdate(int id, String name, String semester, String course, String gender){
        myDB = getWritableDatabase();
        myDB.execSQL("update "+TABLE_NAME+" SET stud_name='"+name+"',stud_semester="+semester+",stud_course='"+course+"',gender='"+gender+"' where stud_id="+id+" ");
    }

    public void mydelete(int id){
        myDB = getWritableDatabase();
        myDB.execSQL("delete from "+TABLE_NAME+" where stud_id="+id+" ");
    }

    public ArrayList<String[]> getstudent(int id) {
        myDB = getReadableDatabase();
        ArrayList<String[]> mydata;
        mydata = new ArrayList<>();
        Cursor c;
        c = myDB.rawQuery("select * from " + TABLE_NAME + " where stud_id ="+id+" ", null);
       /* if (enroll > 0) {
             c = myDB.rawQuery("select * from " + TABLE_NAME + " where enroll=" + enroll + "  ", null);

        }else{
            c = myDB.rawQuery("select * from " + TABLE_NAME + "", null);*/
        //if (c.getCount()!=0){
        if (c.moveToFirst()){
            String myTemp[] = new String[5];
            myTemp[0]=""+c.getInt(0);
            myTemp[1]=c.getString(1);
            myTemp[2]=""+c.getInt(2);
            myTemp[3]=c.getString(3);
            myTemp[4]=c.getString(4);
            mydata.add(myTemp);

        }else{
            Toast.makeText(mycontext, "not found", Toast.LENGTH_SHORT).show();
        }
        //return mydata;

        return mydata;
    }

}

