package com.example.practicenew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class DashboardAdmin extends AppCompatActivity{
    Button view;
    DataBaseHelper DB;
    ArrayList<String> username, name, phone,email;
    RecyclerView recyclerView;
    UserData_RecycleViewAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin);

        DB= new DataBaseHelper(DashboardAdmin.this);
        username= new ArrayList<>();
        name= new ArrayList<>();
        email= new ArrayList<>();
        phone= new ArrayList<>();

        adapter= new UserData_RecycleViewAdapter(DashboardAdmin.this,username,name,email,phone);
        recyclerView= findViewById(R.id.rviewUser);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(DashboardAdmin.this));
        storeDataUser();
    }

    private void storeDataUser(){
        Cursor cursor=DB.readuserdata();
        if(cursor.getCount()==0){
            Toast.makeText(this,"User data is empty",Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                username.add(cursor.getString(0));
                name.add(cursor.getString(1));
                email.add(cursor.getString(2));
                phone.add(cursor.getString(3));
            }
        }
    }


}