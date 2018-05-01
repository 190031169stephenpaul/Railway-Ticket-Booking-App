package com.androidproject.bhavna.railwaybookingapp;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Pass extends AppCompatActivity {

    DatabaseConnectivity dc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);
        dc = new DatabaseConnectivity(this);
    }
    public void bookMyPass(View v){
        EditText name = findViewById(R.id.rname);
        EditText addr = findViewById(R.id.raddress);
        EditText aadhar = findViewById(R.id.raadhar);
        EditText s = findViewById(R.id.sourcee);
        EditText d = findViewById(R.id.deste);

        String usname = name.getText().toString();
        String address = addr.getText().toString();
        String aadh = aadhar.getText().toString();
        String src = s.getText().toString();
        String dest = d.getText().toString();

        Boolean i = dc.insertPass(usname,address,aadh,src,dest);
        if(i)
            Toast.makeText(getApplicationContext(),"Pass successfully booked!",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(),"Some error in booking!",Toast.LENGTH_SHORT).show();
    }

    public void retrieve(View v){
        Cursor data = dc.selectPass();
        if(data.getCount()==0){
            Toast.makeText(getApplicationContext(),"There is no Pass booked !",Toast.LENGTH_LONG).show();
        }
        else{
            StringBuffer br = new StringBuffer();
            while(data.moveToNext()){
                br.append("ID : "+data.getString(0)+"\n");
                br.append("Name : "+data.getString(1)+"\n");
                br.append("Address : "+data.getString(2)+"\n");
                br.append("Aadhar : "+data.getString(3)+"\n");
                br.append("Source : "+data.getString(4)+"\n");
                br.append("Destination : "+data.getString(5)+"\n\n");

            }
            showMessage("Pass!",br.toString());
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
