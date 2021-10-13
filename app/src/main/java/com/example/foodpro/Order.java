package com.example.foodpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Order extends AppCompatActivity {
    ImageButton img3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        img3= (ImageButton)findViewById(R.id.imageButton15);
        img3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),CheckOut.class);
                startActivity(i);
            }
        }) ;
    }
}