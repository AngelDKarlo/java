package Principales;


import Principales.CuentaBancaria.CuentaBancaria;

import java.util.ArrayList;


public class ClienteMoral {
    private String NombreEmpresa;
    private String DireccionEmpresa;
    private String RFC;
    private CuentaBancaria cuentaBancaria;
    private String contrasenia;
    private String usuario;
    private ArrayList<Clientes> empleados;

    public ClienteMoral(String nombreEmpresa, String DireccionEmpresa, String RFC,  CuentaBancaria cuentaBancaria, String contrasenia, String usuario,  ArrayList<Clientes> empleados) {
        this.NombreEmpresa = nombreEmpresa;
        this.DireccionEmpresa = DireccionEmpresa;
        this.RFC = RFC;
        this.cuentaBancaria = cuentaBancaria;
        this.contrasenia = contrasenia;
        this.usuario = usuario;
        this.empleados = empleados;
    }
    public String getNombreEmpresa() {
        return NombreEmpresa;
    }
    public void setNombreEmpresa(String NombreEmpresa) {
        this.NombreEmpresa = NombreEmpresa;
    }
    public String getDireccionEmpresa() {
        return DireccionEmpresa;
    }
    public void setDireccionEmpresa(String DireccionEmpresa) {
        this.DireccionEmpresa = DireccionEmpresa;
    }
    public String getRFC() {
        return RFC;
    }
    public void setRFC(String RFC) {
        this.RFC = RFC;
    }
    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }
    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public ArrayList<Clientes> getEmpleados() {
        return empleados;
    }
    public void setEmpleados(ArrayList<Clientes> empleados) {
        this.empleados = empleados;
    }
}
