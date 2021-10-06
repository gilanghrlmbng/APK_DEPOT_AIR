package com.e.bismillahuas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Rating extends AppCompatActivity {
    ImageView imageView;
    TextView description;
    TextView namee;
    String nama;
    String desk;
    int gambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        imageView=findViewById(R.id.carousel);
        description=findViewById(R.id.desc);
        namee=findViewById(R.id.nameof);
        getData();
        setData();
    }
    private void getData(){
        if (getIntent().hasExtra("gambar")&&getIntent().hasExtra("nama")&&getIntent().hasExtra("desc")){

            nama=getIntent().getStringExtra("nama");
            desk=getIntent().getStringExtra("desc");
            gambar=getIntent().getIntExtra("gambar",1);

        }else {
            Toast.makeText(this,"No data found",Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        namee.setText(nama);
        description.setText(desk);
        imageView.setImageResource(gambar);
    }
}