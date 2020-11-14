package com.ddona.pokemon.di_demo;

import javax.inject.Inject;

public class Driver {

    @Inject
    public Driver() {
    }

    public String getName() {
        return "Doan dep trai";
    }
}
