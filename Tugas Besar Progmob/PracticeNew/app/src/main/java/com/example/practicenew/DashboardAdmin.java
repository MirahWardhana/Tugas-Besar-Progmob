package com.example.practicenew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class DashboardAdmin extends AppCompatActivity {
    Button view;
    DataBaseHelper DB;
    ArrayList<user_order> userOrders=new ArrayList<>();
    int[] orderImage={R.drawable.shape1, R.drawable.shape2, R.drawable.shape3, R.drawable.shape4, R.drawable.shape5, R.drawable.shape6, R.drawable.shape7, R.drawable.shape8};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin);


        RecyclerView recyclerView= findViewById(R.id.rviewOrder);
        setUpUserOrder();

        UserOrder_RecycleViewAdapter adapter= new UserOrder_RecycleViewAdapter(this,userOrders);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void openShapePicker(){
        Intent intent = new Intent(this,ShapePicker.class);
        startActivity(intent);
    }

    private void setUpUserOrder(){
        String[] orderNumber=getResources().getStringArray(R.array.order_number);
        String[] orderDate=getResources().getStringArray(R.array.order_date);
        String[] orderStatus=getResources().getStringArray(R.array.order_status);

        for (int i =0;i< orderNumber.length;i++){
            userOrders.add(new user_order(orderNumber[i], orderDate[i],orderStatus[i], orderImage[i]));
        }
    }

}