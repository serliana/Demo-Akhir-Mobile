package com.example.project;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import android.os.Bundle;
import android.widget.TextView;
import java.util.List;

import android.os.Bundle;

public class cartdata extends AppCompatActivity {
    RecyclerView recview;
    TextView rateview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartdata);
        getSupportActionBar().hide();

        rateview = findViewById(R.id.rateview);
        getroomdata();
    }
    public void  getroomdata(){
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "cart_db").allowMainThreadQueries().build();
        PenjualanDao penjualanDao = db.PenjualanDao();
        recview = findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        List<PenjualanDB> penjualanDBS = penjualanDao.getallpenjualanDB();

        myadapter adapter = new myadapter(penjualanDBS, rateview);
        recview.setAdapter(adapter);

        int sum = 0,i;
        for (i=0; i<penjualanDBS.size();i++)
            sum = sum+(penjualanDBS.get(i).getPrice()*penjualanDBS.get(i).getQnt());

        rateview.setText("Total Penjualan : RP."+sum);


    }
}