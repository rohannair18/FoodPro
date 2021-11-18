package com.example.foodpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db;
    DatabaseReference fooddbref;
    Button btn;
    Button btn1;
    FirebaseAuth mAuth;
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth=FirebaseAuth.getInstance();
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.Username);
        password=findViewById(R.id.Password);

        btn=(Button)findViewById(R.id.register);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);
            }
        });
        btn1=(Button)findViewById(R.id.login);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent j = new Intent(getApplicationContext(), Restaurants.class);
                //startActivity(j);
                String s_username,s_password;
                s_username=username.getText().toString().trim();
                s_password=password.getText().toString().trim();
                mAuth.signInWithEmailAndPassword(s_username,s_password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(MainActivity.this, Restaurant.class);
                                    startActivity(i);
                                }
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });


            }
        });

    }
}