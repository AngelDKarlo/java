package Principales;

import Auxiliares.Enums.EstadoInversion;
import Auxiliares.Enums.TipoInversion;

public class Inversion {
    private double intereses;
    private double icr;
    private double monto;
    private double plazos;
    public EstadoInversion estadoInversion;
    public int meses;

    public Inversion(double intereses, double icr, double monto, double plazos, int meses) {
        this.intereses = intereses;
        this.icr = icr;
        this.monto = monto;
        this.plazos = plazos;
        this.estadoInversion = EstadoInversion.Activa;
        this.meses = meses;
    }



    public double getIntereses() {
        return intereses;
    }
    public double getIcr() {
        return icr;
    }
    public double getMonto() {
        return monto;
    }
    public double getPlazos() {
        return plazos;
    }
    public EstadoInversion getEstadoInversion() {
        return estadoInversion;
    }
    public int getMeses() {
        return meses;
    }

    public void setIntereses(double intereses) {
        this.intereses = intereses;
    }
    public void setIcr(double icr) {
        this.icr = icr;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public void setPlazos(double plazos) {
        this.plazos = plazos;
    }
    public void setEstadoInversion(EstadoInversion estadoInversion) {
        this.estadoInversion = estadoInversion;
    }
    public void setMeses(int meses) {
        this.meses = meses;
    }
}
