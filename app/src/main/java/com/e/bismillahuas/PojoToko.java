package com.e.bismillahuas;

import java.util.ArrayList;

public class PojoToko {

    public static String[]namatoko={
        "AL - FAZZA","ANUGRAH GALON","NATURAL WATER","AL - MUBARAK"
    };
    public static String[]alamat={
        "Jl. Raya Prapen No.59, Panjang Jiwo, Kec. Tenggilis Mejoyo, Kota SBY, Jawa Timur 60299", "Jl. Rungkut Asri Tengah, Rungkut Kidul, Kec. Rungkut, Kota SBY, Jawa Timur 60293","Perum YKP IV Blok KK, Jl. Raya Tenggilis Mejoyo, Kali Rungkut, Kec. Rungkut, Kota SBY, Jawa Timur 60292","Jl. Dukuh Menanggal Sel. No.103, Dukuh Menanggal, Kec. Gayungan, Kota SBY, Jawa Timur 60234"
    };
    public static int []gambar={
        R.drawable.depot1,R.drawable.depot2,R.drawable.depot3,R.drawable.depot4
    };

    public static ArrayList<PojoClass> getArrayData() {
        ArrayList<PojoClass> pojo = new ArrayList<>();
        for (int i = 0; i < gambar.length; i++) {
            PojoClass pojoclass = new PojoClass();
            pojoclass.setNamatoko(namatoko[i]);
            pojoclass.setAlamat(alamat[i]);
            pojoclass.setGambar(gambar[i]);
            pojo.add(pojoclass);

        }
        return pojo;
    }
}
