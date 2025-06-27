package Principales.CuentaBancaria;

import Auxiliares.Enums.Estado;
import Auxiliares.Enums.TipoCuenta;
import Menus.MenuCuentas;
import Hilos.HiloInversion;
import Principales.Bancos;
import Principales.Historial;
import Principales.Inversion;

import java.util.ArrayList;

public class CuentaInversion extends CuentaBancaria {
    private ArrayList<Inversion> InversionesActuales;
    private HiloInversion hiloInversion;

    public CuentaInversion(String numeroCuenta, String claveInterbancaria, Estado Estado,  ArrayList<Historial> historial, double saldo, String CLAVE, int intentos, ArrayList<Inversion> InversionesActuales) {
        super(numeroCuenta, claveInterbancaria, Estado, TipoCuenta.Inversion,  historial,null, saldo, CLAVE, intentos);
        this.InversionesActuales = InversionesActuales;

        hiloInversion = new HiloInversion(InversionesActuales);
        hiloInversion.start();
    }

    @Override
    public void mostrarMenu() {
        MenuCuentas Inversion = new MenuCuentas();
        Inversion.menuInversion();
    }

    public void cerrarhilo(){
        if(hiloInversion != null){
            hiloInversion.detener();
        }
    }

    public void agregarInversion(Inversion inversion){
        InversionesActuales.add(inversion);
        hiloInversion.agregarInversion(inversion);
    }

    public void quitarInversion(Inversion inversion){
        InversionesActuales.remove(inversion);
        hiloInversion.quitarInversion(inversion);
    }

    public ArrayList<Inversion> getInversionesActuales(){
        return InversionesActuales;
    }

    public void setInversionesActuales(ArrayList<Inversion> InversionesActuales){
        this.InversionesActuales = InversionesActuales;
    }

    public HiloInversion getHiloInversion() {
        return hiloInversion;
    }
    public void setHiloInversion(HiloInversion hiloInversion) {
        this.hiloInversion = hiloInversion;
    }
}
