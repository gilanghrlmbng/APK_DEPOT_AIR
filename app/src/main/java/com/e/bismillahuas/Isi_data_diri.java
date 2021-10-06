package com.e.bismillahuas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Isi_data_diri extends AppCompatActivity {
    EditText nama,namalengkap,nomer,alamat;
    Button start;
    String tampilnama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_data_diri);

        nama=findViewById(R.id.nickname);
        namalengkap=findViewById(R.id.fullname);
        nomer=findViewById(R.id.nomor);
        alamat=findViewById(R.id.address);
        start=findViewById(R.id.btnlanjut);
        tampilnama= nama.getText().toString();
        start.setOnClickListener(v -> {
            if (nama.getText().toString().matches("")) {
                Toast.makeText(getApplicationContext(), "Harap isi semua data diri", Toast.LENGTH_LONG).show();
            }else if (namalengkap.getText().toString().matches("")){
                Toast.makeText(getApplicationContext(),"Harap isi semua data diri",Toast.LENGTH_LONG).show();
            }else if (nomer.getText().toString().matches("")){
                Toast.makeText(getApplicationContext(),"Harap isi semua data diri",Toast.LENGTH_LONG).show();
            }else if (alamat.getText().toString().matches("")){
                Toast.makeText(getApplicationContext(),"Harap isi semua data diri",Toast.LENGTH_LONG).show();
            }else {

/*                Bundle b = new Bundle();
                b.putString("NAMA",tampilnama);*/
                Intent start = new Intent(getApplicationContext(), MainActivity.class);
                start.putExtra("nama",nama.getText().toString());
                /*DashBoardFragment dashBoardFragment = new DashBoardFragment();
                dashBoardFragment.setArguments(b);*/
                /*b.putString("NAMA",tampilnama);
                start.putExtras(b);*/
                startActivity(start);

            }
            /*Bundle b = new Bundle();
            String tampilnama= nama.getText().toString();
            b.putString("NAMA",tampilnama);
            *//*FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();*//*
            DashBoardFragment dashBoardFragment = new DashBoardFragment();
            *//*fragmentTransaction.replace(R.id.frame,infoFragment).commit();*//*
            dashBoardFragment.setArguments(b);*/

        });

    }
    public String getData(){
        return tampilnama;
    }
}