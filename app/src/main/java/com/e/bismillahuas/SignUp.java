package com.e.bismillahuas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    EditText pw,confirmpw,mail,uname;
    Button signup;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mail=findViewById(R.id.email);
        uname=findViewById(R.id.uname);
        pw=findViewById(R.id.pw);
        confirmpw=findViewById(R.id.confirmpw);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.btnsignup);

        signup.setOnClickListener(v -> {
            if (mail.getText().toString().matches("")) {
                Toast.makeText(getApplicationContext(), "E-Mail belum diisi", Toast.LENGTH_LONG).show();
            }else if (uname.getText().toString().matches("")){
                Toast.makeText(getApplicationContext(),"Username belum diisi",Toast.LENGTH_LONG).show();
            }else if (pw.getText().toString().matches("")){
                Toast.makeText(getApplicationContext(),"Password belum diisi",Toast.LENGTH_LONG).show();
            }else if (confirmpw.getText().toString().matches("")){
                Toast.makeText(getApplicationContext(),"Konfirmasi Password belum diisi",Toast.LENGTH_LONG).show();
            }else {
                if (confirmpw.getText().toString().equals(pw.getText().toString())) {
                    Toast.makeText(SignUp.this, "Sign Up SUCCEED", Toast.LENGTH_SHORT).show();
                    Intent input = new Intent(getApplicationContext(), Isi_data_diri.class);
                    startActivity(input);

                } else {
                    Toast.makeText(SignUp.this, "Sign Up FAILED", Toast.LENGTH_SHORT).show();
                }
            }
        });
        login.setOnClickListener(v -> {
            Intent lgn = new Intent(getApplicationContext(),Login.class);
            startActivity(lgn);
        });

    }
}