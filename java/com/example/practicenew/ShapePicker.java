package com.example.practicenew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ShapePicker extends AppCompatActivity {

    public static String shape;
    public String gambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_picker);



//CODE STARTS HERE

        ImageButton button = (ImageButton) findViewById(R.id.imageButton1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image=(ImageView) findViewById(R.id.zoomView);
                image.setImageResource(R.drawable.shape1);
                gambar="1";
                shape="shape1";
            }
        });

        ImageButton button2 = (ImageButton) findViewById(R.id.imageButton2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image=(ImageView) findViewById(R.id.zoomView);
                image.setImageResource(R.drawable.shape2);
                gambar="1";
                shape="shape2";
            }
        });

        ImageButton button3 = (ImageButton) findViewById(R.id.imageButton3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image=(ImageView) findViewById(R.id.zoomView);
                image.setImageResource(R.drawable.shape3);
                gambar="1";
                shape="shape3";
            }
        });

        ImageButton button4 = (ImageButton) findViewById(R.id.imageButton4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image=(ImageView) findViewById(R.id.zoomView);
                image.setImageResource(R.drawable.shape4);
                gambar="1";
                shape="shape4";
            }
        });

        ImageButton button5 = (ImageButton) findViewById(R.id.imageButton5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image=(ImageView) findViewById(R.id.zoomView);
                image.setImageResource(R.drawable.shape5);
                gambar="1";
            }
        });

        ImageButton button6 = (ImageButton) findViewById(R.id.imageButton6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image=(ImageView) findViewById(R.id.zoomView);
                image.setImageResource(R.drawable.shape6);
                gambar="2";
                shape="shape5";
            }
        });

        ImageButton button7 = (ImageButton) findViewById(R.id.imageButton7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image=(ImageView) findViewById(R.id.zoomView);
                image.setImageResource(R.drawable.shape7);
                gambar="2";
                shape="shape6";
            }
        });

        ImageButton button8 = (ImageButton) findViewById(R.id.imageButton8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image=(ImageView) findViewById(R.id.zoomView);
                image.setImageResource(R.drawable.shape8);
                gambar="2";
                shape="shape7";
            }
        });

        ImageButton button9 = (ImageButton) findViewById(R.id.imageButton9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image=(ImageView) findViewById(R.id.zoomView);
                image.setImageResource(R.drawable.shape9);
                gambar="2";
                shape="shape8";
            }
        });

        Button buttonOkay = (Button) findViewById(R.id.button);
        buttonOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gambar=="1"){
                    openSizing1();
                }
                else {
                    openSizing2();
                }
            }
        });

    }

    public void openSizing1(){
        Intent intent = new Intent(this,Sizing1.class);
        startActivity(intent);
    }
    public void openSizing2(){
        Intent intent = new Intent(this,Sizing2.class);
        startActivity(intent);
    }
}