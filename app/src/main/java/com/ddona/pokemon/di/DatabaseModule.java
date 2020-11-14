package com.ddona.pokemon.di;

import android.app.Application;

import androidx.room.Room;

import com.ddona.pokemon.db.PokemonDao;
import com.ddona.pokemon.db.PokemonDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DatabaseModule {
    @Singleton
    @Provides
    public static PokemonDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application.getApplicationContext(),
                PokemonDatabase.class, "pokemon.db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()//FIXME remove later
                .build();
    }

    @Singleton
    @Provides
    public static PokemonDao providePokemonDao(PokemonDatabase database) {
        return database.pokemonDao();
    }
}
