package com.example.Backend.Animals;

public class Parrot {
    private String name;
    public Parrot () {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }


}
