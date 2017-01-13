package com.latven.dbtest;

public class Coins {
    private int id;
    private String name;

    public Coins (){

    }

    public Coins(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
