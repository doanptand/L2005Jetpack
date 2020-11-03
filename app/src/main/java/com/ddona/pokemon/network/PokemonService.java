package com.ddona.pokemon.network;

import com.ddona.pokemon.model.PokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonService {

    @GET("pokemon")
    Call<PokemonResponse> getAllPokemons();
}
