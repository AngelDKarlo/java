package Menus;

import Auxiliares.Enums.Estado;
import Auxiliares.Validaciones;
import Principales.ClienteMoral;
import Principales.Clientes;
import Principales.CuentaBancaria.CuentaBancaria;

import static Auxiliares.ConstruccionDeCuentas.*;

import java.util.Scanner;

public class MenuClientes {

    public void inicioSesion(){

        Scanner sc = new Scanner(System.in);

        String opcion;
        int op;
        int i = 3;
        int j = 0;

        do{
            System.out.println("***********************************");
            System.out.println("Inicio de Sesion");
            System.out.println("1- iniciar Sesion");
            System.out.println("2- Registrarse");
            System.out.println("3- Ir a atencion al cliente");
            System.out.println("3- Salir");
            System.out.println("***********************************");
            opcion = sc.nextLine();
            op = Validaciones.validarTipoDatoInt(opcion);
            switch (op){
                case 1:
                    ciclo:
                    do{
                        System.out.println("Eres una empresa? (si,no)");
                        String respuesta = sc.nextLine();
                        boolean res;
                        if(respuesta.equals("si")){
                            res = true;
                        }
                        else {
                            res = false;
                        }
                        System.out.println("Numero de cuenta:");
                        String cuenta = sc.nextLine();
                        System.out.println("Pin: ");
                        String pin = sc.nextLine();

                        if(!res){
                            buscarCuentas:
                            for (Clientes c : clientes) {
                                for(CuentaBancaria cu : c.getCuentaBancaria()){
                                    if(cuenta.equals(cu.getNumeroCuenta()) && pin.equals(cu.getCLAVE())){
                                        clienteActual = c;
                                        cuentaActual = cu;
                                        if(cuentaActual.getEstado() == Estado.Bloqueado){
                                            System.out.println("Tu cuenta esta bloqueada");
                                            break buscarCuentas;
                                        }
                                        else{
                                            cuentaActual.mostrarMenu();
                                            break ciclo;
                                        }
                                    }
                                    else if(cuenta.equals(cu.getNumeroCuenta()) && !pin.equals(cu.getCLAVE())){
                                        cuentaActual = cu;
                                        if (cuentaActual.getIntentos() == 3){
                                            System.out.println("Tu cuenta se ha bloqueado");
                                            cuentaActual.setEstado(Estado.Bloqueado);
                                            break buscarCuentas;
                                        }
                                        else{
                                            System.out.println("Te quedan " + i--  + " intentos");
                                            j++;
                                            cuentaActual.setIntentos(j);
                                        }
                                    }
                                    else{
                                        cuentaActual = null;
                                    }
                                }
                            }
                            if (cuentaActual == null) {
                                System.out.println("Número de cuenta o PIN incorrectos.");
                            }if (cuentaActual != null && cuentaActual.getEstado() == Estado.Bloqueado){
                                break;
                            }
                        }
                        else if(res){
                            for (ClienteMoral c : empresas) {
                                if(c.getCuentaBancaria().getNumeroCuenta().equals(cuenta) && c.getCuentaBancaria().getCLAVE().equals(pin)){
                                    clienteMoralActual = c;
                                    cuentaActual = c.getCuentaBancaria();
                                    if(cuentaActual.getEstado() == Estado.Bloqueado){
                                        System.out.println("Tu cuenta esta bloqueada");
                                        break;
                                    }
                                    else{
                                        cuentaActual.mostrarMenu();
                                        break ciclo;
                                    }
                                }
                                else if(cuenta.equals(c.getCuentaBancaria().getNumeroCuenta()) && !pin.equals(c.getCuentaBancaria().getCLAVE())){
                                    cuentaActual = c.getCuentaBancaria();
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
                                else{
                                    cuentaActual = null;
                                }
                            }
                            if (cuentaActual == null) {
                                System.out.println("Número de cuenta o PIN incorrectos.");
                            }if (cuentaActual != null && cuentaActual.getEstado() == Estado.Bloqueado){
                                break;
                            }
                        }
                    }while (true);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }while(op != 4);
    }
}
