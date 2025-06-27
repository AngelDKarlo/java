package Menus;

import Auxiliares.Enums.Estado;
import Auxiliares.Validaciones;
import Principales.ClienteMoral;
import Principales.Clientes;

import static Auxiliares.ConstruccionDeCuentas.*;

import java.util.Scanner;

public class MenuClientes {

    public void inicioSesion(){

        Scanner sc = new Scanner(System.in);

        String opcion;
        int op;
        int i = 3;
        int j = 0;
        boolean res = false;

        do{
            System.out.println("***********************************");
            System.out.println("Inicio de Sesion");
            System.out.println("1- iniciar Sesion");
            System.out.println("2- Registrarse");
            System.out.println("3- Salir");
            System.out.println("***********************************");
            opcion = sc.nextLine();
            op = Validaciones.validarTipoDatoInt(opcion);
            switch (op){
                case 1:
                    ciclo:
                    do {
                        System.out.println("**********************");
                        System.out.println("1- Cliente normal");
                        System.out.println("2- Cliente moral");
                        System.out.println("3- volver");
                        System.out.println("**************************");
                        opcion = sc.nextLine();
                        op = Validaciones.validarTipoDatoInt(opcion);
                        if (op == 3) {
                            break;
                        } else {
                            if (op == 2) {
                                res = true;
                            }
                            System.out.println("Usuario:");
                            String usuario = sc.nextLine();
                            System.out.println("Contraseña: ");
                            String contrasenia = sc.nextLine();
                            if (!res) {
                                buscarCuentas:
                                for (Clientes c : bancoActual.getClientes()){
                                    if (c.getUsuario().equals(usuario) && c.getContrasena().equals(contrasenia)){
                                        clienteActual = c;
                                        for (int k = 0; k < clienteActual.getCuentaBancaria().size(); k++){
                                            System.out.println(k + " " + clienteActual.getCuentaBancaria().get(k).getTipoCuentaBancaria());
                                        }
                                        System.out.println("Que cuentas vas a usar?");
                                        opcion = sc.nextLine();
                                        op = Validaciones.validarTipoDatoInt(opcion);
                                        if(clienteActual.getCuentaBancaria().size() > op){
                                            cuentaActual =  clienteActual.getCuentaBancaria().get(op);
                                            Validaciones.validarNipCuenta();
                                            if (cuentaActual.getEstado() == Estado.Bloqueado) {
                                                System.out.println("Tu cuenta esta bloqueada");
                                                break buscarCuentas;
                                            } else {
                                                cuentaActual.mostrarMenu();
                                                break ciclo;
                                            }
                                        }else if (usuario.equals(c.getUsuario()) && !contrasenia.equals(c.getContrasena())) {
                                            cuentaActual = clienteActual.getCuentaBancaria().get(op);
                                            if (cuentaActual.getIntentos() == 3) {
                                                System.out.println("Tu cuenta se ha bloqueado");
                                                cuentaActual.setEstado(Estado.Bloqueado);
                                                break buscarCuentas;
                                            } else {
                                                System.out.println("Te quedan " + i-- + " intentos");
                                                j++;
                                                cuentaActual.setIntentos(j);
                                            }
                                        } else {
                                            cuentaActual = null;
                                        }
                                    }
                                }
                            } else if (res) {
                                for (ClienteMoral c : bancoActual.getClientesMorales()) {
                                    if (c.getUsuario().equals(usuario) && c.getContrasenia().equals(contrasenia)) {
                                        clienteMoralActual = c;
                                        cuentaActual = c.getCuentaBancaria();
                                        if (cuentaActual.getEstado() == Estado.Bloqueado) {
                                            System.out.println("Tu cuenta esta bloqueada");
                                            break;
                                        } else {
                                            cuentaActual.mostrarMenu();
                                            break ciclo;
                                        }
                                    } else if (c.getUsuario().equals(usuario) && !c.getContrasenia().equals(contrasenia)) {
                                        cuentaActual = c.getCuentaBancaria();
                                        if (cuentaActual.getIntentos() == 3) {
                                            System.out.println("Tu cuenta se ha bloqueado");
                                            cuentaActual.setEstado(Estado.Bloqueado);
                                            break;
                                        } else {
                                            System.out.println("Te quedan " + i-- + " intentos");
                                            j++;
                                            cuentaActual.setIntentos(j);
                                        }
                                    } else {
                                        cuentaActual = null;
                                    }
                                }
                                if (cuentaActual == null) {
                                    System.out.println("Número de cuenta o PIN incorrectos.");
                                }
                                if (cuentaActual != null && cuentaActual.getEstado() == Estado.Bloqueado) {
                                    break;
                                }
                            }
                        }
                    }while (true);
                case 2:

                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }while(op != 4);
    }
}
