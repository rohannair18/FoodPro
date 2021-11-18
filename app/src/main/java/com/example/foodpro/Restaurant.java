package com.example.foodpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Restaurant extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapter adapter;
    ArrayList<RestaurantDetail> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        recyclerView=findViewById(R.id.restaurantlist);
        database= FirebaseDatabase.getInstance().getReference("Restaurant");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list =new ArrayList<>();
        adapter= new MyAdapter(this,list);
        recyclerView.setAdapter(adapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){

                    RestaurantDetail restaurantDetail=dataSnapshot.getValue(RestaurantDetail.class);
                    list.add(restaurantDetail);

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}