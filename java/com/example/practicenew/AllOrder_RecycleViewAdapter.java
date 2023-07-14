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

public class AllOrder_RecycleViewAdapter extends RecyclerView.Adapter<AllOrder_RecycleViewAdapter.MyViewHolder> {
    private Context context;

    private ArrayList<String> username_order, order_id, order_date, order_status, shape;
    String gambar;
//    private AllOrderInterface allOrderInterface;

    public AllOrder_RecycleViewAdapter(Context context,
                                        ArrayList<String> order_id,
                                        ArrayList<String> username_order,
                                        ArrayList<String> order_date,
                                        ArrayList<String> order_status,
                                        ArrayList<String> shape){
        this.context = context;
        this.order_id = order_id;
        this.username_order = username_order;
        this.order_date = order_date;
        this.order_status = order_status;
        this.shape = shape;
    }
    public AllOrder_RecycleViewAdapter(DashboardUser context, ArrayList<String> order_id, ArrayList<String> username_order,  ArrayList<String> order_date, ArrayList<String> order_status, ArrayList<String> shape) {
    }

    @NonNull
    @Override
    public AllOrder_RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rview_allorder, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllOrder_RecycleViewAdapter.MyViewHolder holder, int position) {
        holder.textViewOrderId.setText(String.valueOf(order_id.get(position)));
        holder.textViewUsername.setText(String.valueOf(username_order.get(position)));
        holder.textViewStatus.setText(String.valueOf(order_status.get(position)));
        gambar = shape.get(position);
        if (gambar.equals("shape1")){
            holder.image.setImageResource(R.drawable.shape1);
        }
        else if (gambar.equals("shape2")){
            holder.image.setImageResource(R.drawable.shape2);
        }
        else if (gambar.equals("shape3")){
            holder.image.setImageResource(R.drawable.shape3);
        }
        else if (gambar.equals("shape4")){
            holder.image.setImageResource(R.drawable.shape4);
        }
        else if (gambar.equals("shape5")){
            holder.image.setImageResource(R.drawable.shape5);
        }
        else if (gambar.equals("shape6")){
            holder.image.setImageResource(R.drawable.shape6);
        }
        else if (gambar.equals("shape7")){
            holder.image.setImageResource(R.drawable.shape7);
        }
        else if (gambar.equals("shape8")){
            holder.image.setImageResource(R.drawable.shape8);
        }
        else{
            holder.image.setImageResource(R.drawable.shape9);
        }
    }

    @Override
    public int getItemCount() {
        return order_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView textViewOrderId, textViewUsername, textViewStatus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgOrder);
            textViewOrderId = itemView.findViewById(R.id.txOrderId);
            textViewUsername = itemView.findViewById(R.id.txUsername);
            textViewStatus = itemView.findViewById(R.id.txOrderStatus);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (allOrderInterface != null){
//                        int pos = getAdapterPosition();
//                        if (pos != RecyclerView.NO_POSITION){
//                            allOrderInterface.onItemClick(pos);
//                        }
//                    }
//                }
//            });
        }
    }
}
