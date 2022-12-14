package com.example.da1pet.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(foreignKeys = {
        @ForeignKey(entity = User.class, parentColumns = "id_user", childColumns = "id_user", onDelete = ForeignKey.CASCADE)})
public class Cart {
    @PrimaryKey
    @NotNull
    private String id_cart;
    private String id_user;

    public Cart() {
    }

    public Cart(@NotNull String id_cart, String id_user) {
        this.id_cart = id_cart;
        this.id_user = id_user;
    }

    public String getId_cart() {
        return id_cart;
    }

    public void setId_cart(String id_cart) {
        this.id_cart = id_cart;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
}
