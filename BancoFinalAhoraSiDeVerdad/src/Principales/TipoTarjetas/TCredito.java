package Principales.TipoTarjetas;

import Auxiliares.Enums.Estado;
import Auxiliares.Enums.EstadoTarjeta;
import Auxiliares.Enums.TipoTarjeta;

public class TCredito extends Tarjeta {
    private double limite;
    private boolean pagado;
    private double dineroPagado;
    private EstadoTarjeta estadoT;


    public TCredito(String numeroTarjeta, Estado estado, int pin, TipoTarjeta tipoTarjeta, int intentos, double limite,  boolean pagado, EstadoTarjeta estadoT, double dineroPagado) {
        super(numeroTarjeta, estado, pin, tipoTarjeta, intentos);
        this.limite = limite;
        this.pagado = pagado;
        this.estadoT = estadoT;
        this.dineroPagado = dineroPagado;
    }

    public double getLimite() {
        return limite;
    }
    public boolean getPagado() {
        return pagado;
    }
    public EstadoTarjeta getEstadoT() {
        return estadoT;
    }
    public double getDineroPagado() {
        return dineroPagado;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }
    public void setEstadoT(EstadoTarjeta estadoT) {
        this.estadoT = estadoT;
    }
    public void setDineroPagado(double dineroPagado) {
        this.dineroPagado = dineroPagado;
    }
}
