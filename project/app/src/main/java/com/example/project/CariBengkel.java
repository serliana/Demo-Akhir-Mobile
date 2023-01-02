package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CariBengkel extends AppCompatActivity {
    SearchView searchView;
    ListView listView;

    ArrayList<Bengkel> arrayList = new ArrayList<Bengkel>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_bengkel);

        Toolbar toolbar = findViewById(R.id.toolbar);
        this.setTitle("Cari Bengkel");
        //getSupportActionBar().setTitle("Cari Bengkel");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        searchView = findViewById(R.id.search_bar);
        listView = findViewById(R.id.list_view);


        CariBengkelAdapter adapter=new CariBengkelAdapter(this,buatBengkel());


        listView.setAdapter(adapter);

        //arrayAdapter = new CariBengkelAdapter(this,arrayList);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        //final Adapter adapter1 = new Adapter(this,buatBengkel());

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                CariBengkel.this.arrayAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                CariBengkel.this.arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });

    }


    private List<Bengkel> buatBengkel(){
        List<Bengkel>data=new ArrayList<>();
        data.add(new Bengkel(R.drawable.bengkel_1,"Bengkel Alif Motor","Jalan Poros Malino, Bontomanai, Bontomarannu, Kabupaten Gowa, Sulawesi Selatan 92171, Indonesia","Jasa mulai 20.000"));
        data.add(new Bengkel(R.drawable.bengkel_2,"Bengkel Andal Motor","Pakatto, Bontomarannu, Kabupaten Gowa, Sulawesi Selatan 92171, Indonesia\n" +
                "\n","Jasa mulai 20.000"));
        data.add(new Bengkel(R.drawable.bengkel_3,"Bengkel Aliyah Motor","Jl. Swadaya V No.1, Tompobalang, Somba Opu, Kabupaten Gowa, Sulawesi Selatan 92112, Indonesia","Jasa mulai 25.000"));
        data.add(new Bengkel(R.drawable.bengkel_4,"Bengkel Yamaha Darma Motor II","Mata Allo, Bajeng, Kabupaten Gowa, Sulawesi Selatan 92152, Indonesia","Jasa mulai 30.000"));
        data.add(new Bengkel(R.drawable.bengkel_5,"Bengkel Motor Bongki","Tombolo, Kel. Kec. Kab. Sul-Sel, Tamaona, Tombolo Pao, Kabupaten Gowa, Sulawesi Selatan 92171, Indonesia","Jasa mulai 35.000"));
        data.add(new Bengkel(R.drawable.bengkel_6,"Bengkel Asbak Motor","Watu-watu,, Julupamai, Pallangga, Kabupaten Gowa, Sulawesi Selatan 92161, Indonesia","Jasa mulai 10.000"));
        data.add(new Bengkel(R.drawable.bengkel_7,"Bengkel Harapan Motor","Jl. Andi Tonro No.49, Sungguminasa, Somba Opu, Kabupaten Gowa, Sulawesi Selatan 92113, Indonesia","Jasa mulai 15.000"));
        data.add(new Bengkel(R.drawable.bengkel_8,"Rr Motor","Jalan Poros Malino No.27A, Tamarunang, Somba Opu, Kabupaten Gowa, Sulawesi Selatan 92117, Indonesia","Jasa mulai 40.000"));
        data.add(new Bengkel(R.drawable.bengkel_9,"Bengkel Akbar Motor","Jl. Malino, Tompobalang, Somba Opu, Kabupaten Gowa, Sulawesi Selatan 92113, Indonesia","Jasa mulai 45.000"));
        data.add(new Bengkel(R.drawable.bengkel_10,"Bhaba Motor Gowa","Jl. Kacong Dg. Lalang, Tombolo, Somba Opu, Kabupaten Gowa, Sulawesi Selatan 92114, Indonesia","Jasa mulai 50.000"));
        data.add(new Bengkel(R.drawable.bengkel_11,"Gowa Motor","Jalan Poros Malino, Bontoramba, Somba Opu, Kabupaten Gowa, Sulawesi Selatan 92117, Indonesia","Jasa mulai 20.000"));
        data.add(new Bengkel(R.drawable.bengkel_12,"Bengkel Hadi Jaya Motor","Jabdul kadir daeng suro no.3 poros samata raya, Samata, Somba Opu, Kabupaten Gowa, Sulawesi Selatan 90235, Indonesia","Jasa mulai 25.000"));
        data.add(new Bengkel(R.drawable.bengkel_13,"Agung Jaya Motor","Jl. K. H. Wahid Hasyim No.187, Sungguminasa, Somba Opu, Kabupaten Gowa, Sulawesi Selatan 92113, Indonesia","Jasa mulai 30.000"));
        data.add(new Bengkel(R.drawable.bengkel_14,"Bengkel AA Motor","Jalan Poros Malino KM.102, Tamaona, Tombolo Pao, Kabupaten Gowa, Sulawesi Selatan 92171, Indonesia","Jasa mulai 35.000"));
        data.add(new Bengkel(R.drawable.bengkel_15,"Pallangga Jaya Motor 68","Jl. Poros Pallangga No.68, Bontoala, Pallangga, Kabupaten Gowa, Sulawesi Selatan 92111, Indonesia","Jasa mulai 40.000"));

        return data;
    }
}