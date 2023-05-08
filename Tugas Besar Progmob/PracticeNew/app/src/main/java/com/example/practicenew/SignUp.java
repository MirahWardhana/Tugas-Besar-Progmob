package com.example.practicenew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    public static String username, name, email, phone, password;
    EditText text_username, text_name, text_phone, text_email, text_password;
    Button insert;
    DataBaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        text_username=findViewById(R.id.textUsernameSignup);
        text_name=findViewById(R.id.textNameSignup);
        text_phone=findViewById(R.id.textPhoneSignup);
        text_email=findViewById(R.id.textEmailSignup);
        text_password=findViewById(R.id.textPasswordSignup);

        insert=findViewById(R.id.buttonSignUp1);

        DB= new DataBaseHelper(this);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = text_username.getText().toString();
                name = text_name.getText().toString();
                phone=text_phone.getText().toString();
                email=text_email.getText().toString();
                password=text_password.getText().toString();

                Boolean checkinsertuserdata= DB.insertuserdata( username, name, phone, email, password);
                if (checkinsertuserdata==true) {
                    Toast.makeText(SignUp.this, "New Entry successfully inserted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(SignUp.this, "New Entry not inserted", Toast.LENGTH_SHORT).show();
                }


            }
        });

        TextView textRegister=(TextView)findViewById(R.id.textLogin);
        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
    }


    public void openDashboardUser(){
        Intent intent = new Intent(this,DashboardUser.class);
        startActivity(intent);
    }
    public void openLogin(){
        Intent intent = new Intent(this,LogIn.class);
        startActivity(intent);
    }

}