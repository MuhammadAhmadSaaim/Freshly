// Vendor.java
package com.example.freshly;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Vendor {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String username;
    public String password;
    public String image;
    public String phone;
    public String address;
}
