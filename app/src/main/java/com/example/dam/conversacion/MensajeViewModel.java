package com.example.dam.conversacion;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class MensajeViewModel extends AndroidViewModel {

    private MensajeRepository mensajeRepository;

    public MensajeViewModel(@NonNull Application application) {
        super(application);
        mensajeRepository = new MensajeRepository(application);
    }

    public LiveData<List<Mensaje>> getAllMensajes() {
        return mensajeRepository.getAllMensajes();
    }

    public void insert(Mensaje mensaje) {
        mensajeRepository.insert(mensaje);
    }

    public MensajeRepository getMensajeRepository() {
        return mensajeRepository;
    }
}
