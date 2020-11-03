package com.ddona.pokemon.repository;

import androidx.lifecycle.LiveData;

import com.ddona.pokemon.db.PokemonDao;
import com.ddona.pokemon.model.Pokemon;
import com.ddona.pokemon.model.PokemonResponse;
import com.ddona.pokemon.network.PokemonService;

import java.nio.file.Path;
import java.util.List;

import retrofit2.Call;

public class PokemonRepository {
    private PokemonDao pokemonDao;
    private PokemonService pokemonService;

    public PokemonRepository(PokemonDao pokemonDao, PokemonService pokemonService) {
        this.pokemonDao = pokemonDao;
        this.pokemonService = pokemonService;
    }

    public Call<PokemonResponse> getRemotePokemons() {
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
