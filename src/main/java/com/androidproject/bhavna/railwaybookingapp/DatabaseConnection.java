package com.androidproject.bhavna.railwaybookingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseConnection extends SQLiteOpenHelper {

    public DatabaseConnection(Context context) {
        super(context,"Login.db",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(Name text , Usernmae text , Email text primary key,Password text,Phoneno text,Address text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists user");
    }
    //inserting in database
    public boolean insert(String name,String username,String email,String password,String phone,String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Username",username);
        contentValues.put("Email",email);
        contentValues.put("Password",password);
        contentValues.put("Phoneno",phone);
        contentValues.put("Address",address);
        long ins = db.insert("user",null,contentValues);
        if(ins==1) return false;
        else
            return true;

    }
    //Checking if email exists
    public Boolean checkmail(String e){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where Email=?",new String[]{e});
        if(cursor.getCount()>0)
            return false;
        else return  true;
    }
}
