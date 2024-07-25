package com.example.mytelephone.db;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface ContactsDao {
    @Insert
    void insert(Contacts contacts);

    @Query("SELECT * FROM Contacts")
    List<Contacts> getAll();
}
