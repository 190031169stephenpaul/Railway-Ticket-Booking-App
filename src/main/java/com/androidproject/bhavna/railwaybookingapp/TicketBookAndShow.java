package com.androidproject.bhavna.railwaybookingapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class TicketBookAndShow extends AppCompatActivity {
    DatabaseConnectivity dc ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_book_and_show);
        dc = new DatabaseConnectivity(this);

        Spinner sp = (Spinner)findViewById(R.id.select1);

        ArrayAdapter <CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.places,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(arrayAdapter);

        Spinner sp2 = (Spinner)findViewById(R.id.select2);
        ArrayAdapter <CharSequence> arrayAdapter2 = ArrayAdapter.createFromResource(this,R.array.places,android.R.layout.simple_spinner_item);
        //arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(arrayAdapter2);

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("item",(String)adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
    public void hello(View v){
        //Toast.makeText(getApplicationContext(),"HelloWorld",Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(),"Inside BookTicket()",Toast.LENGTH_SHORT).show();
        Spinner s1 = (Spinner)findViewById(R.id.select1);
        Spinner s2 = (Spinner)findViewById(R.id.select2);
        //DatabaseConnectivity dc;
        String src = s1.getSelectedItem().toString();
        String dest = s2.getSelectedItem().toString();
        Boolean i = dc.insertTicket(src,dest);
        if(i){
            Toast.makeText(getApplicationContext(),"Ticked Booked Successfully..!", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(),"There is some error!",Toast.LENGTH_SHORT).show();
    }

    public void hello1(View v){
       // Toast.makeText(getApplicationContext(),"HelloWorld1",Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(),"Inside ShowTicket()",Toast.LENGTH_SHORT).show();

        Cursor data = dc.selectTicket();
        if(data.getCount()==0){
            Toast.makeText(getApplicationContext(),"There is no Ticket booked !",Toast.LENGTH_LONG).show();
        }
        else{
            StringBuffer br = new StringBuffer();
            while(data.moveToNext()){
                br.append("ID : "+data.getString(0)+"\n");
                br.append("Source : "+data.getString(1)+"\n");
                br.append("Destination : "+data.getString(2)+"\n");
                br.append("Date : "+data.getString(3)+"\n\n");
            }
            showMessage("Tickets Booked !",br.toString());
        }
    }


   /* public void BookTicket(View v){
        Toast.makeText(getApplicationContext(),"Inside BookTicket()",Toast.LENGTH_SHORT).show();
        Spinner s1 = (Spinner)findViewById(R.id.select1);
        Spinner s2 = (Spinner)findViewById(R.id.select2);
        DatabaseConnectivity dc=null;
        String src = s1.getSelectedItem().toString();
        String dest = s2.getSelectedItem().toString();
        Boolean i = dc.insertTicket(src,dest);
        if(i){
            Toast.makeText(getApplicationContext(),"Ticked Booked Successfully..!", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(),"There is some error!",Toast.LENGTH_SHORT).show();
    }

    public void ShowTicket(View v){
        Toast.makeText(getApplicationContext(),"Inside ShowTicket()",Toast.LENGTH_SHORT).show();
        DatabaseConnectivity dc = null;
        Cursor data = dc.selectTicket();
        if(data.getCount()==0){
            Toast.makeText(getApplicationContext(),"There is no Ticket booked !",Toast.LENGTH_LONG).show();
        }
        else{
            StringBuffer br = new StringBuffer();
            while(data.moveToNext()){
                br.append("ID : "+data.getString(0)+"\n");
                br.append("Source : "+data.getString(1)+"\n");
                br.append("Destination : "+data.getString(2)+"\n");
                br.append("Date : "+data.getString(3)+"\n\n");
            }
            showMessage("Tickets Booked !",br.toString());
        }
    } */

    public void showMessage(String title,String msg){
        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setCancelable(true);
        ad.setTitle(title);
        ad.setMessage(msg);

        ad.show();
    }
}
