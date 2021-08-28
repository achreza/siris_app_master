package com.example.reza.pbobeta;

public class usermodels {
    int id;
    String name;
    String stok;

    // contrustor(empty)
    public usermodels() {
    }

    // constructor
    public usermodels(int id, String stok, String name) {
        this.id = id;
        this.stok = stok;
        this.name = name;
    }

    /*Setter and Getter*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTall() {
        return stok;
    }

    public void setTall(String stok) {
        this.stok = stok;
    }
}
