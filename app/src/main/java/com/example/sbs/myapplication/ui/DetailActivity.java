package com.example.sbs.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.sbs.myapplication.dto.Abilities;
import com.example.sbs.myapplication.dto.Pokemon;
import com.example.sbs.myapplication.databinding.ActivityDetailBinding;

import com.example.sbs.myapplication.service.PokemonService;
import com.example.sbs.myapplication.util.Util;

import java.util.List;



public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DetailViewModel detailViewModel = new DetailViewModel();

        binding.setLifecycleOwner(this);

        String name = getIntent().getStringExtra("name");
        String url = getIntent().getStringExtra("url");

        Pokemon pokemon = new Pokemon(name, url);

        detailViewModel.pokemon.setValue(pokemon);

        Util.log(name + ", "  + url);






        final PokemonService pokemonService = new PokemonService();






        detailViewModel.lvDataImgUrl.setValue("https://i.picsum.photos/id/335/536/354.jpg?hmac=ThPHe2bAJxvcPAQvEtRiFq2u2wQfAQocvAqnbHfUHgI");

        binding.setVm(detailViewModel);


        final RecyclerViewPokemonDetailAdapter recyclerViewPokemonDetailAdapter = new RecyclerViewPokemonDetailAdapter();


        pokemonService.getAbilities(pokemon.getId(), pokeApi__getAbilities__responseBody -> {



                List<Abilities> abilitiesList = pokeApi__getAbilities__responseBody.getAbilities();
                for(Abilities abilities : abilitiesList){
                    recyclerViewPokemonDetailAdapter.addAbility(abilities.getAbility().getName());



                }
        });





        binding.activityDetailItemRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.activityDetailItemRecyclerView.setAdapter(recyclerViewPokemonDetailAdapter);

        Util.setTimeout(()-> {
            detailViewModel.lvDataImgUrl.setValue("https://i.picsum.photos/id/621/536/354.jpg?hmac=_8_0dSqKvqAOmC-OYdQNAd-gcWiXFDI9svR-kItggsg");
        }, 3000);

















    }
}