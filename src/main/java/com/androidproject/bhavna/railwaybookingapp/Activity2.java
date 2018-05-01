package com.androidproject.bhavna.railwaybookingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }
    public void registerMe(View v){

        startActivity(new Intent(Activity2.this,Registration.class));;
    }
    public void loginMe(View v){
       // Toast.makeText(getApplicationContext(),"Inside loginMe()",2000).show();
        startActivity(new Intent(Activity2.this,TicketBookAndShow.class));
    }
}
