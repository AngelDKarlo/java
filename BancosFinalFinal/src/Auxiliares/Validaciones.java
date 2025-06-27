package Auxiliares;

import Auxiliares.Enums.Estado;
import Principales.ClienteMoral;
import Principales.Clientes;
import Principales.CuentaBancaria.CuentaBancaria;
import Principales.TipoTarjetas.Tarjeta;

import static Auxiliares.ConstruccionDeCuentas.*;

import java.util.Scanner;

public class Validaciones {

    public static int validarTipoDatoInt(String tipoDato) {
        int op;
        try {
            op = Integer.parseInt(tipoDato);
            return op;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static double validarTipoDatoDouble(String tipoDato) {
        double op;
        try {
            op = Double.parseDouble(tipoDato);
            return op;
        }
        catch (NumberFormatException e) {
            return 0;
        }
    }

    public static boolean validarMonto(double dinero){
        //Validacion del Monto para saber si el dinero es suficiente o correcto
        boolean esValido;
        if(cuentaActual.getSaldo() < dinero){
            System.out.println("Saldo Insuficiente");
            esValido = false;
        }
        else if(dinero <= 0) {
            System.out.println("No se pueden transferir numeros Negativos ni 0");
            esValido = false;
        }
        else{
            esValido = true;
        }
        return esValido;
    }

    public static void validarNipCuenta(){
        Scanner sc = new Scanner(System.in);
        int j=0;
        int i=3;
        do{
            System.out.println("Cual es tu Pin?");
            String pin = sc.nextLine();

            if(cuentaActual.getCLAVE().equals(pin)){
                return;
            }
            else{
                if (cuentaActual.getIntentos() == 3){
                    System.out.println("Tu cuenta se ha bloqueado");
                    cuentaActual.setEstado(Estado.Bloqueado);
                    break;
                }
                else{
                    System.out.println("Te quedan " + i--  + " intentos");
                    j++;
                    cuentaActual.setIntentos(j);
                }
            }
        }while (true);
    }

    public static void validarTarjetaActual(){
        Scanner sc = new Scanner(System.in);

        int j=0;
        int i=3;

        ciclo:
        do {
            System.out.println("Cual es el numero de la tarjeta que vas a usar?");
            String numTarjeta  = sc.nextLine();
            System.out.println("Cual es tu Pin?");
            int pin = sc.nextInt();
            sc.nextLine();

            for (Clientes c : bancoActual.getClientes()) {
                for(CuentaBancaria cu : c.getCuentaBancaria()){
                    for(Tarjeta tarjeta : cu.getTarjetas() ){
                        if (tarjeta.getNumeroTarjeta().equals(numTarjeta) &&  tarjeta.getPin() == pin && cuentaActual.getTarjetas().contains(tarjeta)){
                            tarjetaActual = tarjeta;
                            System.out.println("Numero de Tarjeta: " +  tarjetaActual.getNumeroTarjeta());
                            System.out.println("Clave interbancaria: " +  cuentaActual.getClaveInterbancaria());
                            break ciclo;
                        }
                        else if(tarjeta.getNumeroTarjeta().equals(numTarjeta) && tarjeta.getPin() != pin && cuentaActual.getTarjetas().contains(tarjeta)){
                            tarjetaActual = tarjeta;
                            if (tarjetaActual.getIntentos() == 3){
                                System.out.println("Tu cuenta se ha bloqueado");
                                tarjetaActual.setEstado(Estado.Bloqueado);
                                break ciclo;
                            }
                            else{
                                System.out.println("Te quedan " + i--  + " intentos");
                                j++;
                                tarjetaActual.setIntentos(j);
                            }
                        }
                        else{
                            tarjetaActual = null;
                        }
                    }
                }
            }
            if (tarjetaActual == null) {
                System.out.println("Número de Tarjeta o PIN incorrectos.");
            }if (tarjetaActual.getEstado() == Estado.Bloqueado){
                break ciclo;
            }
        }while (true);
    }

    public static boolean validarEdad(int edad){
        if(edad <= 0){
            System.out.println("No se aceptan caracteres o 0");
            return false;
        }
        else if(edad < 18){
            System.out.println("No se puede crear cuenta para menores de edad");
            return false;
        }
        else{
            return true;
        }
    }

    public static void validarTarjetaEmpresa(){
        Scanner sc = new Scanner(System.in);

        int j=0;
        int i=3;

        ciclo:
        do {
            System.out.println("Cual es el numero de la tarjeta que vas a usar?");
            String numTarjeta  = sc.nextLine();
            System.out.println("Cual es tu Pin?");
            int pin = sc.nextInt();
            sc.nextLine();

            for(ClienteMoral clienteMoral : bancoActual.getClientesMorales()) {
                for (Tarjeta tarjeta : clienteMoral.getCuentaBancaria().getTarjetas()) {
                    if (tarjeta.getNumeroTarjeta().equals(numTarjeta) && tarjeta.getPin() == pin && cuentaActual.getTarjetas().contains(tarjeta)) {
                        tarjetaActual = tarjeta;
                        System.out.println("Numero de Tarjeta: " + tarjetaActual.getNumeroTarjeta());
                        System.out.println("Clave interbancaria: " + cuentaActual.getClaveInterbancaria());
                        break ciclo;
                    } else if (tarjeta.getNumeroTarjeta().equals(numTarjeta) && tarjeta.getPin() != pin && cuentaActual.getTarjetas().contains(tarjeta)) {
                        tarjetaActual = tarjeta;
                        if (tarjetaActual.getIntentos() == 3) {
                            System.out.println("Tu cuenta se ha bloqueado");
                            tarjetaActual.setEstado(Estado.Bloqueado);
                            break ciclo;
                        } else {
                            System.out.println("Te quedan " + i-- + " intentos");
                            j++;
                            tarjetaActual.setIntentos(j);
                        }
                    } else {
                        tarjetaActual = null;
                    }
                }
            }


            if (tarjetaActual == null) {
                System.out.println("Número de Tarjeta o PIN incorrectos.");
            }else if (tarjetaActual.getEstado() == Estado.Bloqueado){
                break ciclo;
            }
        }while (true);
    }
}