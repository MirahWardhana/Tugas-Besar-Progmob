package com.example.practicenew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Final extends AppCompatActivity {
    String username= DashboardUser.uname;

    String shape= ShapePicker.shape;

    int colorred= ColorPicker.color_red;
    int colorgreen= ColorPicker.color_green;
    int colorblue= ColorPicker.color_blue;
    int coloralfa= ColorPicker.color_alfa;

    String s11=Sizing1.s1;
    String s12=Sizing1.s2;
    String s13=Sizing1.s3;
    String s14=Sizing1.s4;
    String s15=Sizing1.s5;
    String s16=Sizing1.s6;
    String s17=Sizing1.s7;

    String s21=Sizing2.s1;
    String s22=Sizing2.s2;
    String s23=Sizing2.s3;
    String s24=Sizing2.s4;
    String s25=Sizing2.s5;
    String s26=Sizing2.s6;
    String s27=Sizing2.s7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        if(s11!=null){
            String s1=s11;
            String s2=s12;
            String s3=s13;
            String s4=s14;
            String s5=s15;
            String s6=s16;
            String s7=s17;
        }else {
            String s1=s21;
            String s2=s22;
            String s3=s23;
            String s4=s24;
            String s5=s25;
            String s6=s26;
            String s7=s27;
        }


        Button button = (Button) findViewById(R.id.buttonFinalOrder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboardUser();

                //Masukin nilai variabel di atas ke database
            }
        });

        Button button2 = (Button) findViewById(R.id.buttonCancelOrder);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboardUser();
            }
        });

    }


    public void openDashboardUser(){
        Intent intent = new Intent(this,DashboardUser.class);
        startActivity(intent);
    }
}