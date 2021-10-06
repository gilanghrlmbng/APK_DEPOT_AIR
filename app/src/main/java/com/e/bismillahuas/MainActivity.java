package com.e.bismillahuas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity{
    ChipNavigationBar cnb;
    String tampilnama;
    private KeranjangFragment keranjangFragment;
    private ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*        Bundle b = getIntent().getExtras();
        tampilnama=b.getString("NAMA");*/
        cnb = findViewById(R.id.navbar);
        cnb.setItemSelected(R.id.dashboard,true);
        /*Bundle bundle = new Bundle();
        bundle.putString("TAMPIL NAMA",tampilnama);*/
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DashBoardFragment()).commit();
        /*FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        DashBoardFragment dashBoardFragment = new DashBoardFragment();
        fragmentTransaction.replace(R.id.fragment_container, dashBoardFragment).commit();
        dashBoardFragment.setArguments(b);*/
        Intent intent = getIntent();
        tampilnama = intent.getStringExtra("nama");
        Bundle bundle = new Bundle();
        cnb.setOnItemSelectedListener(i -> {
            Fragment fragment = null;
            switch (i){
                case R.id.dashboard:
                    bundle.putString("TAMPIL NAMA",tampilnama);
                    fragment = new DashBoardFragment();
                    fragment.setArguments(bundle);
                    break;
                case R.id.shopping:
                    fragment = new KeranjangFragment();
                    break;
                /*case R.id.list:
                    bundle.putString("TAMPIL NAMA",tampilnama);
                    fragment = new ListFragment();
                    fragment.setArguments(bundle);
                    break;*/
                case R.id.profil:
                    fragment = new ProfilFragment();
                    break;
                case R.id.store:
                    fragment = new TokoFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
        });
    }
}