package com.example.da1pet.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;



@Entity(foreignKeys = {
        @ForeignKey(entity = Products.class, parentColumns = "id_products", childColumns = "id_products", onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Order.class, parentColumns = "id_order", childColumns = "id_order", onDelete = ForeignKey.CASCADE)
})

public class Order_detail {
    @PrimaryKey(autoGenerate = true)
    private Integer id_order;
    private String quantity;
    private Integer id_products;

    public Order_detail() {
    }

    public Order_detail( String quantity, Integer id_products) {
        this.quantity = quantity;
        this.id_products = id_products;
    }

    public Integer getId_order() {
        return id_order;
    }

    public void setId_order(Integer id_order) {
        this.id_order = id_order;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Integer getId_products() {
        return id_products;
    }

    public void setId_products(Integer id_products) {
        this.id_products = id_products;
    }
}
