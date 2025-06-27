package Principales.CuentaBancaria;

import Auxiliares.Enums.Estado;
import Auxiliares.Enums.TipoCuenta;
import Menus.MenuCuentas;
import Principales.Clientes;
import Principales.Historial;
import Principales.TipoTarjetas.Tarjeta;

import java.util.ArrayList;

public class CuentaMenorDeEdad extends CuentaBancaria {
    private Clientes padre;

    public CuentaMenorDeEdad(String numeroCuenta, String claveInterbancaria, Estado estado, ArrayList<Historial> historial, ArrayList<Tarjeta> tarjetas, double saldo, String clave, int intentos, Clientes padre) {
        super(numeroCuenta, claveInterbancaria, estado, TipoCuenta.MenorDeEdad, historial, tarjetas, saldo, clave, intentos);
        this.padre = padre;
    }

    public Clientes getPadre() {
        return padre;
    }
    public void setPadre(Clientes padre) {
        this.padre = padre;
    }

    @Override
    public void mostrarMenu() {
        MenuCuentas menu = new MenuCuentas();
        menu.menuMenorDeEdad();
    }
}