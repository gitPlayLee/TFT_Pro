package com.example.TFTclientPro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.tftstats2.Fragment_Profile;
import com.example.tftstats2.Fragment_Save;
import com.example.tftstats2.Fragment_Search;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class bottomview_ctr extends AppCompatActivity{

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Fragment_Search fragment_search = new Fragment_Search();
    private Fragment_Save fragment_save = new Fragment_Save();
    private Fragment_Profile fragment_profile = new Fragment_Profile();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_login);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragment_search).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(menuItem.getItemId())
            {
                case R.id.searchItem:
                    transaction.replace(R.id.frameLayout, fragment_search).commitAllowingStateLoss();
                    break;
                case R.id.cameraItem:
                    transaction.replace(R.id.frameLayout, fragment_save).commitAllowingStateLoss();
                    break;
                case R.id.callItem:
                    transaction.replace(R.id.frameLayout, fragment_profile).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }
}

