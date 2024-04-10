package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class book extends AppCompatActivity {
    TextView receiver_msg,tvem;
    myDbAdapter helper;
    private static String mess="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        receiver_msg = findViewById(R.id.t2);
        tvem=findViewById(R.id.user);
        helper=new myDbAdapter(this);
        // create the get Intent object
        Intent intenttt=getIntent();
        String str22=intenttt.getStringExtra("message_key");
        tvem.setText(str22);
        String s=helper.gett(str22);
        receiver_msg.setText(s);
    }
}