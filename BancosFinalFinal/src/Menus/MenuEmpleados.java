package Menus;

import Auxiliares.Enums.Estado;
import Auxiliares.Validaciones;

import Gestores.GestorCredito;
import Gestores.GestorTransacciones;
import Gestores.GestorUsuarios;
import Principales.Clientes;
import Principales.CuentaBancaria.CuentaBancaria;
import Principales.Empleados.Empleados;

import java.util.Scanner;

import static Auxiliares.ConstruccionDeCuentas.*;

public class MenuEmpleados {
    public void menuInicioSesionEmpleados(){
        Scanner sc = new Scanner(System.in);

        String opcion;
        int op;

        do{
            System.out.println("***********************************");
            System.out.println("Inicio de Sesion");
            System.out.println("1- iniciar Sesion");
            System.out.println("2- Salir");
            System.out.println("***********************************");
            opcion = sc.nextLine();
            op = Validaciones.validarTipoDatoInt(opcion);
            switch (op){
                case 1:
                    ciclo:
                    do{
                        System.out.println("Usuario:");
                        String cuenta = sc.nextLine();
                        System.out.println("Contraseña: ");
                        String pin = sc.nextLine();

                        for (Empleados c : bancoActual.getEmpleados()) {
                            if(cuenta.equals(c.getUsuario()) && pin.equals(c.getContrasena())){
                                empleadoAcctual = c;
                                empleadoAcctual.mostrarMenu();
                                break ciclo;
                            }
                            else{
                                empleadoAcctual = null;
                            }
                        }
                        if (empleadoAcctual == null) {
                            System.out.println("Usuario o contraseña incorrectos.");
                        }
                    }while (true);
                    break;
                case 2:
                    break;
                case 0:
                    System.out.println("no se aceptan caracteres");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }while(op != 2);
    }

    public void menuGerente(){
        Scanner sc = new Scanner(System.in);
        String opcion;
        int op;

        do {
            System.out.println("****************************");
            System.out.println("Bienvenido gerente " + empleadoAcctual.getNombres() + " " + empleadoAcctual.getApellidos());
            System.out.println("Que deseas hacer?");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Eliminar cuenta de Cliente");
            System.out.println("3. Contratar Empleado");
            System.out.println("4. Despedir Empleado");
            System.out.println("5. Eliminar cliente");
            System.out.println("6. ver Empleados");
            System.out.println("7. ver Clientes");
            System.out.println("8. Ver creditos");
            System.out.println("9. Salir");
            System.out.println("*******************************");
            opcion = sc.nextLine();
            op = Validaciones.validarTipoDatoInt(opcion);
            switch (op){
                case 1:
                    GestorUsuarios.agregarCliente();
                    break;
                case 2:
                    GestorUsuarios.eliminarCuentaCliente();
                    break;
                case 3:
                    GestorUsuarios.agregarEmpleados();
                    break;
                case 4:
                    GestorUsuarios.retirarEmpleados();
                    break;
                case 5:
                    GestorUsuarios.eliminarCliente();
                    break;
                case 6:
                    GestorUsuarios.verEmpleados();
                    break;
                case 7:
                    GestorUsuarios.verCliente();
                    break;
                case 8:
                    GestorCredito.getInstance().verCreditos();
                    break;
                case 9:
                    break;
                case 0:
                    System.out.println("No se aceptan caracteres");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }while(op != 9);
    }

    public void menuSubGerente(){
        Scanner sc = new Scanner(System.in);
        String opcion;
        int op;

        do {
            System.out.println("****************************");
            System.out.println("Bienvenido subgerente " + empleadoAcctual.getNombres() + " " + empleadoAcctual.getApellidos());
            System.out.println("Que deseas hacer?");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Eliminar cuenta de Cliente");
            System.out.println("3. ver Empleados");
            System.out.println("4. ver Clientes");
            System.out.println("5. Salir");
            System.out.println("*******************************");
            opcion = sc.nextLine();
            op = Validaciones.validarTipoDatoInt(opcion);
            switch (op){
                case 1:
                    GestorUsuarios.agregarCliente();
                    break;
                case 2:
                    GestorUsuarios.eliminarCuentaCliente();
                    break;
                case 3:
                    GestorUsuarios.verEmpleados();
                    break;
                case 4:
                    GestorUsuarios.verCliente();
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("No se aceptan caracteres");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }while(op != 5);
    }

    public void menuCajero(){
        Scanner sc = new Scanner(System.in);
        String opcion;
        int op;


        Validaciones.validarTarjetaActual();

        if(tarjetaActual == null){
            System.out.println("Tarjeta no existente");
            return;
        }

        if(tarjetaActual.getEstado() != Estado.Activo){
            System.out.println("Tu tarjeta esta bloqueada o inactiva por mucho tiempo");
            return;
        }


        boolean encontrado = false;
        for (Clientes c : bancoActual.getClientes()){
            for (CuentaBancaria cu : c.getCuentaBancaria()){
                if(cu.getTarjetas().contains(tarjetaActual)){
                    clienteActual = c;
                    cuentaActual = cu;
                    encontrado = true;
                }
             }
            if(encontrado){break;}
        }

        if(!encontrado){
            System.out.println("No se encontro cuenta asiociada");
            return;
        }

        do {
            System.out.println("**************************");
            System.out.println("Numero de tarjeta: " +  tarjetaActual.getNumeroTarjeta());
            System.out.println("Saldo: " +  cuentaActual.getSaldo());
            System.out.println("Que deseas hacer?");
            System.out.println("1. Retirar dinero");
            System.out.println("2. Ver Historial");
            System.out.println("3. Donar");
            System.out.println("4. Salir");
            System.out.println("*****************************");
            opcion = sc.nextLine();
            op = Validaciones.validarTipoDatoInt(opcion);
            switch (op){
                case 1:
                    GestorTransacciones.retirarCajero();
                    break;
                case 2:
                    System.out.println(cuentaActual.getHistorial());
                    break;
                case 3:
                    System.out.println("Cuanto vas a donar");
                    String don = sc.nextLine();
                    double donacion = Validaciones.validarTipoDatoDouble(don);
                    cuentaActual.setSaldo(cuentaActual.getSaldo() - donacion);
                    break;
                case 4:
                    break;
                case 0:
                    System.out.println("No se aceptan caracteres");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }while(op != 4);

    }

    public void menuAtencionAlCliente(){
        Scanner sc = new Scanner(System.in);
        String opcion;
        int op;

        do {
            System.out.println("****************************");
            System.out.println("Bienvenido gerente " + empleadoAcctual.getNombres() + " " + empleadoAcctual.getApellidos());
            System.out.println("Que deseas hacer?");
            System.out.println("1. Desbloquear tarjeta");
            System.out.println("2. Salir");
            System.out.println("*******************************");
            opcion = sc.nextLine();
            op = Validaciones.validarTipoDatoInt(opcion);
            switch (op){
                case 1:
                    GestorUsuarios.agregarCliente();
                    break;
                case 2:
                    break;
                case 0:
                    System.out.println("No se aceptan caracteres");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }while(op != 2);
    }
}
