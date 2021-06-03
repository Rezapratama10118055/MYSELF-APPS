package com.example.myselfapps.Daily;


import android.content.Context;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myselfapps.R;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>{

    private ArrayList<itemModel>dataItem;

    //03/06/2021, 10118055, Reza Pratama, If-2
    AdapterRecyclerView(ArrayList<itemModel>data){
        this.dataItem = data;
    }


    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_vertical,parent,false);
        return new ViewHolder(view);

    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView nama = holder.name;
        ImageView image = holder.images;
        TextView waktu = holder.waktu;

        nama.setText(dataItem.get(position).getName());
        waktu.setText(dataItem.get(position).getWaktu());
        image.setImageResource(dataItem.get(position).getImages());
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name,waktu;
        private ImageView images;
        public ViewHolder(@NonNull View v) {
            super(v);
            name = v.findViewById(R.id.name);
            images = v.findViewById(R.id.image);
            waktu = v.findViewById(R.id.waktu);

        }
    }


}
