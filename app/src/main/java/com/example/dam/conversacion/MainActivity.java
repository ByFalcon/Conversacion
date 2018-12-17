package com.example.dam.conversacion;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "XYZYX";
    MensajeViewModel modelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modelo = ViewModelProviders.of(this).get(MensajeViewModel.class);
        init();
    }

    private void init() {
        modelo.insert(
                new Mensaje(0, "o", "d",
                        "t", "2018-12-17"));
        modelo.getAllMensajes().observe(this, new Observer<List<Mensaje>>() {
            @Override
            public void onChanged(@Nullable List<Mensaje> mensajes) {
                //adapter.setMensajes(mensajes);
                Log.v(TAG, "Lista completamente cargada");
                if(mensajes == null){
                    Log.v(TAG, "lista nula");
                }else{
                    Log.v(TAG, "tamaño lista: " + mensajes.size());
                }
            }
        });
    }
}
