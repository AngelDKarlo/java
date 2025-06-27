package Menus;

import Auxiliares.Validaciones;
import Gestores.GestorInverciones;
import Gestores.GestorTransacciones;
import Principales.CuentaBancaria.CuentaEmpresa;

import java.util.Scanner;

import static Auxiliares.ConstruccionDeCuentas.*;

public class MenuCuentas  {
    public String opcion;
    public int op;
    public Scanner sc = new Scanner(System.in);

    public void menuInversion() {
        ciclo:
        do {
            System.out.println("**************************************");
            System.out.println("Bienvenido " + clienteActual.getNombres() + " " +  clienteActual.getApellidos());
            System.out.println("Numero de Cuenta: " + cuentaActual.getNumeroCuenta());
            System.out.println("Saldo: " + cuentaActual.getSaldo());
            System.out.println("Que deseas hacer?");
            System.out.println("1- Crear inversion");
            System.out.println("2- Ver inversiones");
            System.out.println("3- Retirar inversiones");
            System.out.println("4- Transferir a otra cuenta");
            System.out.println("5- Salir");
            System.out.println("**************************************");
            opcion = sc.nextLine();
            op = Validaciones.validarTipoDatoInt(opcion);
            switch (op) {
                case 1:
                    GestorInverciones.nuevaInversion();
                    break;
                case 2:
                    GestorInverciones.mostrarInversiones();
                    break;
                case 3:
                    GestorInverciones.retirarInversion();
                    break;
                case 4:
                    GestorTransacciones.transferencia();
                    break;
                case 5:
                    break ciclo;
                case 0:
                    System.out.println("No se aceptan caracteres");
                default:
                    System.out.println("Opcion no disponible");
                    break;
            }
        }while (true);
    }

    public void menuNomina(){
        ciclo:
        do {
            System.out.println("**************************************");
            System.out.println("Bienvenido " + clienteActual.getNombres() + " " +  clienteActual.getApellidos());
            System.out.println("Numero de Cuenta: " + cuentaActual.getNumeroCuenta());
            System.out.println("Saldo: " + cuentaActual.getSaldo());
            System.out.println("Que deseas hacer?");
            System.out.println("1- Depositar");
            System.out.println("2- Retirar");
            System.out.println("3- Transferencia");
            System.out.println("4- Pedir credito");
            System.out.println("5- Ver Historial");
            System.out.println("6- Salir");
            System.out.println("**************************************");
            opcion = sc.nextLine();
            op = Validaciones.validarTipoDatoInt(opcion);
            switch (op) {
                case 1:
                    GestorTransacciones.depositar();
                    break;
                case 2:
                    GestorTransacciones.retirar();
                    break;
                case 3:
                    GestorTransacciones.transferencia();
                    break;
                case 4:
                    GestorTransacciones.pedirCredito();
                    break;
                case 5:
                    System.out.println(cuentaActual.getHistorial());
                    break;
                case 6:
                    break ciclo;
                case 0:
                    System.out.println("No se aceptan caracteres");
                default:
                    System.out.println("Opcion no disponible");
                    break;
            }
        }while (true);
    }


    public void menuDebito(){
        ciclo:
        do {
            System.out.println("**************************************");
            System.out.println("Bienvenido " + clienteActual.getNombres() + " " +  clienteActual.getApellidos());
            System.out.println("Numero de Cuenta: " + cuentaActual.getNumeroCuenta());
            System.out.println("Saldo: " + cuentaActual.getSaldo());
            System.out.println("Que deseas hacer?");
            System.out.println("1- Depositar");
            System.out.println("2- Retirar");
            System.out.println("3- Transferencia");
            System.out.println("4- Pedir credito");
            System.out.println("5- Ver Historial");
            System.out.println("6- Salir");
            System.out.println("**************************************");
            opcion = sc.nextLine();
            op = Validaciones.validarTipoDatoInt(opcion);
            switch (op) {
                case 1:
                    GestorTransacciones.depositar();
                    break;
                case 2:
                    GestorTransacciones.retirar();
                    break;
                case 3:
                    GestorTransacciones.transferencia();
                    break;
                case 4:
                    GestorTransacciones.pedirCredito();
                    break;
                case 5:
                    System.out.println(cuentaActual.getHistorial());
                    break;
                case 6:
                    break ciclo;
                case 0:
                    System.out.println("No se aceptan caracteres");
                default:
                    System.out.println("Opcion no disponible");
                    break;
            }
        }while (true);
    }

