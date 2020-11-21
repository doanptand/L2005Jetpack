package com.ddona.pokemon.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ddona.pokemon.R;
import com.ddona.pokemon.databinding.ItemPokemonBinding;
import com.ddona.pokemon.model.Pokemon;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {
    private List<Pokemon> mPokemons;

    public PokemonAdapter(List<Pokemon> mPokemons) {
        this.mPokemons = mPokemons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPokemonBinding binding = ItemPokemonBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mPokemons.get(position));
    }

    @Override
    public int getItemCount() {
        return mPokemons == null ? 0 : mPokemons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemPokemonBinding binding;

        public ViewHolder(ItemPokemonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Pokemon pokemon) {
            binding.setPokemon(pokemon);
        }
    }
}
