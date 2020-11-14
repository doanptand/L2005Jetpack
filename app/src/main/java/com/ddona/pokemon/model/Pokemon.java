package com.ddona.pokemon.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "pokemon")
public class Pokemon {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;

    private String url;

    public Pokemon(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pokemon changeUrl() {
        String[] index = url.split("/");
        this.url = "https://pokeres.bastionbot.org/images/pokemon/"
                + index[index.length - 1] + ".png";
        return this;
    }
}