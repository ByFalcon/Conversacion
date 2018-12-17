package com.example.dam.conversacion;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class MensajeRepository {
    private MensajeDAO mensajeDao;
    private LiveData<List<Mensaje>> listaMensajes;

    public MensajeRepository(Application application) {
        MensajeRoomDatabase db = MensajeRoomDatabase.getDatabase(application);
        mensajeDao = db.mensajeDAO();
        listaMensajes = mensajeDao.getAllLive();
    }

    LiveData<List<Mensaje>> getAllMensajes() {
        return listaMensajes;
    }


    public void insert (Mensaje mensaje) {
        new insertAsyncTask(mensajeDao).execute(mensaje);
    }

    private static class insertAsyncTask extends AsyncTask<Mensaje, Void, Void> {

        private MensajeDAO mAsyncTaskDao;

        insertAsyncTask(MensajeDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Mensaje... params) {
            mAsyncTaskDao.insertar(params[0]);
            return null;
        }
    }
}
