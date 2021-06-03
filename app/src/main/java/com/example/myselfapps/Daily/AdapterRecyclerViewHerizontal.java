package com.example.myselfapps.Daily;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myselfapps.R;

import java.util.ArrayList;

public class AdapterRecyclerViewHerizontal extends RecyclerView.Adapter<AdapterRecyclerViewHerizontal.ViewHolder> {

    private ArrayList<itemModelTeman> dataItemku;
    //03/06/2021, 10118055, Reza Pratama, If-2
    AdapterRecyclerViewHerizontal(ArrayList<itemModelTeman>dataku){
        this.dataItemku = dataku;
    }



    @NonNull
    @Override
    public AdapterRecyclerViewHerizontal.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_harizontal,parent,false);
        return new AdapterRecyclerViewHerizontal.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerViewHerizontal.ViewHolder holder, int position) {
        TextView namateman = holder.nametemanku;
        ImageView imageteman = holder.imagestemanku;
        TextView status = holder.status;

        namateman.setText(dataItemku.get(position).getNameteman());
        imageteman.setImageResource(dataItemku.get(position).getImagesteman());
        status.setText(dataItemku.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return dataItemku.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nametemanku,status;
        private ImageView imagestemanku;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nametemanku = itemView.findViewById(R.id.nameteman);
            imagestemanku = itemView.findViewById(R.id.imageteman);
            status = itemView.findViewById(R.id.statusteman);

        }
    }
}
