//FIXME remove due to use hilt
//package com.ddona.pokemon.viewmodel;
//
//import android.app.Application;
//
//import androidx.annotation.NonNull;
//import androidx.lifecycle.ViewModel;
//import androidx.lifecycle.ViewModelProvider;
//
//import com.ddona.pokemon.repository.PokemonRepository;
//
//public class PokemonViewModelFactory
//        implements ViewModelProvider.Factory {
//    private Application application;
//
//    public PokemonViewModelFactory(Application application) {
//        this.application = application;
//    }
//
//    @NonNull
//    @Override
//    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//        return (T) new PokemonViewModel(new PokemonRepository(application));
//    }
//}
