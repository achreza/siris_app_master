package com.example.reza.pbobeta;

public class userItem {
    private final int iduser;
    private final String username;
    private final String password;

    public userItem(int iduser, String username, String password) {
        this.iduser = iduser;
        this.username = username;
        this.password = password;
    }
    public long getIdUser(){
        return iduser;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}
