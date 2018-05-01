package com.androidproject.bhavna.railwaybookingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class DatabaseConnectivity extends SQLiteOpenHelper {

    DatabaseConnectivity(Context context){
        super(context,"People.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("Create table Users(Id integer primary key autoincrement , Name Text, Username Text, EmailId Text , Password Text , PhoneNo String , Address String)");
        db.execSQL("Create table Ticket(Tid integer primary key autoincrement, Source Text, Destination Text,Date Text)");
        db.execSQL("Create table Pass(Pid integer primary key autoincrement, Name Text, Address Text, Aadhar Text, Source Text, Destination Text)");
        db.execSQL("Create table BusPass(Pid integer primary key autoincrement,Name Text,School Text,SSID Text,Address Text,Source Text,Destination Text)");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion ,int newVersion ){
        db.execSQL("Drop table if exists Users");
        db.execSQL("Drop table if exists Ticket");
        db.execSQL("Drop table if exists Pass");
        db.execSQL("Drop table if exists BusPass");
        onCreate(db);
    }
    public boolean insertEntry(String name,String username,String email,String password,String phone,String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Name",name);
        cv.put("Username",username);
        cv.put("Username",username);
        cv.put("EmailId",email);
        cv.put("Password",password);
        cv.put("PhoneNo",phone);
        cv.put("Address",address);

        long a = db.insert("Users",null,cv);

        if(a==-1)
            return false;
        else
            return true;

    }

    public boolean insertTicket(String src,String dest){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Source",src);
        cv.put("Destination",dest);
        cv.put("Date",getDateTime());

        long b = db.insert("Ticket",null,cv);
        if(b==-1)
            return false;
        else
            return true;
    }

    public boolean insertPass(String name,String address,String aadhar,String src,String dest){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("Name",name);
            cv.put("Address",address);
            cv.put("Aadhar",aadhar);
            cv.put("Source",src);
            cv.put("Destination",dest);

            long b = db.insert("Pass",null,cv);
            if(b==-1)
                return false;
            else
                return true;
        }

    public boolean insertBusPass(String name,String school,String sid,String address,String src,String dest){
      //  db.execSQL("Create table BusPass(Pid integer primary key autoincrement,Name Text,School Text,SSID Text,Address Text,Source Text,Destination Text)");

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Name",name);
        cv.put("School",school);
        cv.put("SSID",sid);
        cv.put("Address",address);
        cv.put("Source",src);
        cv.put("Destination",dest);

        long b = db.insert("BusPass",null,cv);
        if(b==-1)
            return false;
        else
            return true;

    }

    public Cursor selectPass(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("Select * from Pass",null);
        return  res;
    }
    public Cursor selectBusPass(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("Select * from BusPass",null);
        return  res;
    }
    public String getDateTime(){
        SimpleDateFormat d = new SimpleDateFormat("dd-mm-yyyy HH:MM:SS", Locale.getDefault());
        Date date = new Date();
        return d.format(date);
    }
    public  Cursor selectEntry(){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor res = db.rawQuery("Select * from Users",null);
        return res;
    }

    public Cursor selectTicket(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("Select * from Ticket",null);
        return  res;
    }

    public boolean updateEntry(String id,String name,String username,String email,String password,String phone,String address){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Id",id);
        cv.put("Name",name);
        cv.put("Username",username);
        cv.put("Username",username);
        cv.put("EmailId",email);
        cv.put("Password",password);
        cv.put("PhoneNo",phone);
        cv.put("Address",address);
        db.update("Users",cv,"Id = ?",new String[]{id});
        return true;
    }

    public boolean deleteEntry(String id){
        SQLiteDatabase db = this.getWritableDatabase();
         db.delete("Users","Id = ?",new String[]{id});
         return true;
    }

}
