package com.example.dam.conversacion;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "mensaje")
public class Mensaje {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "origen")
    private String origen;

    @ColumnInfo(name = "destino")
    private String destino;

    @ColumnInfo(name = "texto")
    private String texto;

    @ColumnInfo(name = "fecha")
    private String fecha;

    public Mensaje(long id, String origen, String destino, String texto, String fecha) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.texto = texto;
        this.fecha = fecha;
    }

    public Mensaje() {
        this(0,"","","","");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
