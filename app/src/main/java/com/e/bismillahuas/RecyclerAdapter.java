package com.e.bismillahuas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    ArrayList<PojoClass> pojoClasses;
    /*String[]nama;
    int[]image;
    Context context;
    String[]deskripsi;*/
    public RecyclerAdapter(ArrayList<PojoClass> pojoClasses/*,Context ct,String[]name,int[]images,String[]descrip*/) {
        this.pojoClasses = pojoClasses;
        /*context=ct;
        nama=name;
        image=images;
        deskripsi=descrip;*/
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PojoClass pojoClass = pojoClasses.get(position);
        Glide.with(holder.itemView.getContext()).load(pojoClass.getGambar()).into(holder.imageView);
        holder.nama.setText(pojoClass.getNamatoko());
        holder.alamat.setText(pojoClass.getAlamat());
        /*holder.itemView.setOnClickListener(v -> {
            Intent intent =new Intent(context,Rating.class);
            intent.putExtra("nama",nama[position]);
            intent.putExtra("desc",deskripsi[position]);
            intent.putExtra("gambar",image[position]);
            context.startActivity(intent);


        });*/

    }

    @Override
    public int getItemCount() {
        return pojoClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView nama,alamat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.foto);
            nama = itemView.findViewById(R.id.namatoko);
            alamat = itemView.findViewById(R.id.alamat);
        }
    }
}
