package com.example.practicenew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sizing2 extends AppCompatActivity {
    EditText inputS1, inputS2,inputS3,inputS4,inputS5,inputS6,inputS7;
    public static String s1,s2,s3,s4,s5,s6,s7,s8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sizing2);

        inputS1=(EditText)findViewById(R.id.textS1);
        inputS2=(EditText)findViewById(R.id.textS2);
        inputS3=(EditText)findViewById(R.id.textS3);
        inputS4=(EditText)findViewById(R.id.textS4);
        inputS5=(EditText)findViewById(R.id.textS5);
        inputS6=(EditText)findViewById(R.id.textS6);
        inputS7=(EditText)findViewById(R.id.textS7);


        Button button = (Button) findViewById(R.id.buttonSizing);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=inputS1.getText().toString();
                s2=inputS2.getText().toString();
                s3=inputS3.getText().toString();
                s4=inputS4.getText().toString();
                s5=inputS5.getText().toString();
                s6=inputS6.getText().toString();
                s7=inputS7.getText().toString();
                s8="0";

                if (s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals("")||s7.equals("")){
                    Toast.makeText(Sizing2.this,"Please set all the fields", Toast.LENGTH_SHORT).show();

                }
                else {
                    openColorPicker();

                }

            }
        });
    }

    public void openColorPicker(){
        Intent intent = new Intent(this,ColorPicker.class);
        startActivity(intent);
    }
}