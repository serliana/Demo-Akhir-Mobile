package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Penjualan extends AppCompatActivity {
    EditText t1,t2,t3,t4;
    Button b1,b2;
    TextView lbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjualan);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        lbl = findViewById(R.id.lbl);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "cart_db").allowMainThreadQueries().build();
                PenjualanDao penjualanDao = db.PenjualanDao();
                Boolean check = penjualanDao.is_exist(Integer.parseInt(t1.getText().toString()));
                if (check == false)
                {
                    int pid = Integer.parseInt(t1.getText().toString());
                    String pname = t2.getText().toString();
                    int price = Integer.parseInt(t3.getText().toString());
                    int qnt = Integer.parseInt(t4.getText().toString());
                    penjualanDao.insertrecord(new PenjualanDB(pid, pname, price, qnt));
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    lbl.setText("Produk Inserted Succesfully");
                }else {
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    lbl.setText("Product Already in Cart");
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),cartdata.class));
            }
        });
        }
}
