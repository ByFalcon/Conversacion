package com.example.dam.conversacion;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MensajeDAO {

    @Insert
    void insertar(Mensaje mensaje);

    @Update
    void update(Mensaje mensaje);

    @Delete
    void delete(Mensaje mensaje);

    @Query("select * from mensaje where id = :id")
    Mensaje get(long id);

    @Query("select * from mensaje where id = :id")
    LiveData<Mensaje> getLive(long id);

    @Query("DELETE FROM mensaje")
    void deleteAll();

    @Query("SELECT * from mensaje ORDER BY id ASC")
    List<Mensaje> getAll();

    @Query("SELECT * from mensaje ORDER BY id ASC")
    LiveData<List<Mensaje>> getAllLive();

    @Query("SELECT * from mensaje WHERE origen = :origen ORDER BY id ASC")
    List<Mensaje> getFrom(String origen);

    @Query("SELECT * from mensaje WHERE origen = :origen ORDER BY id ASC")
    LiveData<List<Mensaje>> getFromLive(String origen);
}
