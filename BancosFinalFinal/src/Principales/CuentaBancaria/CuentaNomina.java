package Principales.CuentaBancaria;

import Auxiliares.Enums.Estado;
import Auxiliares.Enums.TipoCuenta;
import Menus.MenuCuentas;
import Principales.Historial;
import Principales.TipoTarjetas.Tarjeta;

import java.util.ArrayList;

public class CuentaNomina extends CuentaBancaria{

    public CuentaNomina(String numeroCuenta, String claveInterbancaria, Estado estado, ArrayList<Historial> historial, ArrayList<Tarjeta> tarjetas, double saldo, String clave, int intentos) {
        super(numeroCuenta, claveInterbancaria, estado, TipoCuenta.Nomina, historial, tarjetas,  saldo, clave,  intentos);
    }

    public void mostrarMenu(){
        MenuCuentas  menu = new MenuCuentas();
        menu.menuNomina();
    }

}
