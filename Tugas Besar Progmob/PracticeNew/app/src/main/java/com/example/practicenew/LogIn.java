package com.example.practicenew;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {
    public static String username,name,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        EditText inputUsername=(EditText)findViewById(R.id.textUsernameLogin);

        Button button = (Button) findViewById(R.id.buttonLogIn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                username=inputUsername.getText().toString();
                name="?";
                email="?";

                if (username=="MirahWardhana"){
                    openDashboardAdmin();
                }
                else {
                    openDashboardUser();
                }

            }
        });
        TextView textRegister=(TextView)findViewById(R.id.textRegister);
        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUp();
            }
        });

    }

    public void openDashboardUser(){
        Intent intent = new Intent(this,DashboardUser.class);
        startActivity(intent);
    }

    public void openDashboardAdmin(){
        Intent intent = new Intent(this,DashboardAdmin.class);
        startActivity(intent);
    }

    public void openSignUp(){
        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
    }

}