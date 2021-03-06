package com.example.sbs.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
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
import com.example.sbs.myapplication.service.PokemonService;
import com.example.sbs.myapplication.util.Util;

import java.util.ArrayList;
import java.util.List;

import static com.example.sbs.myapplication.R.layout.activity_detail;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_detail);




        TextView pokemon_id = findViewById(R.id.activity_detail__pokemon_id);
        TextView pokemon_name = findViewById(R.id.activity_detail__pokemon_name);
        ImageView imageViewPokemon = findViewById(R.id.activity_detail__imageViewPokemon);
        RecyclerView recyclerView = findViewById(R.id.activity_detail__item__recyclerView);

/*
        TextView pokemon_id = new TextView(this);
        TextView pokemon_name = new TextView(this);
        ImageView imageViewPokemon = new ImageView(this);
*/

        String pokemon_json = getIntent().getStringExtra("pokemon");
        int index = getIntent().getIntExtra("index", -1);

        Util.log(pokemon_json);

        Pokemon pokemon = Util.jsonStringToObj(pokemon_json, Pokemon.class);

        if(pokemon == null){
            Util.log("none");
        }
        else{
            pokemon_id.setText(pokemon.getId() + "");
            pokemon_name.setText(pokemon.getName());
            Util.loadImageOn(pokemon.getImgUrl(), imageViewPokemon);
        }

        final PokemonService pokemonService = new PokemonService();




        RecyclerViewPokemonDetailAdapter recyclerViewPokemonDetailAdapter = new RecyclerViewPokemonDetailAdapter();
        recyclerView.setAdapter(recyclerViewPokemonDetailAdapter);

        pokemonService.getAbilities(pokemon.getUrl(), pokeApi__getAbilities__responseBody -> {

                List<Abilities> abilitiesList = pokeApi__getAbilities__responseBody.getAbilities();
                for(Abilities abilities : abilitiesList){
                    recyclerViewPokemonDetailAdapter.addAbility(abilities.getAbility().getName());

                    Util.log(abilities.getAbility().getName());
                }


        });















    }
}