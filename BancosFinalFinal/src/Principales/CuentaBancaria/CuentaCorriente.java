package Principales.CuentaBancaria;

import Auxiliares.Enums.Estado;
import Auxiliares.Enums.TipoCuenta;
import Menus.MenuCuentas;
import Principales.Bancos;
import Principales.Historial;
import Principales.TipoTarjetas.Tarjeta;

import java.util.ArrayList;

public class CuentaCorriente extends CuentaBancaria {
    public CuentaCorriente(String numeroCuenta, String claveInterbancaria, Estado estado, ArrayList<Historial> historial, ArrayList<Tarjeta> tarjetas, Bancos bancos, double saldo, String clave, int intentos) {
        super(numeroCuenta, claveInterbancaria, estado, TipoCuenta.Corriente, historial, tarjetas, bancos, saldo, clave,  intentos);
    }


    @Override
    public void mostrarMenu() {
        MenuCuentas Debito = new MenuCuentas();
        Debito.menuDebito();
    }
}
