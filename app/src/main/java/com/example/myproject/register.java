package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class register extends AppCompatActivity {
    Button b1;
    EditText edd1;
    EditText edd2;
    myDbAdapter helper = new myDbAdapter(this);;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        b1=(Button) findViewById(R.id.b1);
        edd1=(EditText) findViewById(R.id.edit1);
        edd2=(EditText) findViewById(R.id.edit2);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ed1=edd1.getText().toString();
                String ed2=edd2.getText().toString();
                if(ed1.isEmpty() || ed2.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter Email ID",Toast.LENGTH_LONG).show();
                }else{
                long id = helper.insertData(ed1,ed2);
                if(id<=0)
                {
                    Toast.makeText(getApplicationContext(),"Insertion Unsuccessful",Toast.LENGTH_LONG).show();
                } else
                {
                    Toast.makeText(getApplicationContext(),"Insertion Successful",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }}

            }
        });


    }
}