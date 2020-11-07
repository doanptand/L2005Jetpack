package com.ddona.pokemon.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ddona.pokemon.model.Pokemon;
import com.ddona.pokemon.model.PokemonResponse;
import com.ddona.pokemon.repository.PokemonRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonViewModel extends ViewModel {
    private PokemonRepository repository;
    private LiveData<List<Pokemon>> mLocalPokemons = null;
    private MutableLiveData<List<Pokemon>> mRemotePokemons = new MutableLiveData<>();

    public PokemonViewModel(Application application) {
        this.repository = new PokemonRepository(application);
    }


    public MutableLiveData<List<Pokemon>> getRemotePokemons() {
        return mRemotePokemons;
    }

    public LiveData<List<Pokemon>> getLocalPokemons() {
        return mLocalPokemons;
    }

    public void getPokemons() {
        repository.getRemotePokemons().enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful()) {
                    List<Pokemon> pokemons = response.body().getResults();
                    for (Pokemon pokemon : pokemons) {
                        String url = pokemon.getUrl();
                        String[] index = url.split("/");
                        String newUrl = "https://pokeres.bastionbot.org/images/pokemon/"
                                + index[index.length - 1] + ".png";
                        pokemon.setUrl(newUrl);
                    }
                    mRemotePokemons.postValue(pokemons);
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {

            }
        });
    }

    public void insertPokemon(Pokemon pokemon) {
        repository.insertPokemon(pokemon);
    }

    public void deletePokemon(int id) {
        repository.deletePokemon(id);
    }

    public LiveData<List<Pokemon>> getAllPokemons() {
        return repository.getLocalPokemons();
    }
}
