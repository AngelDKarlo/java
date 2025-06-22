package Principales.CuentaBancaria;

import Auxiliares.Enums.Estado;
import Auxiliares.Enums.TipoCuenta;
import Principales.Bancos;
import Principales.Historial;
import Principales.TipoTarjetas.Tarjeta;

import java.util.ArrayList;

public abstract class CuentaBancaria {
    private String numeroCuenta;
    private String claveInterbancaria;
    private Estado Estado;
    private TipoCuenta tipoCuentaBancaria;
    private ArrayList<Historial> historial;
    private ArrayList<Tarjeta> tarjetas;
    private Bancos bancos;
    private Double saldo;
    private String CLAVE;
    private int intentos;

    public CuentaBancaria(String numeroCuenta, String claveInterbancaria, Estado Estado, TipoCuenta tipoCuentaBancaria,  ArrayList<Historial> historial,  ArrayList<Tarjeta> tarjetas,  Bancos bancos, double saldo,  String CLAVE, int intentos) {
        this.numeroCuenta = numeroCuenta;
        this.claveInterbancaria = claveInterbancaria;
        this.Estado = Estado;
        this.historial = historial;
        this.tarjetas = tarjetas;
        this.bancos = bancos;
        this.saldo = saldo;
        this.CLAVE = CLAVE;
        this.intentos = intentos;
    }

    public abstract void mostrarMenu();

    //Getters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public String getClaveInterbancaria() {
        return claveInterbancaria;
    }
    public Estado getEstado() {
        return Estado;
    }
    public TipoCuenta getTipoCuentaBancaria() {
        return tipoCuentaBancaria;
    }
    public ArrayList<Historial> getHistorial() {
        return historial;
    }
    public ArrayList<Tarjeta> getTarjetas() {
        return tarjetas;
    }
    public Bancos getBancos() {
        return bancos;
    }
    public Double getSaldo() {
        return saldo;
    }
    public String getCLAVE() {
        return CLAVE;
    }
    public int getIntentos() {
        return intentos;
    }

    //Setters
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    public void setClaveInterbancaria(String claveInterbancaria) {
        this.claveInterbancaria = claveInterbancaria;
    }
    public void setEstado(Estado Estado) {
        this.Estado = Estado;
    }
    public void setTipoCuentaBancaria(TipoCuenta tipoCuentaBancaria) {
        this.tipoCuentaBancaria = tipoCuentaBancaria;
    }
    public void setHistorial(ArrayList<Historial> historial) {
        this.historial = historial;
    }
    public void setTarjetas(ArrayList<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }
    public void setBancos(Bancos bancos) {
        this.bancos = bancos;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public void setCLAVE(String CLAVE) {
        this.CLAVE = CLAVE;
    }
    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
}

