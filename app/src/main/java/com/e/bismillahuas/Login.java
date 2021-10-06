package com.e.bismillahuas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText uname,pw,mail;
    Button login;
    TextView daftar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mail = findViewById(R.id.mail);
        uname = findViewById(R.id.uname);
        pw = findViewById(R.id.pw);
        login = findViewById(R.id.lgn);
        daftar = findViewById(R.id.regis);

        daftar.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == daftar){
            Intent dftr = new Intent(getApplicationContext(),SignUp.class);
            startActivity(dftr);
        } else if (v == login){
            if (uname.getText().toString().equals("gilang")&&pw.getText().toString().equals("505050")&&mail.getText().toString().equals("gilangherlambang09@gmail.com")){
                Intent lgn = new Intent(getApplicationContext(),MainActivity.class);
                Snackbar sbsukses = Snackbar.make(v.getRootView(),"Login Succeed",Snackbar.LENGTH_LONG);
                sbsukses.show();
                startActivity(lgn);

            }else {
                Snackbar sbfail = Snackbar.make(v.getRootView(),"Login Failed",Snackbar.LENGTH_LONG);
                sbfail.show();
            }
        }
    }
}