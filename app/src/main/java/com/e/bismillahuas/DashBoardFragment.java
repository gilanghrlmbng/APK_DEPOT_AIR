package com.e.bismillahuas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashBoardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashBoardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    ViewPager2 viewPager;
    View v;
    TabLayout tabLayout;
    String namatampil;
    TextView tvnama;
    Isi_data_diri isi_data_diri;
    public DashBoardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashBoardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashBoardFragment newInstance(String param1, String param2) {
        DashBoardFragment fragment = new DashBoardFragment();
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
            namatampil= getArguments().getString("NAMA");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.fragment_dash_board, container, false);
        viewPager = v.findViewById(R.id.viewpager);
        tabLayout = v.findViewById(R.id.tablayout);
        tvnama = v.findViewById(R.id.nama);
        /*Isi_data_diri isiDataDiri = (Isi_data_diri) getActivity();
        assert isiDataDiri != null;*/
        /*namatampil = isiDataDiri.getData();*/
        /*String coba = getArguments().getString("NAMA");*/
        /*isi_data_diri = new Isi_data_diri();
        namatampil=isi_data_diri.getData();*/
        tvnama.setText(namatampil);
        viewPager.setAdapter(new PagerAdapter(this));
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager, (tab, position) -> {
                    switch (position){
                        case 0:{
                            tab.setText("Galon");
                            tab.setIcon(R.drawable.ic_gallon);

                            break;
                        }case 1:{
                            tab.setText("Botol");
                            tab.setIcon(R.drawable.ic_bottle);

                            break;
                        }case 2:{
                            tab.setText("Gelas");
                            tab.setIcon(R.drawable.ic_water_glass);

                            break;
                        }
                    }
                }
        );
        tabLayoutMediator.attach();
        return v;

    }

   /* @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager());
         pagerAdapter.addFragment(new GalonFragment(),"Galon");
         pagerAdapter.addFragment(new BotolFragment(),"Botol");
         pagerAdapter.addFragment(new GelasFragment(),"Gelas");

         viewPager.setAdapter(pagerAdapter);

    }*/
}