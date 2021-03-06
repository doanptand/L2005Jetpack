package com.ddona.pokemon.di_demo;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    //@Inject
    Driver driver;

    @Inject
    Library library;

    @Inject
    public Car(Driver driver) {
        this.driver = driver;
    }

    //@Inject
    public Car() {
    }

    public void wash() {
        library.doSomething();
    }

    public void run() {
        Log.d("doanpt", "Car is drive by " + driver.getName() + " do ");
    }
}
