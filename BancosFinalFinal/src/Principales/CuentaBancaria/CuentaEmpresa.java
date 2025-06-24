package Principales.CuentaBancaria;

import Auxiliares.Enums.Estado;
import Auxiliares.Enums.TipoCuenta;
import Menus.MenuCuentas;
import Principales.Bancos;
import Principales.Historial;
import Principales.TipoTarjetas.Tarjeta;

import java.util.ArrayList;

public class CuentaEmpresa extends CuentaBancaria{
    private ArrayList<CuentaBancaria> cuentasEmpleados;

    public CuentaEmpresa(String numeroCuenta, String claveInterbancaria, Estado estado, ArrayList<Historial> historial, ArrayList<Tarjeta> tarjetas, Bancos bancos, double saldo, String clave, int intentos,ArrayList<CuentaBancaria>  cuentasEmpleados) {
        super(numeroCuenta, claveInterbancaria, estado, TipoCuenta.Empresa, historial, tarjetas, bancos, saldo, clave,  intentos);
        this.cuentasEmpleados = cuentasEmpleados;
    }

    @Override
    public void mostrarMenu(){
        MenuCuentas menu = new MenuCuentas();
        menu.menuEmpresas();
    }

    public ArrayList<CuentaBancaria> getCuentasEmpleados() {
        return cuentasEmpleados;
    }


    public void setCuentasEmpleados(ArrayList<CuentaBancaria> cuentasEmpleados) {
        this.cuentasEmpleados = cuentasEmpleados;
    }
}
