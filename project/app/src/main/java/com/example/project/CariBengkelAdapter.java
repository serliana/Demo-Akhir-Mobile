package com.example.project;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CariBengkelAdapter extends BaseAdapter {
    private Context context;
    private List<Bengkel> bengkel;

    private static class ViewHolder {
        ImageView photo;
        TextView name;
        TextView address;
        TextView price;
    }

    public CariBengkelAdapter(Activity activity, List<Bengkel> bengkel) {
        this.context = activity.getBaseContext();
        this.bengkel = bengkel;
    }

    @Override
    public int getCount() {
        return bengkel.size();
    }

    @Override
    public Object getItem(int id) {
        return bengkel.get(id);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int pos, View v, ViewGroup vGroup) {
        // TODO Auto-generated method stub

        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (v == null) {
            holder = new ViewHolder();

            v = inflater.inflate(R.layout.list_cari_bengkel, vGroup, false);

            holder.photo = v.findViewById(R.id.photo);
            holder.name = v.findViewById(R.id.name);
            holder.address = v.findViewById(R.id.address);
            holder.price = v.findViewById(R.id.price);

            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();

        }

        Bengkel p = bengkel.get(pos);

        holder.photo.setImageResource(p.getPhotoId());
        holder.name.setText(p.getName());
        holder.address.setText(p.getAddress());
        holder.price.setText(p.getPrice());


        return v;
    }
}


