// AppDatabase.java
package com.example.freshly;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Customer.class, Vendor.class, Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CustomerDao customerDao();
    public abstract VendorDao vendorDao();
    public abstract ProductDao productDao();
}
