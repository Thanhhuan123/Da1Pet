package com.example.da1pet.model;

public class User {
    private int idUser;
    private String username;
    private String password;
    private int number;

    public User(int idUser, String username, String password, int number) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.number = number;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
