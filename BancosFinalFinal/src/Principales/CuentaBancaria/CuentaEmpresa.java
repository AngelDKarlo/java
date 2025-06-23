package Principales.CuentaBancaria;

import Auxiliares.Enums.Estado;
import Auxiliares.Enums.TipoCuenta;
import Menus.MenuCuentas;
import Principales.Bancos;
import Principales.ClienteMoral;
import Principales.Historial;
import Principales.TipoTarjetas.Tarjeta;

import java.util.ArrayList;

public class CuentaEmpresa extends CuentaBancaria{
    private ArrayList<CuentaBancaria> cuentasEmpleados;
    private ClienteMoral clienteMoral;

    public CuentaEmpresa(String numeroCuenta, String claveInterbancaria, Estado estado, ArrayList<Historial> historial, ArrayList<Tarjeta> tarjetas, Bancos bancos, double saldo, String clave, int intentos,ArrayList<CuentaBancaria>  cuentasEmpleados, ClienteMoral clienteMoral) {
        super(numeroCuenta, claveInterbancaria, estado, TipoCuenta.Empresa, historial, tarjetas, bancos, saldo, clave,  intentos);
        this.cuentasEmpleados = cuentasEmpleados;
        this.clienteMoral = clienteMoral;
    }

    @Override
    public void mostrarMenu(){
        MenuCuentas menu = new MenuCuentas();
        menu.menuEmpresas();
    }

    public ArrayList<CuentaBancaria> getCuentasEmpleados() {
        return cuentasEmpleados;
    }
    public ClienteMoral getClienteMoral() {
        return clienteMoral;
    }
    public void setClienteMoral(ClienteMoral clienteMoral) {
        this.clienteMoral = clienteMoral;
    }

    public void setCuentasEmpleados(ArrayList<CuentaBancaria> cuentasEmpleados) {
        this.cuentasEmpleados = cuentasEmpleados;
    }
}
