// VendorDao.java
package com.example.freshly;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface VendorDao {
    @Insert
    void insert(Vendor vendor);

    @Query("SELECT * FROM Vendor WHERE username = :username AND password = :password")
    Vendor login(String username, String password);
}
