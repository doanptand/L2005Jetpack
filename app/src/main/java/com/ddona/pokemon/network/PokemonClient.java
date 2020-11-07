package com.ddona.pokemon.network;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonClient {
    private static Retrofit INSTANCE;

    private PokemonClient() {

    }

    public static Retrofit getInstance(String url) {
        if (INSTANCE == null) {
            INSTANCE = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return INSTANCE;
    }
}
