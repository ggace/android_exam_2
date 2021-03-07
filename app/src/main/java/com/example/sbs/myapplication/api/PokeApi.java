package com.example.sbs.myapplication.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface PokeApi {
    String baseUrl = "https://pokeapi.co/api/v2/";

    @GET("pokemon")
    Observable<PokeApi__getPokemons__ResponseBody> getPokemons(@Query("offset") int offset, @Query("limit") int limit);

    @GET("pokemon/{id}")
    Observable<PokeApi__getAbilities__ResponseBody> getAbilities(@Path("id") int id);
}
