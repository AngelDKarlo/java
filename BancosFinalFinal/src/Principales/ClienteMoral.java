package Principales;


import Principales.CuentaBancaria.CuentaBancaria;

public class ClienteMoral {
    private String NombreEmpresa;
    private String DireccionEmpresa;
    private String RFC;


    public ClienteMoral(String nombreEmpresa, String DireccionEmpresa, String RFC) {
        this.NombreEmpresa = nombreEmpresa;
        this.DireccionEmpresa = DireccionEmpresa;
        this.RFC = RFC;
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
}
