package com.example.practicenew;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Final extends AppCompatActivity {

    DataBaseHelper DB;

    RadioGroup radioGroupFabric;
    RadioGroup radioGroupWood;
    RadioButton radioButton1;
    RadioButton radioButton2;
    EditText textnote;

    String wood, fabric, order_date, order_status, note;
    int price;

    String s1, s2, s3, s4, s5, s6, s7, s8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        DB = new DataBaseHelper(this);

        String username= DashboardUser.username1;
        String shape= ShapePicker.shape;

        int color_red= ColorPicker.color_red;
        int color_green= ColorPicker.color_green;
        int color_blue= ColorPicker.color_blue;
        int color_alfa= ColorPicker.color_alfa;

        String s11=Sizing1.s1;
        String s12=Sizing1.s2;
        String s13=Sizing1.s3;
        String s14=Sizing1.s4;
        String s15=Sizing1.s5;
        String s16=Sizing1.s6;
        String s17=Sizing1.s7;
        String s18=Sizing1.s8;

        String s21=Sizing2.s1;
        String s22=Sizing2.s2;
        String s23=Sizing2.s3;
        String s24=Sizing2.s4;
        String s25=Sizing2.s5;
        String s26=Sizing2.s6;
        String s27=Sizing2.s7;
        String s28=Sizing2.s8;

        if(!s11.equals("")){
            s1=s11;
            s2=s12;
            s3=s13;
            s4=s14;
            s5=s15;
            s6=s16;
            s7=s17;
            s8=s18;
        }else {
            s1=s21;
            s2=s22;
            s3=s23;
            s4=s24;
            s5=s25;
            s6=s26;
            s7=s27;
            s8=s28;
        }

        radioGroupFabric=findViewById(R.id.radioGroupFabric);
        radioGroupWood=findViewById(R.id.radioGroupWood);

        textnote=findViewById(R.id.textNote4);

        Button button = findViewById(R.id.buttonCreateOrder);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                int radioId1 = radioGroupFabric.getCheckedRadioButtonId();
                int radioId2 = radioGroupWood.getCheckedRadioButtonId();

                radioButton1 = findViewById(radioId1);
                String Fabric = radioButton1.getText().toString();
                if (Fabric.equals("radioButtonCotton")) {
                    fabric = "Cotton";
                } else if (Fabric.equals("radioButtonLinen")) {
                    fabric = "Linen";
                } else {
                    fabric = "Leather";
                }

                radioButton2 = findViewById(radioId2);
                String Wood = radioButton2.getText().toString();
                if (Wood.equals("radioButtonMahogany")) {
                    wood = "Mahogany";
                } else if (Wood.equals("radioButtonOak")) {
                    wood = "Oak";
                } else {
                    wood = "Teak";
                }
                note = textnote.getText().toString();

                price = 0;

                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                order_date = currentDateTime.format(formatter);

                order_status = "new order!";
                System.out.println(username);
                System.out.println(shape);
                System.out.println(color_red);
                System.out.println(color_green);
                System.out.println(color_blue);
                System.out.println(color_alfa);
                System.out.println(s1+s2+s3);
                System.out.println(wood);
                System.out.println(fabric);

                Boolean checkinsertorderuser = DB.insertorderuser(username, shape, color_red, color_green, color_blue, color_alfa, s1, s2, s3, s4, s5, s6, s7, s8, wood, fabric, order_date, order_status, price, note);if (checkinsertorderuser == true) {
                    Toast.makeText(Final.this, "New Entry successfully inserted", Toast.LENGTH_SHORT).show();
                    openDashboardUser();
                } else {
                    Toast.makeText(Final.this, "New Entry not inserted", Toast.LENGTH_SHORT).show();
                }
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

    public void checkButton(View v){
        int radioId1 = radioGroupFabric.getCheckedRadioButtonId();
        int radioId2 = radioGroupWood.getCheckedRadioButtonId();

        radioButton1 = findViewById(radioId1);
        String Fabric = radioButton1.getText().toString();
        if (Fabric.equals("radioButtonCotton")) {
            fabric = "Cotton";
        } else if (Fabric.equals("radioButtonLinen")) {
            fabric = "Linen";
        } else {
            fabric = "Teak";
        }

        radioButton2 = findViewById(radioId2);
        String Wood = radioButton2.getText().toString();
        if (Wood.equals("radioButtonMahogany")) {
            wood = "Mahogany";
        } else if (Wood.equals("radioButtonOak")) {
            wood = "Oak";
        } else {
            wood = "Teak";
        }
    }
}