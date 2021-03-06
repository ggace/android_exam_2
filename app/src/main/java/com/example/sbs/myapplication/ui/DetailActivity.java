package com.example.sbs.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sbs.myapplication.Pokemon;
import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.util.Util;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView pokemon_id = findViewById(R.id.activity_detail__pokemon_id);
        TextView pokemon_name = findViewById(R.id.activity_detail__pokemon_name);
        ImageView imageViewPokemon = findViewById(R.id.activity_detail__imageViewPokemon);

        String pokemon_json = getIntent().getStringExtra("pokemon");

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




    }
}