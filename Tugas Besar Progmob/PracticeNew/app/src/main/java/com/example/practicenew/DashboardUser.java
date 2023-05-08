package com.example.practicenew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class DashboardUser extends AppCompatActivity {
    ArrayList<user_order> userOrders=new ArrayList<>();
    int[] orderImage={R.drawable.shape1, R.drawable.shape2, R.drawable.shape3, R.drawable.shape4, R.drawable.shape5, R.drawable.shape6, R.drawable.shape7, R.drawable.shape8};
    String uname_signup= SignUp.username;
    String name_signup= SignUp.name;
    String email_signup= SignUp.email;
    String uname_login= LogIn.username;
//    String name_login= ambil dari database
//    String email_login= ambil dari database
    public static String uname, name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_user);

        TextView dUsername =(TextView)findViewById(R.id.displayUsername);
        TextView dName =(TextView)findViewById(R.id.displayName);
        TextView dEmail =(TextView)findViewById(R.id.displayEmail);

//code starts here:
            uname_signup=uname;
            name_signup=name;
            email_signup=email;
            dUsername.setText(uname);
            dName.setText(name);
            dEmail.setText(email);

            uname_login=uname;
//            name_login=name;
//            email_login=email;
            dUsername.setText(uname);
            dName.setText(name);
            dEmail.setText(email);





        Button button = (Button) findViewById(R.id.buttonCreateOrder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShapePicker();
            }
        });

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