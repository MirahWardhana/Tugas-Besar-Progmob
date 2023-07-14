package com.example.practicenew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DashboardUser extends AppCompatActivity implements UserOrderInterface {
    DataBaseHelper DB;
    ArrayList<String> username_order, order_id, order_date, order_status, shape;
    RecyclerView recyclerView;
    UserOrder_RecycleViewAdapter adapter;
    Button insert;
    Cursor cursor;

    public static String username1, username, name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_user);

        username1 = LogIn.Username;

        DB = new DataBaseHelper(DashboardUser.this);
        username_order = new ArrayList<>();
        order_id = new ArrayList<>();
        order_date = new ArrayList<>();
        order_status = new ArrayList<>();
        shape = new ArrayList<>();

        TextView dUsername = findViewById(R.id.displayUsername);
        TextView dName = findViewById(R.id.displayName);
        TextView dEmail = findViewById(R.id.displayEmail);

        // Create an instance of the database helper
        DataBaseHelper DB = new DataBaseHelper(this);

        Cursor cursor = DB.readuserdatadashboard(username1);

        if (cursor != null && cursor.moveToFirst()) {
            // Retrieve the values from the cursor
            int usernameIndex = cursor.getColumnIndex("username");
            int nameIndex = cursor.getColumnIndex("name");
            int emailIndex = cursor.getColumnIndex("email");

            if (usernameIndex != -1 && nameIndex != -1 && emailIndex != -1) {
                // Retrieve the values from the cursor
                String username = cursor.getString(usernameIndex);
                String name = cursor.getString(nameIndex);
                String email = cursor.getString(emailIndex);

                // Set the values to the corresponding TextViews
                dUsername.setText(username);
                dName.setText(name);
                dEmail.setText(email);
            }
        }

        Button button = findViewById(R.id.buttonCreateOrder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShapePicker();
            }
        });

        adapter = new UserOrder_RecycleViewAdapter(DashboardUser.this, username_order, order_id, order_date, order_status, shape);
        recyclerView = findViewById(R.id.rviewOrder);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(DashboardUser.this));
        storeUserOrder();
    }

    public void openShapePicker() {
        Intent intent = new Intent(this, ShapePicker.class);
        startActivity(intent);
    }

    private void storeUserOrder() {
        Cursor cursor = DB.readorderuserdashboard(username1);
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "User order is empty", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                username_order.add(cursor.getString(0));
                order_id.add(cursor.getString(1));
                order_date.add(cursor.getString(2));
                order_status.add(cursor.getString(3));
                shape.add(cursor.getString(4));
            }
        }
    }

    @Override
    public void onItemClick(int position) {
        // Handle item click event if needed
    }
}
