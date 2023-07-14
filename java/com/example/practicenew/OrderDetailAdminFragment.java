package com.example.practicenew;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderDetailAdminFragment extends Fragment {
    DataBaseHelper DB;
    ArrayList<String> order_id,username_order, order_date, order_status, shape;
    RecyclerView recyclerView;
    AllOrder_RecycleViewAdapter adapter;
    EditText torderid, torderstatus,torderdate, torderprice,tordernote;

    public OrderDetailAdminFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DB = new DataBaseHelper(getActivity());
        order_id = new ArrayList<>();
        username_order = new ArrayList<>();
        order_date = new ArrayList<>();
        order_status = new ArrayList<>();
        shape = new ArrayList<>();

//        adapter = new AllOrder_RecycleViewAdapter(getActivity(),order_id,username_order, order_date, order_status,shape);
//        recyclerView = view.findViewById(R.id.rviewAllOrder);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        storeDataUser();


        torderid=view.findViewById(R.id.textorderid);
        torderstatus=view.findViewById(R.id.textorderstatus);
        torderdate=view.findViewById(R.id.textorderdate);
        torderprice=view.findViewById(R.id.textorderprice);
        tordernote=view.findViewById(R.id.textordernote);

        Button buttonUpdate=view.findViewById(R.id.buttonUpdate);

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String orderId=torderid.getText().toString();
                String orderStatus=torderstatus.getText().toString();
                String orderDate=torderdate.getText().toString();
                String orderPrice=torderprice.getText().toString();
                String orderNote=tordernote.getText().toString();

                boolean updated = DB.updateOrder(Integer.parseInt(orderId), orderDate, orderStatus, Integer.parseInt(orderPrice), orderNote);
                if (updated) {
                    Toast.makeText(getActivity(),"Order data successfully updated!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(),"Failed to update order data!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Button buttondelete=view.findViewById(R.id.buttonDelete);

        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String orderId=torderid.getText().toString();
                Boolean deleteorder=DB.deleteOrder(Integer.parseInt(orderId));
                if(deleteorder==true){
                    Toast.makeText(getActivity(),"Order data successfully deleted!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(),"Failed to delete the data", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_detail_admin, container, false);
    }

    private void storeDataUser(){
        Cursor cursor=DB.readallorder();
        if(cursor.getCount()==0){
            Toast.makeText(getActivity(),"Order data is empty",Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                order_id.add(cursor.getString(0));
                username_order.add(cursor.getString(1));
                order_date.add(cursor.getString(2));
                order_status.add(cursor.getString(3));
                shape.add(cursor.getString(4));
            }
        }
    }
}