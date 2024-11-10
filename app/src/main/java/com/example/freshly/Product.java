// Product.java
package com.example.freshly;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String description;
    public String image;
    public double price;
    public String category;
    public int vendorId;
}
