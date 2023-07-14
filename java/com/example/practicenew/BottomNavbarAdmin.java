package com.example.practicenew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;

import com.example.practicenew.databinding.ActivityBottomNavbarAdminBinding;
import com.example.practicenew.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavbarAdmin extends AppCompatActivity {
//    ActivityBottomNavbarAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navbar_admin);
//        binding = ActivityBottomNavbarAdminBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this, R.id.adminFragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

//        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.home:
//                    startActivity(new Intent(getApplicationContext(),DashboardAdmin.class));
//                    break;
//                case R.id.order:
//                    startActivity(new Intent(getApplicationContext(),OrderDetailAdmin.class));
//                    break;
//
//            }
//            return true;
//        });

    }


}
