package com.example.myproject;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class myDbAdapter {
    myDbHelper myhelper;
    myDbHelper2 myhelper2;


    public myDbAdapter(Context context) {
        myhelper = new myDbHelper(context);
        myhelper2=new myDbHelper2(context);
    }

    public long insertData(String name,String namee) {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME,namee);
        contentValues.put(myDbHelper.EMAIL, name);

        long id = dbb.insert(myDbHelper.TABLE_NAME, null, contentValues);
        return id;
    }



    public int getData(String email) {
        SQLiteDatabase MyDB = myhelper.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from myTable where email = ?", new String[]{email});
        if (cursor.getCount() > 0)
            return 1;
        else
            return 0;
    }
    public String getNamee(String email){
        String ss1="";
        SQLiteDatabase MyDB = myhelper.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select name from myTable where email = ?", new String[]{email});
        while (cursor.moveToNext()){
            ss1=cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
        }
        return (ss1);
    }
    public long insertt(String moviee, String user){
        String uid="";
        SQLiteDatabase db=myhelper.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select _id from myTable where email =?",new String[]{user});
        while (cursor.moveToNext()){
            uid=cursor.getString(cursor.getColumnIndex(myDbHelper.UID));
        }
        SQLiteDatabase dbb = myhelper2.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy ");
        String currentDateAndTime = sdf.format(new Date());
        contentValues.put(myDbHelper2.UID,uid);
        contentValues.put(myDbHelper2.MOVIE, moviee);
        contentValues.put(myDbHelper2.DATE,currentDateAndTime);
        long id = dbb.insert(myDbHelper2.TABLE_NAME, null , contentValues);
        return (id);

    }
    public String gett(String user){
        String uid="";
        StringBuffer mov=new StringBuffer();
        String movv="";
        String dat="";
        SQLiteDatabase db=myhelper.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select _id from myTable where email =?",new String[]{user});
        while (cursor.moveToNext()){
            uid=cursor.getString(cursor.getColumnIndex(myDbHelper.UID));
        }
        SQLiteDatabase dbb = myhelper2.getWritableDatabase();
        Cursor cursor1=dbb.rawQuery("Select * from myTablee where uid =?",new String[]{uid});
        while (cursor1.moveToNext()){
            movv=cursor1.getString(cursor1.getColumnIndex(myDbHelper2.MOVIE));
            dat=cursor1.getString(cursor1.getColumnIndex(myDbHelper2.DATE));
            mov.append(movv+" {"+dat+"}\n");

        }
        return (mov.toString());
    }

    static class myDbHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "myDatabase"; // Database Name
        private static final String TABLE_NAME = "myTable"; // Table Name
        private static final int DATABASE_Version = 2; // Database Version
        private static final String UID="_id";
        private static final String EMAIL = "email"; // Column I (Primary Key)
        private static final String NAME = "name"; // Column I (Primary Key)

        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255) ,"+ EMAIL + " VARCHAR(255));";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context = context;
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }
    }
    static class myDbHelper2 extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "myDatabasee"; // Database Name
        private static final String TABLE_NAME = "myTablee"; // Table Name
        private static final int DATABASE_Version = 3; // Database Version
        private static final String MOVIE = "movie"; //Column II
        private static final String UID="uid";
        private static final String DATE="date";
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ( "+UID+" Integer, "+MOVIE+" VARCHAR(225),"+DATE+" VARCHAR(225));";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;
        public myDbHelper2(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DROP_TABLE);
            onCreate(db);

        }
    }

}