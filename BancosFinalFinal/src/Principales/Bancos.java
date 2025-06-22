package Principales;

public class  Bancos {
    private String nombreBanco;
    private String numSucursales;

    public Bancos(String nombreBanco, String numSucursales) {
        this.nombreBanco = nombreBanco;
        this.numSucursales = numSucursales;
    }

    //Getters
    public String getNombreBanco() {
        return nombreBanco;
    }
    public String getNumSucursales() {
        return numSucursales;
    }

    //setters
    public void setNumSucursales(String numSucursales) {
        this.numSucursales = numSucursales;
    }
    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

}
