package Principales.CuentaBancaria;

import Auxiliares.Enums.Estado;
import Auxiliares.Enums.TipoCuenta;
import Menus.MenuCuentas;
import Principales.Historial;
import Principales.TipoTarjetas.Tarjeta;

import java.util.ArrayList;

public class CuentaEstudiantil extends CuentaBancaria {

    public CuentaEstudiantil(String numeroCuenta, String claveInterbancaria, Estado estado, ArrayList<Historial> historial, ArrayList<Tarjeta> tarjetas, double saldo, String clave, int intentos) {
        super(numeroCuenta, claveInterbancaria, estado, TipoCuenta.Estudiantil, historial, tarjetas, saldo, clave, intentos);
    }

    @Override
    public void mostrarMenu() {
        MenuCuentas menu = new MenuCuentas();
        menu.menuEstudiantil();
    }
}
