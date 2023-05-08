package com.example.practicenew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sizing2 extends AppCompatActivity {
    public static String s1,s2,s3,s4,s5,s6,s7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sizing2);

        Button button = (Button) findViewById(R.id.buttonSizing);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker();
            }
        });
    }

    public void openColorPicker(){
        Intent intent = new Intent(this,ColorPicker.class);
        startActivity(intent);
    }
}