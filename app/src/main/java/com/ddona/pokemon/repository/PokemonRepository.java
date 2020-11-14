package com.ddona.pokemon.repository;


import androidx.lifecycle.LiveData;

import com.ddona.pokemon.db.PokemonDao;
import com.ddona.pokemon.model.Pokemon;
import com.ddona.pokemon.model.PokemonResponse;
import com.ddona.pokemon.network.PokemonService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class PokemonRepository {

    PokemonDao pokemonDao;
    PokemonService pokemonService;

    @Inject
    public PokemonRepository(PokemonDao pokemonDao, PokemonService pokemonService) {
        this.pokemonDao = pokemonDao;
        this.pokemonService = pokemonService;
    }

    public Observable<PokemonResponse> getRemotePokemons() {
        return pokemonService.getAllPokemons();
    }

    public LiveData<List<Pokemon>> getLocalPokemons() {
        return pokemonDao.getAllPokemons();
    }

    public void insertPokemon(Pokemon pokemon) {
        pokemonDao.insertPokemon(pokemon);
    }

    public void deletePokemon(int id) {
        pokemonDao.deletePokemon(id);
    }
}
