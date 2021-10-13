package com.example.foodpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;


public class Restaurants extends AppCompatActivity {
    ImageButton img1;
    ImageButton img2;
    ImageButton img4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        img1=(ImageButton)findViewById(R.id.imageButton2);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h= new Intent(getApplicationContext(),Order.class);
                startActivity(h);
            }
        });
        img2=(ImageButton)findViewById(R.id.imageButton3);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g= new Intent(getApplicationContext(),Order.class);
                startActivity(g);
            }
        });
        img4=(ImageButton)findViewById(R.id.imageButton16);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t= new Intent(getApplicationContext(),Order.class);
                startActivity(t);
            }
        });

    }
}