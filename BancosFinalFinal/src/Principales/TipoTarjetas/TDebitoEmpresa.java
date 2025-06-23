package Principales.TipoTarjetas;


import Auxiliares.Enums.Estado;
import Auxiliares.Enums.Permisos;
import Auxiliares.Enums.TipoTarjeta;

public class TDebitoEmpresa extends Tarjeta {
    private double limiteGastos;
    private Permisos permisos;
    public TDebitoEmpresa(String numeroTarjeta, Estado estado, int pin, TipoTarjeta tipoTarjeta, int intentos,  double limiteGastos, Permisos permisos) {
        super(numeroTarjeta, estado, pin, tipoTarjeta, intentos);
        this.limiteGastos = limiteGastos;
        this.permisos = permisos;
    }
    public double getLimiteGastos() {
        return limiteGastos;
    }
    public void setLimiteGastos(double limiteGastos) {
        this.limiteGastos = limiteGastos;
    }
    public Permisos getPermisos() {
        return permisos;
    }
    public void setPermisos(Permisos permisos) {
        this.permisos = permisos;
    }
}
