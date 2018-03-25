package com.androidproject.bhavna.railwaybookingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    DatabaseConnection dc;
    EditText e1,e2,e3,e4,e5,e6;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dc = new DatabaseConnection(this);
        e1 = (EditText)findViewById(R.id.name);
        e2 = (EditText)findViewById(R.id.email);
        e3 = (EditText)findViewById(R.id.username);
        e4 = (EditText) findViewById(R.id.password);
        e5 = (EditText)findViewById(R.id.phoneno);
        e6 = (EditText)findViewById(R.id.Address);
        b = (Button)findViewById(R.id.submit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                String s5 = e5.getText().toString();
                String s6 = e6.getText().toString();
                if(s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("") || s6.equals("")){
                    Toast.makeText(getApplicationContext(),"Field are empty",Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean checkEmail = dc.checkmail(s2);
                    if(checkEmail==true){
                        Boolean insert = dc.insert(s1,s2,s3,s4,s5,s6);
                        if(insert==true){
                            Toast.makeText(getApplicationContext(),"Registration Successful",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Email Already Registered",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
