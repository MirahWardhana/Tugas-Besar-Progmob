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
import android.widget.Toast;

import java.util.ArrayList;

public class DashboardAdminFragment extends Fragment {
    DataBaseHelper DB;
    ArrayList<String> username, name, phone,email;
    RecyclerView recyclerView;
    UserData_RecycleViewAdapter adapter;

    public DashboardAdminFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DB= new DataBaseHelper(getActivity());
        username= new ArrayList<>();
        name= new ArrayList<>();
        email= new ArrayList<>();
        phone= new ArrayList<>();


        adapter= new UserData_RecycleViewAdapter(getActivity(),username,name,email,phone);
        recyclerView= view.findViewById(R.id.rviewUser);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        storeDataUser();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard_admin, container, false);
    }

    private void storeDataUser(){
        Cursor cursor=DB.readuserdata();
        if(cursor.getCount()==0){
            Toast.makeText(getActivity(),"User data is empty",Toast.LENGTH_SHORT).show();
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