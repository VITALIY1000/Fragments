package com.vitalytyrenko.fragments;

import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment1 fragment = new Fragment1();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.action_search:
                    Fragment1 fragment1 = new Fragment1();
                    fragmentTransaction.replace(R.id.fragment_container, fragment1);
                    fragmentTransaction.commit();
                    return true;
                case R.id.action_settings:
                    Fragment2 fragment2 = new Fragment2();
                    fragmentTransaction.replace(R.id.fragment_container, fragment2);
                    fragmentTransaction.commit();
                    return true;
                case R.id.action_navigation:
                    Fragment3 fragment3 = new Fragment3();
                    fragmentTransaction.replace(R.id.fragment_container, fragment3);
                    fragmentTransaction.commit();
                    return true;
                default:
                    return false;
            }
        }
    };

}
