package com.example.mytelephone.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contacts {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String number;

    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
    }

}

