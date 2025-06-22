package Gestores;

import Auxiliares.Enums.Estado;
import Auxiliares.Enums.EstadoTarjeta;
import Auxiliares.GenerarHistorial;
import Auxiliares.Validaciones;
import Principales.Clientes;
import Principales.CuentaBancaria.CuentaBancaria;
import Principales.CuentaBancaria.CuentaInversion;
import Principales.TipoTarjetas.TCredito;

import java.util.Scanner;

import static Auxiliares.ConstruccionDeCuentas.*;
import static Auxiliares.ConstruccionDeCuentas.clienteRecibe;
import static Auxiliares.ConstruccionDeCuentas.cuentaRecibe;

public class GestorTransacciones {
    public static void depositar(){
        String m;
        double monto;
        boolean esValido;
        String transaccion;
        Scanner sc = new Scanner(System.in);

        Validaciones.validarTarjetaActual();
        if(tarjetaActual.getEstado() == Estado.Bloqueado){
            System.out.println("Tu tajerta esta bloqueada");
        }
        else{
            ciclo:
            do{
                System.out.println("Cuanto dinero deseas depositar?");
                m = sc.nextLine();
                monto = Validaciones.validarTipoDatoDouble(m);
                if(monto == 0){
                    System.out.println("No se aceptan caracteres");
                    break;
                }
                else {
                    esValido = Validaciones.validarMonto(monto);
                    if(esValido){
                        cuentaActual.setSaldo(cuentaActual.getSaldo() + monto);
                        transaccion = "Deposito";
                        GenerarHistorial.darFolio(transaccion,monto);
                        break ciclo;
                    }
                }
            }while (true);
        }
    }

    public static void retirar(){
        String m;
        double monto;
        boolean esValido;
        String transaccion;
        Scanner sc = new Scanner(System.in);

        Validaciones.validarTarjetaActual();
        if(tarjetaActual.getEstado() == Estado.Bloqueado){
            System.out.println("Tu tajerta esta bloqueada");
        }
        else{
            do{
                System.out.println("Cuanto dinero deseas retirar?");
                m = sc.nextLine();
                monto = Validaciones.validarTipoDatoDouble(m);
                if(monto == 0){
                    System.out.println("No se aceptan caracteres");
                    break;
                }
                else {
                    esValido = Validaciones.validarMonto(monto);
                    if(esValido){
                        cuentaActual.setSaldo(cuentaActual.getSaldo() - monto);
                        transaccion = "Retirar";
                        GenerarHistorial.darFolio(transaccion,monto);
                        break;
                    }
                }
            }while(true);
        }
    }

    public static void transferencia(){
        String m;
        double monto;
        boolean esValido = false;
        String transaccion;
        String cuentades;
        Scanner sc = new Scanner(System.in);

        if(cuentaActual instanceof CuentaInversion cuentaInversion){
            tarjetaActual = null;
        }
        else {
            Validaciones.validarTarjetaActual();
        }
        if(tarjetaActual != null && tarjetaActual.getEstado() == Estado.Bloqueado){
            System.out.println("Tu tajerta esta bloqueada");
        }
        else {
            ciclo:
            do {
                System.out.println("Numero de cuenta del destinatario: ");
                cuentades = sc.nextLine();
                System.out.println("Banco al que esta aciciado: ");
                String banco =  sc.nextLine();
                buscarCuentas:
                for (Clientes c : clientes) {
                    for (CuentaBancaria cu : c.getCuentaBancaria()) {
                        if (cuentades.equals(cu.getNumeroCuenta()) && banco.equals(cu.getBancos().getNombreBanco())) {
                            clienteRecibe = c;
                            cuentaRecibe = cu;
                            if (cuentaRecibe.getEstado() == Estado.Bloqueado) {
                                System.out.println("La cuenta a la que intentas enviar dinero esta bloqueada esta bloqueada");
                                break buscarCuentas;
                            } else {
                                System.out.println("Cuanto dinero vas a depositar?");
                                m = sc.nextLine();
                                monto = Validaciones.validarTipoDatoDouble(m);
                                if (monto == 0){
                                    System.out.println("No se aceptan caracteres");
                                }
                                else {
                                    esValido = Validaciones.validarMonto(monto);
                                    if(esValido){
                                        cuentaActual.setSaldo(cuentaActual.getSaldo() - monto);
                                        cuentaRecibe.setSaldo(cuentaRecibe.getSaldo() + monto);
                                        if(cuentaRecibe.getBancos().getNombreBanco().equals(cuentaActual.getBancos().getNombreBanco())){
                                            transaccion = "Transferencia";
                                        }
                                        else{
                                            transaccion = "Transferencia Interbancaria";
                                        }
                                        GenerarHistorial.darFolio(transaccion,monto);
                                        break ciclo;
                                    }
                                }
                                break ciclo;
                            }
                        }
                        else {
                            cuentaRecibe = null;
                        }
                    }
                }
            }while (true);
        }
    }

    public static void pedirCredito(){
        Scanner sc = new Scanner(System.in);
        Validaciones.validarTarjetaActual();
        if(tarjetaActual.getEstado() == Estado.Bloqueado){
            System.out.println("Tu tajerta esta bloqueada");
        }
        else if(tarjetaActual instanceof TCredito credito){
            System.out.println("liite de la tarjeta: " + credito.getLimite());
            System.out.println("Cuanto creditos vas a pedir?");
            String m = sc.nextLine();
            double monto =  Validaciones.validarTipoDatoDouble(m);

            if((credito.getDineroPagado() + monto) >= credito.getLimite()){
                System.out.println("El dinero que pides es superior a tu limite");
            }
            else if(monto > 0 && monto < credito.getLimite()){
                cuentaActual.setSaldo(cuentaActual.getSaldo() + monto);
                credito.setEstadoT(EstadoTarjeta.EnProceso);
                //Aqui se mete el codigo para mandar la solicitud al gerente o subgerente respectivamente
            }
            else if (monto == 0){
                System.out.println("dinero invalido");
            }
        }
        else{
            System.out.println("Tu tarjeta no es de credito");
        }
    }
}
