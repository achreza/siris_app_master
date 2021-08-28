package com.example.reza.pbobeta;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class mainmenu extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.nav_barang:
                    barang barang = new barang();
                    transaction.replace(R.id.menuContainer,barang);
                    transaction.commit();
                    transaction.addToBackStack(null);
                    return true;
                case R.id.nav_kegiatan:
                    kegiatan kegiatan = new kegiatan();
                    transaction.replace(R.id.menuContainer,kegiatan);
                    transaction.commit();
                    transaction.addToBackStack(null);
                    return true;
                case R.id.nav_laporan:
                    laporan laporan = new laporan();
                    transaction.replace(R.id.menuContainer,laporan);
                    transaction.commit();
                    transaction.addToBackStack(null);
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        kegiatan kegiatan = new kegiatan();
        transaction.add(R.id.menuContainer,kegiatan);
        transaction.commit();



        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }





}
