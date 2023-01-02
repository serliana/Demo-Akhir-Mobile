package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import android.os.Bundle;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {
    List<PenjualanDB> penjualanDBS;
    TextView rateview;
    public myadapter(List<PenjualanDB> penjualanDBS, TextView rateview){
        this.penjualanDBS = penjualanDBS;
        this.rateview = rateview;
    }
    @NonNull
    @NotNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design, parent, false);
        return new myviewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull @NotNull myadapter.myviewholder holder, int position) {
        holder.recid.setText(String.valueOf(penjualanDBS.get(position).getPid()));
        holder.recpname.setText(penjualanDBS.get(position).getPname());
        holder.recpprice.setText(String.valueOf(penjualanDBS.get(position).getPrice()));
        holder.recqnt.setText(String.valueOf(penjualanDBS.get(position).getQnt()));

        holder.delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db = Room.databaseBuilder(holder.recid.getContext(),
                        AppDatabase.class, "cart_db").allowMainThreadQueries().build();
                PenjualanDao penjualanDao = db.PenjualanDao();

                penjualanDao.deleteById(penjualanDBS.get(position).getPid());
                penjualanDBS.remove(position);
                notifyItemRemoved(position);
                updateprice();
            }
        });

    }
    @Override
    public int getItemCount() {
        return penjualanDBS.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView recid,recpname,recqnt, recpprice;
        ImageButton delbtn;
        public myviewholder(@NonNull @NotNull View itemView) {
            super(itemView);

            recid=itemView.findViewById(R.id.recid);
            recpname=itemView.findViewById(R.id.recpname);
            recpprice=itemView.findViewById(R.id.recpprice);
            recqnt=itemView.findViewById(R.id.recqnt);
            delbtn=itemView.findViewById(R.id.delbtn);
        }
    }
    public void updateprice()
    {
        int sum=0,i;
        for(i=0;i< penjualanDBS.size();i++)
            sum=sum+(penjualanDBS.get(i).getPrice()*penjualanDBS.get(i).getQnt());

        rateview.setText("Total Amount : INR "+sum);
    }
}