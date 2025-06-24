package Principales;


import Principales.CuentaBancaria.CuentaBancaria;

import java.util.ArrayList;

public class ClienteMoral {
    private String NombreEmpresa;
    private String DireccionEmpresa;
    private String RFC;
    private CuentaBancaria cuentaBancaria;


    public ClienteMoral(String nombreEmpresa, String DireccionEmpresa, String RFC,  CuentaBancaria cuentaBancaria) {
        this.NombreEmpresa = nombreEmpresa;
        this.DireccionEmpresa = DireccionEmpresa;
        this.RFC = RFC;
        this.cuentaBancaria = cuentaBancaria;
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

}
