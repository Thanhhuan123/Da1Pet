package com.example.da1pet.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(foreignKeys = {@ForeignKey(entity = User.class, parentColumns = "id_user", childColumns = "id_user", onDelete = ForeignKey.CASCADE)})
public class Order {
    @PrimaryKey(autoGenerate = true)
    private Integer id_order;
    private String id_user;
    private String status;
    private String total;

    public Order(String id_user, String status, String total) {
        this.id_user = id_user;
        this.status = status;
        this.total = total;
    }

    public Order() {
    }

    public Integer getId_order() {
        return id_order;
    }

    public void setId_order(Integer id_order) {
        this.id_order = id_order;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
