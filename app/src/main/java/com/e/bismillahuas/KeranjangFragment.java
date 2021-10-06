package com.e.bismillahuas;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KeranjangFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KeranjangFragment extends Fragment/* implements View.OnClickListener*/ {

    private Spinner brand, jenis;
    private Button total;
    private EditText namap;
    private EditText jmlh;
    private EditText telpon;
    private EditText address;
    private RadioGroup cash;
    private SharedViewModel viewModel;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private KeranjangListener listener;
    private int harga;

    public KeranjangFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KeranjangFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KeranjangFragment newInstance(String param1, String param2) {
        KeranjangFragment fragment = new KeranjangFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            /*harga = getArguments().getString("harga");*/
        }
    }
    public interface KeranjangListener{
        void onInputAsent(CharSequence input);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_keranjang, container, false);

        brand = v.findViewById(R.id.brand);
        jenis = v.findViewById(R.id.jenis);
        total=v.findViewById(R.id.btntotal);
        namap=v.findViewById(R.id.namapelanggan);
        jmlh = v.findViewById(R.id.jumlah);
        telpon = v.findViewById(R.id.nomor);
        cash = v.findViewById(R.id.rg);
        address = v.findViewById(R.id.alamat);
        /*Bundle bundle = new Bundle();
        bundle.putString("namapelanggan",namap.getText().toString());
        ListFragment listFragment = new ListFragment();
        listFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.fragment_container,listFragment).commit();*/
        /*Bundle b = this.getArguments();
        produk=b.getString("produk");
        harga=b.getString("harga");*/
        /*tvproduk.setText(produk);
        tvharga.setText(harga);*/
        total.setOnClickListener(v1 -> {
            if (jmlh.getText().toString().matches("")||telpon.getText().toString().matches("")||namap.getText().toString().matches("")||address.getText().toString().matches("")||cash.getCheckedRadioButtonId()==-1){
                Toast.makeText(getContext(),"Harap Isi Semua Data",Toast.LENGTH_SHORT).show();
            }else {
                setHarga();
                Bundle b = new Bundle();
                b.putString("harga", String.valueOf(harga));
                b.putString("jumlah", jmlh.getText().toString());
                TotalFragment totalFragment = new TotalFragment();
                totalFragment.setArguments(b);
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragkeranjang,totalFragment).commit();

            /*CharSequence input = namap.getText().toString();
            listener.onInputAsent(input);*/
                /*viewModel.setText(namap.getText().toString());*/
            /*Intent intent = new Intent(getActivity(),MainActivity.class);
            intent.putExtra("nama",namap.getText().toString());*/
            }

        });
  /*      total.setOnClickListener(this);
        lanjut.setOnClickListener(this);*/
        return v;
    }
    public void update(CharSequence text){
        namap.setText(text);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof KeranjangListener){
            listener = (KeranjangListener) context;
        }else {
            throw new RuntimeException(context.toString()
            +" must implement KeranjangFragmenr");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        viewModel.getText().observe(getViewLifecycleOwner(), new Observer<CharSequence>() {
            @Override
            public void onChanged(CharSequence charSequence) {
                namap.setText(charSequence);
            }
        });
    }

    public void setHarga() {
            if (brand.getSelectedItem().toString().equals("Aqua")) {
                if (jenis.getSelectedItem().toString().equals("Galon")) {
                    harga = 21500;
                } else if (jenis.getSelectedItem().toString().equals("Gelas")) {
                    harga = 25000;
                } else if (jenis.getSelectedItem().toString().equals("Botol")) {
                    harga = 3000;
                }
            } else if (brand.getSelectedItem().toString().equals("Cleo")) {
                if (jenis.getSelectedItem().toString().equals("Galon")) {
                    harga = 21000;
                } else if (jenis.getSelectedItem().toString().equals("Gelas")) {
                    harga = 28000;
                } else if (jenis.getSelectedItem().toString().equals("Botol")) {
                    harga = 3000;

                }
            } else if (brand.getSelectedItem().toString().equals("Club")) {
                if (jenis.getSelectedItem().toString().equals("Galon")) {
                    harga = 15000;
                } else if (jenis.getSelectedItem().toString().equals("Gelas")) {
                    harga = 20000;
                } else if (jenis.getSelectedItem().toString().equals("Botol")) {
                    harga = 2000;

                }
            } else if (brand.getSelectedItem().toString().equals("Vit")) {
                if (jenis.getSelectedItem().toString().equals("Galon")) {
                    harga = 16000;
                } else if (jenis.getSelectedItem().toString().equals("Gelas")) {
                    harga = 20000;
                } else if (jenis.getSelectedItem().toString().equals("Botol")) {
                    harga = 2700;

                }
            }
        }

/*    @Override
    public void onClick(View v) {
        if (v == lanjut){
            Intent i = new Intent(getActivity(),Complete.class);
            startActivity(i);


        }else if (v == total){
            setHarga();
            Bundle b = new Bundle();
            b.putString("harga", String.valueOf(harga));
            TotalFragment totalFragment = new TotalFragment();
            totalFragment.setArguments(b);
            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragkeranjang,totalFragment).commit();
        }
    }*/
}