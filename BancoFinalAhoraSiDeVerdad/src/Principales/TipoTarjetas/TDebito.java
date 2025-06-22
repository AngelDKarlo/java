package Principales.TipoTarjetas;

import Auxiliares.Enums.Estado;
import Auxiliares.Enums.TipoTarjeta;

public class TDebito extends Tarjeta {
    public TDebito(String numeroTarjeta, Estado estado, int pin, TipoTarjeta tipoTarjeta, int intentos) {
        super(numeroTarjeta, estado, pin, tipoTarjeta, intentos);
    }
}
