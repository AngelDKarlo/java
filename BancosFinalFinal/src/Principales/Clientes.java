package Principales;

import Principales.CuentaBancaria.CuentaBancaria;

import java.util.ArrayList;

public class Clientes extends Usuarios {
    private Bancos bancos;
    private ArrayList<CuentaBancaria> cuenta;


    public Clientes(Bancos bancos, ArrayList<CuentaBancaria> cuentaBancaria, String nombres, String apellidos, String direccion, String telefono, String email, int edad,  String CURP, String RFC) {
        super(nombres, apellidos, direccion, telefono, email, edad, CURP, RFC);
        this.bancos = bancos;
        this.cuenta = cuentaBancaria;
    }

    //getters
    public Bancos getBancos() {
        return bancos;
    }
    public ArrayList<CuentaBancaria> getCuentaBancaria() {
        return cuenta;
    }

    //setters
    public void setBancos(Bancos bancos) {
        this.bancos = bancos;
    }
    public void setCuenta(ArrayList<CuentaBancaria> cuentaBancaria) {
        this.cuenta = cuentaBancaria;
    }

}
