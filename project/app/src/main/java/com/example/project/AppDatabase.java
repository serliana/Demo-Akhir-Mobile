package com.example.project;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {PenjualanDB.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PenjualanDao PenjualanDao();
}
