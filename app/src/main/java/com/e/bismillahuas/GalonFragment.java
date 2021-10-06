package com.e.bismillahuas;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalonFragment extends Fragment /*implements View.OnClickListener*/{

    private CardView card1, card2, card3, card4;
    private TextView haqua, hclub, hvit, hcleo;
    private TextView aqua, club, vit, cleo;
    private SharedViewModel viewModel;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public GalonFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GalonFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GalonFragment newInstance(String param1, String param2) {
        GalonFragment fragment = new GalonFragment();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_galon, container, false);
        card1 = v.findViewById(R.id.cardviewaqua);
        card2 = v.findViewById(R.id.cardviewclub);
        card3 = v.findViewById(R.id.cardviewcleo);
        card4 = v.findViewById(R.id.cardviewvit);
        haqua = v.findViewById(R.id.hrgaqua);
        hcleo = v.findViewById(R.id.hrgcleo);
        hclub = v.findViewById(R.id.hrgclub);
        hvit = v.findViewById(R.id.hrgvit);
        vit = v.findViewById(R.id.vit);
        club = v.findViewById(R.id.club);
        cleo = v.findViewById(R.id.cleo);
        aqua = v.findViewById(R.id.aqua);

        /*card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);*/

        return v;
    }

    /*@Override
    public void onClick(View v) {
        Bundle b = new Bundle();
        switch (v.getId()){
            case R.id.cardviewaqua:
                b.putString("produk",aqua.getText().toString());
                b.putString("harga",haqua.getText().toString());
                viewModel.setText((CharSequence) aqua);
            case R.id.cardviewcleo:
                b.putString("produk",cleo.getText().toString());
                b.putString("harga",hcleo.getText().toString());
                viewModel.setText((CharSequence) cleo);
            case R.id.cardviewclub:
                b.putString("produk",club.getText().toString());
                b.putString("harga",hclub.getText().toString());
                viewModel.setText((CharSequence) club);
            case R.id.cardviewvit:
                b.putString("produk",vit.getText().toString());
                b.putString("harga",hvit.getText().toString());
                viewModel.setText((CharSequence) vit);
        }

        KeranjangFragment fragment = new KeranjangFragment();
        fragment.setArguments(b);
        getFragmentManager().beginTransaction().replace(R.id.produk,fragment).commit();
    }*/
}