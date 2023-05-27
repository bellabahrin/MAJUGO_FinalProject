package com.example.majugoscreen;

import androidx.annotation.NonNull;

import com.example.majugoscreen.Model.Users;
import com.example.majugoscreen.Prevalent.Prevalent;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import io.paperdb.Paper;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);


        loadFragment(new HomeFragment());

        Paper.init(this);

    }
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.homeItem:
                fragment = new HomeFragment();
                break;

            case R.id.ratesItem:
                fragment = new RatesFragment();
                break;

            case R.id.scheduleItem:
                fragment = new ScheduleFragment();
                break;

            case R.id.profileItem:
                fragment = new ProfileFragment();
                break;
        }

        return loadFragment(fragment);


    }
    
}
    

