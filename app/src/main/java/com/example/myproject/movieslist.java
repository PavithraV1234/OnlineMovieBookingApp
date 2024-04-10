package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class movieslist extends AppCompatActivity {
    ImageButton dora;
    ImageButton juma;
    ImageButton brahm;
    ImageButton patha;
    ImageButton ayal;
    ImageButton Vik;
    AutoCompleteTextView sear;
    ImageButton sea;
    ImageView ay;
    ImageView ju;
    ImageView br;
    Spinner sp1;
    FrameLayout hi;
    FrameLayout en;
    FrameLayout ta;
    Button b2;
    Button pro;
    TextView tvem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movieslist);
        pro=findViewById(R.id.profile);
        dora=(ImageButton) findViewById(R.id.dorai);
        juma=(ImageButton) findViewById(R.id.jumani);
        brahm=(ImageButton) findViewById(R.id.brahm);
        patha=(ImageButton) findViewById(R.id.patha);
        ayal=(ImageButton) findViewById(R.id.ayala);
        Vik=(ImageButton) findViewById(R.id.vikr);
        sp1=(Spinner) findViewById(R.id.langsp);
        hi=(FrameLayout) findViewById(R.id.hindi);
        ta=(FrameLayout) findViewById(R.id.tamil);
        en=(FrameLayout) findViewById(R.id.english);
        b2=(Button) findViewById(R.id.book);
        tvem=(TextView) findViewById(R.id.emaill);
        Intent intenttt=getIntent();
        String str22=intenttt.getStringExtra("message_key");
        tvem.setText(str22);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.array1, R.layout.langspinner);
        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if((sp1.getSelectedItem().toString()).equals("Hindi")){
                    hi.setVisibility(View.VISIBLE);
                    en.setVisibility(View.GONE);
                    ta.setVisibility(View.GONE);

                }
                else if ((sp1.getSelectedItem().toString()).equals("Tamil")) {
                    en.setVisibility(View.GONE);
                    hi.setVisibility(View.GONE);
                    ta.setVisibility(View.VISIBLE);

                }
                else{
                    ta.setVisibility(View.GONE);
                    hi.setVisibility(View.GONE);
                    en.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ta.setVisibility(View.VISIBLE);
                hi.setVisibility(View.GONE);
                en.setVisibility(View.GONE);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), book.class);
                intent.putExtra("message_key", tvem.getText().toString());
                startActivity(intent);
            }
        });
        dora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),doraa.class);
                intent.putExtra("message_key", tvem.getText().toString());
                startActivity(intent);
            }
        });
        juma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),juman.class);
                intent.putExtra("message_key", tvem.getText().toString());
                startActivity(intent);
            }
        });
        brahm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),brahm.class);
                intent.putExtra("message_key", tvem.getText().toString());
                startActivity(intent);
            }
        });
        patha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),patha.class);
                intent.putExtra("message_key", tvem.getText().toString());
                startActivity(intent);
            }
        });
        ayal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ayalaannn.class);
                intent.putExtra("message_key", tvem.getText().toString());
                startActivity(intent);
            }
        });
        Vik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),vikra.class);
                intent.putExtra("message_key", tvem.getText().toString());
                startActivity(intent);
            }
        });
        sear=(AutoCompleteTextView) findViewById(R.id.search);
        String[] movies={"jumanji","dora","ayalaan","vikram","pathaan","brahmastra"};
        ArrayAdapter<String> searc=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1,movies);
        sear.setAdapter(searc);
        sear.setThreshold(1);
        sea=(ImageButton) findViewById(R.id.se);
        sea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=sear.getText().toString();
                switch (s){
                    case "dora":
                        Intent intent=new Intent(getApplicationContext(),doraa.class);
                        intent.putExtra("message_key", tvem.getText().toString());
                        startActivity(intent);
                        break;
                    case "jumanji":
                        Intent intent1=new Intent(getApplicationContext(),juman.class);
                        intent1.putExtra("message_key", tvem.getText().toString());
                        startActivity(intent1);
                        break;
                    case "ayalaan":
                        Intent intent2=new Intent(getApplicationContext(), ayalaannn.class);
                        intent2.putExtra("message_key", tvem.getText().toString());
                        startActivity(intent2);
                        break;
                    case "vikram":
                        Intent intent3=new Intent(getApplicationContext(),vikra.class);
                        intent3.putExtra("message_key", tvem.getText().toString());
                        startActivity(intent3);
                        break;
                    case "pathaan":
                        Intent intent4=new Intent(getApplicationContext(),patha.class);
                        intent4.putExtra("message_key", tvem.getText().toString());
                        startActivity(intent4);
                        break;
                    case "brahmastra":
                        Intent intent5=new Intent(getApplicationContext(),brahm.class);
                        intent5.putExtra("message_key", tvem.getText().toString());
                        startActivity(intent5);
                        break;
                    default:
                        Toast.makeText(movieslist.this, "No search results", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        ju=(ImageView) findViewById(R.id.jum);
        br=(ImageView) findViewById(R.id.brh);
        ay=(ImageView) findViewById(R.id.ayal);
        ju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), juman.class);
                intent.putExtra("message_key", tvem.getText().toString());
                startActivity(intent);
            }
        });
        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), brahm.class);
                intent.putExtra("message_key", tvem.getText().toString());
                startActivity(intent);
            }
        });
        ay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ayalaannn.class);
                intent.putExtra("message_key", tvem.getText().toString());
                startActivity(intent);
            }
        });
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), profilepage.class);
                intent.putExtra("message_key", tvem.getText().toString());
                startActivity(intent);
            }
        });
    }
}