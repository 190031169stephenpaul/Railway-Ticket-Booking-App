package com.androidproject.bhavna.railwaybookingapp;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BusPass extends AppCompatActivity {
    DatabaseConnectivity dc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_pass);
        dc = new DatabaseConnectivity(this);
    }
    public void buspass(View v){
        EditText name = findViewById(R.id.bname);
        EditText school = findViewById(R.id.bschool);
        EditText sid = findViewById(R.id.bsid);
        EditText addr = findViewById(R.id.baddress);
        EditText s = findViewById(R.id.bsrc);
        EditText d = findViewById(R.id.bdest);

        String usname = name.getText().toString();
        String sch = school.getText().toString();
        String ssid = sid.getText().toString();
        String address = addr.getText().toString();
        String src = s.getText().toString();
        String dest = d.getText().toString();

        Boolean i = dc.insertBusPass(usname,sch,ssid,address,src,dest);
        if(i)
            Toast.makeText(getApplicationContext(),"Bus Pass successfully booked!",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(),"Some error in booking!",Toast.LENGTH_SHORT).show();
    }

    public void show(View v){
        Cursor data = dc.selectBusPass();
        if(data.getCount()==0){
            Toast.makeText(getApplicationContext(),"There is no Bus Pass booked !",Toast.LENGTH_LONG).show();
        }
        else{
            StringBuffer br = new StringBuffer();
            while(data.moveToNext()){
                br.append("ID : "+data.getString(0)+"\n");
                br.append("Name : "+data.getString(1)+"\n");
                br.append("School : "+data.getString(2)+"\n");
                br.append("SID : "+data.getString(3)+"\n");
                br.append("Address : "+data.getString(4)+"\n");

                br.append("Source : "+data.getString(5)+"\n");
                br.append("Destination : "+data.getString(6)+"\n\n");

            }
            showMessage("Bus Pass!",br.toString());
        }
    }
    public void showMessage(String title,String msg){
        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setCancelable(true);
        ad.setTitle(title);
        ad.setMessage(msg);

        ad.show();
    }
}


