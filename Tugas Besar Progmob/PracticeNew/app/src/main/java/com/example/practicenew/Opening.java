package com.example.practicenew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Opening extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        Button button = (Button) findViewById(R.id.buttonLogIn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogIn();
            }
        });

        Button button2 = (Button) findViewById(R.id.buttonSignUp);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUp();
            }
        });
    }

    private void openLogIn() {
        Intent intent = new Intent(this,LogIn.class);
        startActivity(intent);
    }

    private void openSignUp() {
        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
    }
}