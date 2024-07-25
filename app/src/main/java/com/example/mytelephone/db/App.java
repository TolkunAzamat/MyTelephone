package com.example.mytelephone.db;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public class App extends Application {
    private static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "Contacts")
                .allowMainThreadQueries()  // This should NOT be used in production, only for simplicity in examples
                .build();
    }

    public static AppDatabase getDatabase() {
        return database;
    }
}
