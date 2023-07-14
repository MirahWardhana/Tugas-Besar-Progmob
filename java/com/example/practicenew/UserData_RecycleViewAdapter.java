package com.example.practicenew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserData_RecycleViewAdapter extends RecyclerView.Adapter<UserData_RecycleViewAdapter.MyViewHolder> {
    private Context context;
    private ArrayList username, name, phone,email;

    UserData_RecycleViewAdapter(Context context,
                  ArrayList username,
                  ArrayList name,
                  ArrayList phone,
                  ArrayList email
                  ){
        this.context=context;
        this.username=username;
        this.name=name;
        this.phone=phone;
        this.email=email;
    }


    @NonNull
    @Override
    public UserData_RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.rview_user,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserData_RecycleViewAdapter.MyViewHolder holder, int position) {
        holder.text_username.setText(String.valueOf(username.get(position)));
        holder.text_name.setText(String.valueOf(name.get(position)));
        holder.text_phone.setText(String.valueOf(phone.get(position)));
        holder.text_email.setText(String.valueOf(email.get(position)));
    }

    @Override
    public int getItemCount() {
        return username.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text_username,text_name,text_email,text_phone;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_username=itemView.findViewById(R.id.textUsername);
            text_name=itemView.findViewById(R.id.textName);
            text_phone=itemView.findViewById(R.id.textPhone);
            text_email=itemView.findViewById(R.id.textEmail);

        }
    }
}
