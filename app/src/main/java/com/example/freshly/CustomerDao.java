// CustomerDao.java
package com.example.freshly;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CustomerDao {
    @Insert
    void insert(Customer customer);

    @Query("SELECT * FROM Customer WHERE email = :email AND password = :password")
    Customer login(String email, String password);
}
