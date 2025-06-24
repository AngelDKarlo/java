package Gestores;


import Auxiliares.Enums.Estado;
import Auxiliares.Enums.TipoEmpleado;
import Auxiliares.Validaciones;
import Principales.Clientes;
import Principales.CuentaBancaria.CuentaBancaria;
import Principales.Empleados.Empleados;

import static Auxiliares.ConstruccionDeCuentas.*;

import java.util.Scanner;

public class GestorUsuarios {
    public static void agregarCliente(){

    }
    public static void eliminarCuentaCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Numero de cuenta:");
        String cuenta = sc.nextLine();
        for(Clientes cliente : clientes){
            cliente.getCuentaBancaria().removeIf(cuentaBancaria -> cuentaBancaria.getNumeroCuenta().equals(cuenta));
        }
    }

    public static void eliminarCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("id del usuario:");
        String ida = sc.nextLine();
        int id = Validaciones.validarTipoDatoInt(ida);
        if(id==0){
            System.out.println("solo se aceptan numeros");
            return;
        }
        for(int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).getId() == id) {
                clientes.remove(i);
                System.out.println("cliente eliminado");
                return;
            }
        }
        System.out.println("Cliente no encontrado");
    }

    public static void agregarEmpleados(){

    }
    public static void retirarEmpleados(){
        Scanner sc = new Scanner(System.in);
        System.out.println("id del Empleado:");
        String ida = sc.nextLine();
        int id = Validaciones.validarTipoDatoInt(ida);
        if(id==0){
            System.out.println("no se aceptan numeros");
            return;
        }
        for(int i = 0; i < empleados.size(); i++){
            if (empleados.get(i).getId() == id && empleados.get(i).getTipoEmpleado() != TipoEmpleado.gerente ) {
                empleados.remove(i);
                System.out.println("cliente retirado");
                return;
            }
        }
        System.out.println("Cliente no encontrado");
    }

    public static void verCliente(){
        for(Clientes cliente : clientes){
            System.out.println(cliente.getNombres() + " " + cliente.getApellidos());
            for(CuentaBancaria cuentaBancaria : cliente.getCuentaBancaria()){
                System.out.println("1- " + cuentaBancaria.getNumeroCuenta());
            }
        }
    }

    public static void verEmpleados(){
        for(Empleados empleado : empleados){
            System.out.println(empleado.getNombres() + " " + empleado.getApellidos());
        }
    }

    public static void desbloquearTarjeta(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Numero de cuenta:");
        String cuenta = sc.nextLine();
        for(Clientes cliente : clientes){
            for (CuentaBancaria cuentaBancaria : cliente.getCuentaBancaria()){
                if(cuentaBancaria.getNumeroCuenta().equals(cuenta) && cuentaBancaria.getEstado() == Estado.Bloqueado){
                    cuentaBancaria.setEstado(Estado.Activo);
                }
            }
        }
    }
}
