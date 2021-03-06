package com.example.sbs.myapplication.ui;

import android.app.Application;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.collection.CircularArray;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sbs.myapplication.dto.Pokemon;
import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.util.Util;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewPokemonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int TYPE_HEADER = 0;
    private final int TYPE_ITEM = 1;
    private final int TYPE_FOOTER = 2;

    private List<Pokemon> data;
    private View.OnClickListener onClickLoadMore;
    private View.OnClickListener onMoveActivity;
    private int laodMore = 20;




    public RecyclerViewPokemonAdapter(List<Pokemon> data) {
        this.data = data;

    }

    public RecyclerViewPokemonAdapter() {
        this.data = new ArrayList<>();

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return TYPE_HEADER;
        else if (position == data.size() + 1)
            return TYPE_FOOTER;
        else
            return TYPE_ITEM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pokemon_header, parent, false);

            return new HeaderViewHolder(view);
        } else if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pokemon_footer, parent, false);

            return new FooterViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pokemon, parent, false);

            return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {

        } else if (holder instanceof FooterViewHolder) {
            FooterViewHolder footerViewHolder = (FooterViewHolder) holder;

        } else {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

            int pokemonIndex = position - 1;

            Pokemon pokemon = data.get(pokemonIndex);
            itemViewHolder.textViewId.setText(pokemon.getId() + "번");
            itemViewHolder.textViewId.setTag(pokemonIndex);

            itemViewHolder.textViewName.setText(pokemon.getName());
            itemViewHolder.textViewName.setTag(pokemonIndex);



            Util.loadImageOn(pokemon.getImgUrl(), itemViewHolder.imageViewPokemon);
        }
    }

    @Override
    public int getItemCount() {
        return data.size() + 2;
    }

    public void addPokemons(List<Pokemon> pokemons) {
        for ( Pokemon pokemon : pokemons ) {
            data.add(pokemon);
        }

        int headerCount = 1;

        notifyItemRangeInserted(headerCount + getDataSize(), getLoadCount());
    }

    public void setOnClickLoadMore(View.OnClickListener onClickLoadMore) {
        this.onClickLoadMore = onClickLoadMore;
    }

    public int getLoadCount() {
        return laodMore;
    }

    public int getDataSize() {
        return data.size();
    }

    public void setOnMoveActivity(View.OnClickListener onMoveActivity) {
        this.onMoveActivity = onMoveActivity;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewId;
        public TextView textViewName;
        public ImageView imageViewPokemon;

        public ItemViewHolder(@NonNull View view) {
            super(view);

            textViewId = view.findViewById(R.id.item_pokemon__textViewId);
            textViewName = view.findViewById(R.id.item_pokemon__textViewName);
            imageViewPokemon = view.findViewById(R.id.item_pokemon__imageViewPokemon);

            textViewName.setOnClickListener(onMoveActivity);
            textViewId.setOnClickListener(onMoveActivity);
            imageViewPokemon.setOnClickListener(onMoveActivity);
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(@NonNull View view) {
            super(view);
        }
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {
        public Button buttonLoadMore;

        public FooterViewHolder(@NonNull View view) {
            super(view);
            buttonLoadMore = view.findViewById(R.id.item_pokemon_footer__buttonLoadMore);
            buttonLoadMore.setOnClickListener(onClickLoadMore);




        }
    }
}
