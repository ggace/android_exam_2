package com.example.sbs.myapplication.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.util.Util;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewPokemonDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<String> data;

    int HEADER = 0;
    int ITEM = 1;

    public RecyclerViewPokemonDetailAdapter(List<String> data){
        this.data = data;

    }

    public RecyclerViewPokemonDetailAdapter() {
        this.data = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return HEADER;
        else
            return ITEM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == HEADER) {

            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.detail_view__header, parent, false);

            return new HeaderViewHolder(view);
        }
        else {

            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.detail_view__item, parent, false);

            return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        if (position == 0) {}
        else {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

            int pokemonIndex = position - 1;

            String name = data.get(pokemonIndex);
            itemViewHolder.item.setText(" - " + name);
        }
    }

    @Override
    public int getItemCount() {
        return data.size() + 1;
    }

    public void addAbility(String name) {



        data.add(name);

        notifyDataSetChanged();
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView header;


        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);

            header = itemView.findViewById(R.id.detail_view__header);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView item;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            item = itemView.findViewById(R.id.detail_view__item);
        }
    }
}
