package Gestores;

import Auxiliares.Enums.Estado;
import Auxiliares.Enums.EstadoTarjeta;
import Auxiliares.Enums.TipoCuenta;
import Auxiliares.GenerarHistorial;
import Auxiliares.PeticionCredito;
import Auxiliares.Validaciones;
import Principales.Clientes;
import Principales.CuentaBancaria.CuentaBancaria;
import Principales.CuentaBancaria.CuentaEmpresa;
import Principales.CuentaBancaria.CuentaInversion;
import Principales.TipoTarjetas.TCredito;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;

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

    public static void retirarCajero(){
        String m;
        double monto;
        boolean esValido;
        String transaccion;
        Scanner sc = new Scanner(System.in);

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
                for (Clientes c : bancoActual.getClientes()){
                    for (CuentaBancaria cu : c.getCuentaBancaria()){
                        if (cuentades.equals(cu.getNumeroCuenta())) {
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
                                        transaccion = "Transferencia Interbancaria";

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
//                    }
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

            if((credito.getDineroPagado() + monto) > credito.getLimite()){
                System.out.println("El dinero que pides es superior a tu limite");
            }
            else if(monto > 0 && monto < credito.getLimite()){

                credito.setEstadoT(EstadoTarjeta.EnProceso);
                LocalDateTime localDateTime = LocalDateTime.now();

                PeticionCredito peticionCredito = new PeticionCredito(clienteActual, tarjetaActual, monto ,localDateTime);
                GestorCredito.getInstance().agregarPeticionCredito(peticionCredito);
            }
            else if (monto == 0){
                System.out.println("dinero invalido");
            }
        }
        else{
            System.out.println("Tu tarjeta no es de credito");
        }
    }

    public static void pagarDinero(){
        Scanner sc = new Scanner(System.in);
        double deuda;

        Validaciones.validarTarjetaEmpresa();
        if(tarjetaActual.getEstado() == Estado.Bloqueado){
            return;
        }
        do{
            System.out.println("cuanto es el sueldo de los empleados:");
            deuda = Validaciones.validarTipoDatoDouble(sc.nextLine());

            if(deuda == 0){
                System.out.println("No se aceptan caracteres");
                continue;
            }

            if(cuentaActual instanceof CuentaEmpresa cuentaEmpresa) {
                ArrayList<Clientes> empleados = clienteMoralActual.getEmpleados();

                if(empleados.isEmpty()) {
                    System.out.println("No hay empleados en la empresa");
                    return;
                }

                double total = deuda * empleados.size();

                if(cuentaEmpresa.getSaldo() < total) {
                    System.out.println("Saldo insuficient");
                    continue;
                }
                realizarPagoEmpleados(cuentaEmpresa, empleados, deuda, total);

            } else {
                System.out.println("Esta función solo está disponible para cuentas de empresa");
                return;
            }
        } while (true);
    }

    public static void realizarPagoEmpleados(CuentaEmpresa cuentaEmpresa, ArrayList<Clientes> empleados, double monto, double total) {

        int empleadosPagados = 0;

        for(Clientes empleado : empleados) {
            for(Clientes clienteBanco : bancoActual.getClientes()) {
                if(clienteBanco.getId() == empleado.getId()) {

                    CuentaBancaria cuentaEmpleado = null;
                    for(CuentaBancaria cuenta : clienteBanco.getCuentaBancaria()) {
                        if(cuenta.getEstado() == Estado.Activo && cuenta.getTipoCuentaBancaria() == TipoCuenta.Nomina) {
                            cuentaEmpleado = cuenta;
                            break;
                        }
                    }

                    if(cuentaEmpleado != null) {
                        cuentaEmpleado.setSaldo(cuentaEmpleado.getSaldo() + monto);
                        empleadosPagados++;

                        Clientes clienteAnterior = clienteActual;
                        CuentaBancaria cuentaAnterior = cuentaActual;

                        clienteActual = clienteBanco;
                        cuentaActual = cuentaEmpleado;

                        GenerarHistorial.darFolio("Pago de nómina", monto);

                        clienteActual = clienteAnterior;
                        cuentaActual = cuentaAnterior;

                    }
                    break;
                }
            }
        }

        double totalDescontado = empleadosPagados * monto;
        cuentaEmpresa.setSaldo(cuentaEmpresa.getSaldo() - totalDescontado);

        GenerarHistorial.darFolio("Pago de nómina a empleados", totalDescontado);
    }
}
