// ProductDao.java
package com.example.freshly;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {
    @Insert
    void insert(Product product);

    @Query("SELECT * FROM Product WHERE category = :category")
    List<Product> getProductsByCategory(String category);
}
