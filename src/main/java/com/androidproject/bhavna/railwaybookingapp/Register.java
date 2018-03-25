package com.androidproject.bhavna.railwaybookingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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
            }
        });
    }
}
