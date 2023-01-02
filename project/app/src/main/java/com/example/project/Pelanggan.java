package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.MenuItem;
import java.util.ArrayList;

import java.util.ArrayList;

import android.os.Bundle;

public class Pelanggan extends AppCompatActivity {
    SearchView searchView;
    RecyclerView recyclerView;
    ArrayList<ModelClass> arrayList = new ArrayList<>();
    ArrayList<ModelClass> searchList;

    String[] listPelanggan = new String[] {"Miftahul Fauzi", "Zainul Fakhri", "Awi Maulana", "Rahmadani Ramli",
            "Ikmal", "Awwir Wahyudin", "Awal Prasetya", "Reyhan Amal", "Agung Prasetyo", "Nur Farid Mufid", "Muiz Muharram",
            "Hayar Usman", "Adam", "Aswar Fajar", "Alif Daffa", "Fajratul Ikhsan", "Rizky Madya"};

    String[] numPelanggan  = new String[] {"Makassar", "Makassar","BalikPapan", "Manado", "Manado",
            "Makassar", "Pekanbaru", "Bogor", "Bandung", "Bandung", "Jakarta", "Denpasar",
            "Denpasar", "Aceh", "Medan", "Medan", "Medan"};

    int[] listImg = new int[] {R.drawable.plg1, R.drawable.plg2, R.drawable.plg3, R.drawable.plg4,
            R.drawable.plg6, R.drawable.plg7, R.drawable.plg8, R.drawable.plg9, R.drawable.plg10,
            R.drawable.plg11, R.drawable.plg12, R.drawable.plg13, R.drawable.plg14, R.drawable.plg15,
            R.drawable.plg16, R.drawable.plg17, R.drawable.plg18};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelanggan);

        Toolbar toolbar = findViewById(R.id.plg);
        this.setTitle("Pelanggan");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.SearchView);
        searchView.setIconified(false);
        searchView.clearFocus();

        for (int i=0; i<listPelanggan.length; i++){
            ModelClass modelClass = new ModelClass();
            modelClass.setNamaPelanggan(listPelanggan[i]);
            modelClass.setNumPelanggan(numPelanggan[i]);
            modelClass.setImg(listImg[i]);
            arrayList.add(modelClass);
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Pelanggan.this);
        recyclerView.setLayoutManager(layoutManager);

        PelangganAdapter pelangganAdapter = new PelangganAdapter(Pelanggan.this,arrayList);
        recyclerView.setAdapter(pelangganAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit (String query){
                searchList = new ArrayList<>();

                if (query.length()>0){
                    for (int i=0; i<arrayList.size(); i++){
                        if (arrayList.get(i).getNamaPelanggan().toUpperCase().contains(query.toUpperCase()) || arrayList.get(i).getNumPelanggan().toUpperCase().contains(query.toUpperCase())){
                            ModelClass modelClass = new ModelClass();
                            modelClass.setNamaPelanggan(arrayList.get(i).getNamaPelanggan());
                            modelClass.setNumPelanggan(arrayList.get(i).getNumPelanggan());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchList.add(modelClass);
                        }
                    }
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Pelanggan.this);
                    recyclerView.setLayoutManager(layoutManager);
                    PelangganAdapter pelangganAdapter = new PelangganAdapter(Pelanggan.this,searchList);
                    recyclerView.setAdapter(pelangganAdapter);
                }else {
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Pelanggan.this);
                    recyclerView.setLayoutManager(layoutManager);

                    PelangganAdapter pelangganAdapter = new PelangganAdapter(Pelanggan.this,arrayList);
                    recyclerView.setAdapter(pelangganAdapter);
                }
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText){
                searchList = new ArrayList<>();

                if (newText.length()>0){
                    for (int i = 0; i < arrayList.size(); i++){
                        if (arrayList.get(i).getNamaPelanggan().toUpperCase().contains(newText.toUpperCase()) || arrayList.get(i).getNumPelanggan().toUpperCase().contains(newText.toUpperCase())){
                            ModelClass modelClass = new ModelClass();
                            modelClass.setNamaPelanggan(arrayList.get(i).getNamaPelanggan());
                            modelClass.setNumPelanggan(arrayList.get(i).getNumPelanggan());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchList.add(modelClass);
                        }
                    }
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Pelanggan.this);
                    recyclerView.setLayoutManager(layoutManager);
                    PelangganAdapter pelangganAdapter = new PelangganAdapter(Pelanggan.this,searchList);
                    recyclerView.setAdapter(pelangganAdapter);
                }
                else {
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Pelanggan.this);
                    recyclerView.setLayoutManager(layoutManager);

                    PelangganAdapter pelangganAdapter = new PelangganAdapter(Pelanggan.this,arrayList);
                    recyclerView.setAdapter(pelangganAdapter);
                }
                return false;
            }
        });
    }
}