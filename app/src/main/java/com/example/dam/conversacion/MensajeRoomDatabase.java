package com.example.dam.conversacion;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Mensaje.class}, version = 1)
public abstract class MensajeRoomDatabase extends RoomDatabase {

    public abstract MensajeDAO mensajeDAO();

    private static volatile MensajeRoomDatabase INSTANCE;

    static MensajeRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MensajeRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MensajeRoomDatabase.class, "dbmensaje").build();
                }
            }
        }
        return INSTANCE;
    }
}
