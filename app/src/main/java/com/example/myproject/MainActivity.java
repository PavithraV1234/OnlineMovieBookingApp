package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    EditText e1;
    myDbAdapter helper = new myDbAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.t1);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), register.class);
                startActivity(intent);
            }

        });
    }

    public void viewdata(View view) {
        e1=(EditText) findViewById(R.id.edit1);
        String ee1=e1.getText().toString().trim();
        int b= helper.getData(ee1);
        if(b==1){
        Intent intent1 = new Intent(getApplicationContext(), movieslist.class);
        intent1.putExtra("message_key", ee1);
        startActivity(intent1);}
        else{
            Toast.makeText(getApplicationContext(),"Enter valid ID",Toast.LENGTH_SHORT).show();
        }


    }
}
