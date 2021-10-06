package com.e.bismillahuas;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TotalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TotalFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button lanjut;
    // TODO: Rename and change types of parameters
    private String harga;
    private String jumlah;
    private TextView textViewharga;
    private TextView textViewtotal;
    private TextView textViewjumlah;
    private TextView textViewongkir;
    private double total;

    public TotalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TotalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TotalFragment newInstance(String param1, String param2) {
        TotalFragment fragment = new TotalFragment();
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
            harga = getArguments().getString("harga");
            jumlah = getArguments().getString("jumlah");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_total, container, false);
        textViewharga = v.findViewById(R.id.harga);
        textViewtotal = v.findViewById(R.id.total);
        textViewongkir = v.findViewById(R.id.ongkir);
        textViewjumlah = v.findViewById(R.id.jmlh);
        lanjut = v.findViewById(R.id.btnlanjut);
        Bundle b = this.getArguments();
        harga=b.getString("harga");
        jumlah=b.getString("jumlah");
        textViewharga.setText(harga);
        textViewjumlah.setText(jumlah);
        total = (Integer.parseInt(harga) *Integer.parseInt(jumlah))+ Integer.parseInt(textViewongkir.getText().toString());
        textViewtotal.setText(String.valueOf(total));
        lanjut.setOnClickListener(v1 -> {
            Intent i = new Intent(getActivity(),Complete.class);
            startActivity(i);
        });
        return v;
    }
}