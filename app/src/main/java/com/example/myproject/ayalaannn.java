package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ayalaannn extends AppCompatActivity {
    Button b1;
    TextView tt1,tu;
    EditText ee1;
    int t;
    myDbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayalaannn);
        b1=(Button) findViewById(R.id.sub);
        tt1=(TextView) findViewById(R.id.t5);
        ee1=(EditText) findViewById(R.id.edit1);
        tu=findViewById(R.id.user);
        helper=new myDbAdapter(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ee1.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"enter no. of seats",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(TextUtils.isEmpty(ee1.getText().toString()))
                        return;
                    int e10=Integer.parseInt(ee1.getText().toString());
                    t=200;
                    if(ee1.getText().toString().isEmpty()==false){

                        tt1.setText(String.valueOf(t*e10));
                    }
                    LayoutInflater li = getLayoutInflater();
                    //Getting the View object as defined in the customtoast.xml file
                    View layout = li.inflate(R.layout.toastt, (ViewGroup) findViewById(R.id.custom_toast_layout));

                    //Creating the Toast object
                    Toast toast = new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.setView(layout);//setting the view of custom toast layout
                    toast.show();
                    Intent intenttt=getIntent();
                    String str22=intenttt.getStringExtra("message_key");
                    tu.setText(str22);
                    long id=helper.insertt("Ayalaan: Seats="+ee1.getText().toString(),tu.getText().toString());
                    if(id<=0){
                        Toast.makeText(ayalaannn.this, "insertion unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(ayalaannn.this, "insertion successful", Toast.LENGTH_SHORT).show();
                    }
                }
                }

        });

    }
}