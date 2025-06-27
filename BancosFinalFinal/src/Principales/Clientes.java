package Principales;

import Principales.CuentaBancaria.CuentaBancaria;

import java.util.ArrayList;

public class Clientes extends Usuarios {
    private ArrayList<CuentaBancaria> cuenta;


    public Clientes( ArrayList<CuentaBancaria> cuentaBancaria, String nombres, String apellidos, String direccion, String telefono, String email, int edad,  String CURP, String RFC, int id, String contrasena, String usuario) {
        super(nombres, apellidos, direccion, telefono, email, edad, CURP, RFC, id,  contrasena, usuario);

        this.cuenta = cuentaBancaria;
    }

    //getters
    public ArrayList<CuentaBancaria> getCuentaBancaria() {
        return cuenta;
    }

    //setters
    public void setCuenta(ArrayList<CuentaBancaria> cuentaBancaria) {
        this.cuenta = cuentaBancaria;
    }

}
