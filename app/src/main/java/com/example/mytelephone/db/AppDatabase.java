package com.example.mytelephone.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.mytelephone.db.Contacts;
import com.example.mytelephone.db.ContactsDao;

@Database(entities = {Contacts.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ContactsDao contactsDao();
}
