package com.example.sbs.myapplication.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sbs.myapplication.Pokemon;
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
        Util.log("hi");
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
            Util.log("header");
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pokemon_header, parent, false);

            return new RecyclerViewPokemonDetailAdapter.HeaderViewHolder(view);
        }
        else {
            Util.log("item");
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pokemon, parent, false);

            return new RecyclerViewPokemonDetailAdapter.ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {}
        else {
            RecyclerViewPokemonDetailAdapter.ItemViewHolder itemViewHolder = (RecyclerViewPokemonDetailAdapter.ItemViewHolder) holder;

            int pokemonIndex = position - 1;

            String name = data.get(pokemonIndex);
            itemViewHolder.item.setText(name);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addAbility(String name) {
    }


    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
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
