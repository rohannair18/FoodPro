package com.example.foodpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<RestaurantDetail> list;

    public MyAdapter(Context context, ArrayList<RestaurantDetail> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
             RestaurantDetail restaurantDetail=list.get(position);
             holder.restaurant.setText(restaurantDetail.getRestaurant());
    }

    @Override
    public int getItemCount() {
        return list.size();

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView restaurant;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurant=itemView.findViewById(R.id.RestaurantName);
        }
    }
}
