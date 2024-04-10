package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class profilepage extends AppCompatActivity {
    myDbAdapter helper;
    TextView tvem,tvnm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepage);
        tvem=(TextView) findViewById(R.id.eml);
        tvnm=(TextView) findViewById(R.id.nme);
        helper=new myDbAdapter(this);
        Intent intenttt=getIntent();
        String str22=intenttt.getStringExtra("message_key");
        tvem.setText(str22);
        String str23=helper.getNamee(tvem.getText().toString());
        tvnm.setText(str23);
    }
}