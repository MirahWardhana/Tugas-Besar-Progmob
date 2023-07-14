package com.example.practicenew;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
    public static String Username,Password,Name,Email;
    DataBaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        EditText inputUsername=(EditText)findViewById(R.id.textUsernameLogin);
        EditText inputPassword=(EditText)findViewById(R.id.textPasswordLogin);
        Button button = (Button) findViewById(R.id.buttonLogIn1);
        DB = new DataBaseHelper(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Username=inputUsername.getText().toString();
                Password=inputPassword.getText().toString();

                if (Username.equals("")||Password.equals("")){
                    Toast.makeText(LogIn.this,"Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkuserdata=DB.checkuserdata(Username,Password);
                    if(checkuserdata==true){
                        if(Username.equals("MirahWardhana")){
                            Toast.makeText(LogIn.this,"Successfully login as admin", Toast.LENGTH_SHORT).show();
                            openDashboardAdmin();
                        }else {
                            Toast.makeText(LogIn.this,"Successfully login", Toast.LENGTH_SHORT).show();
                            openDashboardUser();
                        }
                    }else{
                        Toast.makeText(LogIn.this,"Incorrect username or password", Toast.LENGTH_SHORT).show();
                    }
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
        Intent intent = new Intent(this,BottomNavbarAdmin.class);
        startActivity(intent);
    }

    public void openSignUp(){
        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
    }

}