package com.example.project;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface PenjualanDao {
    @Insert
    void insertrecord(PenjualanDB penjualanDB);

    @Query("SELECT EXISTS(SELECT * FROM PenjualanDB WHERE pid = :productid)")
    Boolean is_exist(int productid);

    @Query("SELECT * FROM PenjualanDB")
    List<PenjualanDB> getallpenjualanDB();

    @Query("DELETE FROM PenjualanDB WHERE pid = :id")
    void deleteById(int id);
}
