package com.ddona.pokemon.di_demo;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    @Inject
    Driver driver;

    @Inject
    public Car() {
    }

    public void run() {
        Log.d("doanpt", "Car is drive by " + driver.getName());
    }
}
