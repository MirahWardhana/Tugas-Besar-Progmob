package com.example.practicenew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserOrder_RecycleViewAdapter extends RecyclerView.Adapter<UserOrder_RecycleViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<user_order> UserOrders;
    public UserOrder_RecycleViewAdapter(Context context, ArrayList<user_order>UserOrders){
        this.context=context;
        this.UserOrders=UserOrders;
    }

    @NonNull
    @Override
    public UserOrder_RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.rview_order, parent,false);
        return new UserOrder_RecycleViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserOrder_RecycleViewAdapter.MyViewHolder holder, int position) {
        holder.textViewNumber.setText(UserOrders.get(position).getOrderNumber());
        holder.textViewDate.setText(UserOrders.get(position).getOrderDate());
        holder.textViewStatus.setText(UserOrders.get(position).getOrderStatus());
        holder.image.setImageResource(UserOrders.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return UserOrders.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView textViewNumber, textViewDate, textViewStatus;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageOrder);
            textViewNumber=itemView.findViewById(R.id.textOrderNumber);
            textViewDate=itemView.findViewById(R.id.textOrderDate);
            textViewStatus=itemView.findViewById(R.id.textOrderStatus);
        }
    }
}
