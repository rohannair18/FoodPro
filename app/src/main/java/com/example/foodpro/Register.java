package com.example.foodpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Register extends AppCompatActivity {
    Button btn2;
    FirebaseDatabase database;
    DatabaseReference fooddbref;
    FirebaseAuth auth;
    EditText name,email,username,password,confirm_password,address;
    String s_name,s_email,s_username,s_password,s_address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn2=(Button)findViewById(R.id.signup);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                name=findViewById(R.id.Name);
                email=findViewById(R.id.Email);
                username=findViewById(R.id.Username);
                address=findViewById(R.id.address);
                password = findViewById(R.id.password);
                confirm_password = findViewById(R.id.password2);
                auth=FirebaseAuth.getInstance();
                String s_password = password.getText().toString().trim();
                String s_confirm_password = confirm_password.getText().toString().trim();

                if (s_password.equals(s_confirm_password)){
                    Intent k= new Intent(getApplicationContext(), Location.class);
                    startActivity(k);
                    database=FirebaseDatabase.getInstance();
                    fooddbref=database.getReference().child("Food");
                    insertuserdata();
                    auth.createUserWithEmailAndPassword(s_email,s_password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task) {
                               Toast.makeText(Register.this,"User Signed up Sucessfully",Toast.LENGTH_SHORT).show();
                             }

                             })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                 Toast.makeText(Register.this ,e.getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            });



                }
                else {
                    Toast.makeText(getApplicationContext(), "Password don't match", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private void insertuserdata(){
        s_name=name.getText().toString().trim();
        s_email=email.getText().toString().trim();
        s_username=username.getText().toString().trim();
        s_address=address.getText().toString().trim();
        s_password=password.getText().toString().trim();
        Food food;
        food =new Food(s_name,s_email,s_address,s_password,s_username);
        fooddbref.push().setValue(food);
        Toast.makeText(getApplicationContext(),"Data inserted", Toast.LENGTH_SHORT).show();


    }
}