    public void menuAhorro(){
        ciclo:
        do {
            System.out.println("**************************************");
            System.out.println("Bienvenido " + clienteActual.getNombres() + " " +  clienteActual.getApellidos());
            System.out.println("Numero de Cuenta: " + cuentaActual.getNumeroCuenta());
            System.out.println("Saldo: " + cuentaActual.getSaldo());
            System.out.println("Que deseas hacer?");
            System.out.println("1- Depositar");
            System.out.println("2- Retirar");
            System.out.println("3- Transferencia");
            System.out.println("4- Pedir credito");
            System.out.println("5- Ver Historial");
            System.out.println("6- Salir");
            System.out.println("**************************************");
            opcion = sc.nextLine();
            op = Validaciones.validarTipoDatoInt(opcion);
            switch (op) {
                case 1:
                    GestorTransacciones.depositar();
                    break;
                case 2:
                    GestorTransacciones.retirar();
                    break;
                case 3:
                    GestorTransacciones.transferencia();
                    break;
                case 4:
                    GestorTransacciones.pedirCredito();
                    break;
                case 5:
                    System.out.println(cuentaActual.getHistorial());
                    break;
                case 6:
                    break ciclo;
                case 0:
                    System.out.println("No se aceptan caracteres");
                default:
                    System.out.println("Opcion no disponible");
                    break;
            }
        }while (true);
    }

    public void menuEstudiantil(){
        ciclo:
        do {
            System.out.println("**************************************");
            System.out.println("Bienvenido " + clienteActual.getNombres() + " " +  clienteActual.getApellidos());
            System.out.println("Numero de Cuenta: " + cuentaActual.getNumeroCuenta());
            System.out.println("Saldo: " + cuentaActual.getSaldo());
            System.out.println("Que deseas hacer?");
            System.out.println("1- Depositar");
            System.out.println("2- Retirar");
            System.out.println("3- Transferencia");
            System.out.println("4- Ver Historial");
            System.out.println("5- Salir");
            System.out.println("**************************************");
            opcion = sc.nextLine();
            op = Validaciones.validarTipoDatoInt(opcion);
            switch (op) {
                case 1:
                    GestorTransacciones.depositar();
                    break;
                case 2:
                    GestorTransacciones.retirar();
                    break;
                case 3:
                    GestorTransacciones.transferencia();
                    break;
                case 4:
                    System.out.println(cuentaActual.getHistorial());
                    break;
                case 5:
                    break ciclo;
                case 0:
                    System.out.println("No se aceptan caracteres");
                default:
                    System.out.println("Opcion no disponible");
                    break;
            }
        }while (true);
    }

    public void menuMenorDeEdad(){
        ciclo:
        do {
            System.out.println("**************************************");
            System.out.println("Bienvenido " + clienteActual.getNombres() + " " +  clienteActual.getApellidos());
            System.out.println("Numero de Cuenta: " + cuentaActual.getNumeroCuenta());
            System.out.println("Saldo: " + cuentaActual.getSaldo());
            System.out.println("Que deseas hacer?");
            System.out.println("1- Depositar");
            System.out.println("2- Ver Historial");
            System.out.println("3- Salir");
            System.out.println("**************************************");
            opcion = sc.nextLine();
            op = Validaciones.validarTipoDatoInt(opcion);
            switch (op) {
                case 1:
                    GestorTransacciones.depositar();
                    break;
                case 2:
                    System.out.println(cuentaActual.getHistorial());
                    break;
                case 3:
                    break ciclo;
                case 0:
                    System.out.println("No se aceptan caracteres");
                default:
                    System.out.println("Opcion no disponible");
                    break;
            }
        }while (true);
    }

    public void menuEmpresas() {
        ciclo:
        do {
            System.out.println("**************************************");
            if (cuentaActual instanceof CuentaEmpresa cuentaEmpresa) {
                System.out.println("Nombre de la empresa: " + clienteMoralActual.getNombreEmpresa());
                System.out.println("Numero de Cuenta: " + cuentaEmpresa.getNumeroCuenta());
                System.out.println("Saldo: " + cuentaEmpresa.getSaldo());
                System.out.println("Que deseas hacer?");
                System.out.println("1- Depositar");
                System.out.println("2- Retirar");
                System.out.println("3- Transferencia");
                System.out.println("4- Pagar a empleados");
                System.out.println("5- Ver Historial");
                System.out.println("6- Salir");
                System.out.println("**************************************");
                opcion = sc.nextLine();
                op = Validaciones.validarTipoDatoInt(opcion);
                switch (op) {
                    case 1:
                        GestorTransacciones.depositar();
                        break;
                    case 2:
                        GestorTransacciones.retirar();
                        break;
                    case 3:
                        GestorTransacciones.transferencia();
                        break;
                    case 4:
                        GestorTransacciones.pagarDinero();
                        break;
                    case 5:
                        System.out.println(cuentaActual.getHistorial());
                        break;
                    case 6:
                        break ciclo;
                    case 0:
                        System.out.println("No se aceptan caracteres");
                    default:
                        System.out.println("Opcion no disponible");
                        break;
                }
            }
        }while (true);
    }
}
