package com.example.bookswap;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "STUDENT.db";
    private static final String TABLE_NAME = "Student_table";
    private static final String COL_1 = "Name";
    private static final String COL_2 = "Phone";
    private static final String COL_3 = "Email";
    private static final String COL_4 = "Password";

    databaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+TABLE_NAME+"(Name TEXT PRIMARY KEY AUTOINCREMENT, Phone TEXT, Email TEXT, Password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    boolean submit(String name, String phone, String email, String password){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,phone);
        contentValues.put(COL_3,email);
        contentValues.put(COL_4,password);
        long result = db.insert(TABLE_NAME,null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
}
