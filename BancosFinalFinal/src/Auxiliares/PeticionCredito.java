package Auxiliares;

import Principales.Clientes;
import Principales.CuentaBancaria.CuentaBancaria;
import Principales.TipoTarjetas.Tarjeta;

import java.time.LocalDateTime;

public class PeticionCredito {
    private static int ultimoId = 0;
    private Clientes ClienteSolicitante;
    private Tarjeta TarjetaCredito;
    private double credito;
    private LocalDateTime fecha;
    private int id;

    public PeticionCredito(Clientes ClienteSolicitante, Tarjeta TarjetaCredito, double credito, LocalDateTime fecha) {
        this.ClienteSolicitante = ClienteSolicitante;
        this.TarjetaCredito = TarjetaCredito;
        this.credito = credito;
        this.fecha = fecha;
        this.id = ++ultimoId;
    }

    public Clientes getClienteSolicitante() {
        return ClienteSolicitante;
    }
    public Tarjeta getTarjetaCredito() {
        return TarjetaCredito;
    }
    public double getCredito() {
        return credito;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public int getId() {
        return id;
    }


    public void setClienteSolicitante(Clientes ClienteSolicitante) {
        this.ClienteSolicitante = ClienteSolicitante;
    }
    public void setTarjetaCredito(Tarjeta TarjetaCredito) {
        this.TarjetaCredito = TarjetaCredito;
    }
    public void setCredito(double credito) {
        this.credito = credito;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public void setId(int id) {
        this.id = id;
    }

}
