package com.example.practicenew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<user_order>userOrders=new ArrayList<>();
    int[] orderImage={R.drawable.shape1, R.drawable.shape2, R.drawable.shape3, R.drawable.shape4, R.drawable.shape6, R.drawable.shape7, R.drawable.shape8, R.drawable.shape9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.buttonLogIn1);
        final TextView textView = (TextView) findViewById(R.id.textView3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Text to be set in TextView");
                openColorPicker();
            }
        });

        setUpUserOrder();

    }

    private void setUpUserOrder(){
        String[] orderNumber=getResources().getStringArray(R.array.order_number);
        String[] orderDate=getResources().getStringArray(R.array.order_date);
        String[] orderStatus=getResources().getStringArray(R.array.order_status);

        for (int i =0;i< orderNumber.length;i++){
            userOrders.add(new user_order(orderNumber[i], orderDate[i],orderStatus[i], orderImage[i]));
        }
    }

    private void openColorPicker() {
        Intent intent = new Intent(this,ColorPicker.class);
        startActivity(intent);
    }
}
