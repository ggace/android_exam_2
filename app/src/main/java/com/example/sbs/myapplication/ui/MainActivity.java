package com.example.sbs.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sbs.myapplication.Pokemon;
import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.service.PokemonService;
import com.example.sbs.myapplication.util.Util;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Pokemon> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("포켓몬 리스트");
        setContentView(R.layout.activity_main);

        // 포켓몬 서비스
        final PokemonService pokemonService = new PokemonService();

        // 포켓몬 리사이클러 뷰
        final RecyclerView recyclerViewPokemon = findViewById(R.id.activity_main__recyclerViewPokemon);
        // 포켓몬 리사이클러 뷰 어덥터

        data = new ArrayList<>();

        final RecyclerViewPokemonAdapter recyclerViewPokemonAdapter = new RecyclerViewPokemonAdapter(data);

        View.OnClickListener onMoveActivity = view1 -> {
            Intent intent = new Intent(view1.getContext(), DetailActivity.class);


            Pokemon pokemon = data.get((int)view1.getTag());

            intent.putExtra("pokemon", Util.objToJsonString(pokemon));
            intent.putExtra("index", (int)view1.getTag());

            view1.getContext().startActivity(intent);
        };

        recyclerViewPokemonAdapter.setOnMoveActivity(onMoveActivity);

        // 푸터의 `더 보기` 버튼을 클릭하면 일어날 일을 세팅
        recyclerViewPokemonAdapter.setOnClickLoadMore(view -> {
            view.setEnabled(false);

            pokemonService.getPokemons(recyclerViewPokemonAdapter.getDataSize(), recyclerViewPokemonAdapter.getLoadCount(), responseBody -> {
                recyclerViewPokemonAdapter.addPokemons(responseBody.getResults());
                view.setEnabled(true);
            });
        });

        recyclerViewPokemon.setAdapter(recyclerViewPokemonAdapter);


    }
}
