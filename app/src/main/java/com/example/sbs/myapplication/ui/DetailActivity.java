package com.example.sbs.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.sbs.myapplication.Abilities;
import com.example.sbs.myapplication.Ability;
import com.example.sbs.myapplication.Pokemon;
import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.databinding.ActivityDetailBinding;
import com.example.sbs.myapplication.service.PokemonService;
import com.example.sbs.myapplication.util.Util;

import java.util.ArrayList;
import java.util.List;

import static com.example.sbs.myapplication.R.layout.activity_detail;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        String pokemon_json = getIntent().getStringExtra("pokemon");

        Pokemon pokemon = Util.jsonStringToObj(pokemon_json, Pokemon.class);




        if(pokemon == null){
            setTitle("포켓몬 상세 정보");

        }
        else{
            setTitle("포켓몬 " + pokemon.getId()+ "번 상세 정보");
            binding.setPokemon(pokemon);
        }

        final PokemonService pokemonService = new PokemonService();




        final RecyclerViewPokemonDetailAdapter recyclerViewPokemonDetailAdapter = new RecyclerViewPokemonDetailAdapter();


        pokemonService.getAbilities(pokemon.getUrl(), pokeApi__getAbilities__responseBody -> {

                List<Abilities> abilitiesList = pokeApi__getAbilities__responseBody.getAbilities();
                for(Abilities abilities : abilitiesList){
                    recyclerViewPokemonDetailAdapter.addAbility(abilities.getAbility().getName());
/*
                    if(!abilities.getIs_hidden()){

                    }

*/




                }
        });

        binding.activityDetailItemRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.activityDetailItemRecyclerView.setAdapter(recyclerViewPokemonDetailAdapter);

















    }
}