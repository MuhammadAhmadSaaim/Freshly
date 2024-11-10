// Customer.java
package com.example.freshly;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Customer {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String email;
    public String password;
    public String image;
    public String gender;
}
