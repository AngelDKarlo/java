package Principales.TipoTarjetas;

import Auxiliares.Enums.Estado;
import Auxiliares.Enums.TipoTarjeta;

public abstract class Tarjeta {
    private String numeroTarjeta;
    private Estado estado;
    private int pin;
    private TipoTarjeta tipoTarjeta;
    private int intentos;

    public Tarjeta(String numeroTarjeta, Estado estado, int pin, TipoTarjeta tipoTarjeta,  int intentos) {
        this.numeroTarjeta = numeroTarjeta;
        this.estado = estado;
        this.pin = pin;
        this.tipoTarjeta = tipoTarjeta;
        this.intentos = intentos;
    }

    //Getters
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    public Estado getEstado() {
        return estado;
    }
    public int getPin() {
        return pin;
    }
    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }
    public int getIntentos() {
        return intentos;
    }

    //Setters
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
    public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }
    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
}
