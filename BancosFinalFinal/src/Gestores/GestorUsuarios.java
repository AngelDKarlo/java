package Gestores;


import Auxiliares.Enums.Estado;
import Auxiliares.Enums.TipoEmpleado;
import Auxiliares.Validaciones;
import Principales.Clientes;
import Principales.CuentaBancaria.CuentaBancaria;
import Principales.Empleados.AtencionAlCliente;
import Principales.Empleados.Cajero;
import Principales.Empleados.Empleados;
import Principales.Empleados.SubGerente;

import static Auxiliares.ConstruccionDeCuentas.*;

import java.util.Scanner;
import java.util.ArrayList;

public class GestorUsuarios {
    public static void agregarCliente() {
        Scanner sc = new Scanner(System.in);
        int edad;
        boolean edadValida;

        System.out.println("Nombre:");
        String nombres = sc.nextLine();
        System.out.println("Apellidos:");
        String apellidos = sc.nextLine();
        System.out.println("Direccion:");
        String direccion = sc.nextLine();
        System.out.println("Telefono:");
        String telefono = sc.nextLine();
        System.out.println("Email:");
        String email = sc.nextLine();
        do {
            System.out.println("Edad:");
            String edadStr = sc.nextLine();
            edad = Validaciones.validarTipoDatoInt(edadStr);
            edadValida = Validaciones.validarEdad(edad);
        } while (!edadValida);
        System.out.println("CURP:");
        String CURP = sc.nextLine();
        System.out.println("RFC:");
        String RFC = sc.nextLine();
        System.out.println("Usuario");
        String usuario = sc.nextLine();
        System.out.println("Contraseña");
        String contrasena = sc.nextLine();

        int nuevoId = bancoActual.getClientes().size() + 1;

        Clientes nuevoCliente = new Clientes(new ArrayList<>(), nombres, apellidos, direccion, telefono, email, edad, CURP, RFC, nuevoId, usuario, contrasena);
        bancoActual.getClientes().add(nuevoCliente);
        System.out.println("Cliente agregado exitosamente");
    }

    public static void eliminarCuentaCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Numero de cuenta:");
        String cuenta = sc.nextLine();
        for (Clientes cliente : bancoActual.getClientes()) {
            cliente.getCuentaBancaria().removeIf(cuentaBancaria -> cuentaBancaria.getNumeroCuenta().equals(cuenta));
        }
    }

    public static void eliminarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("id del usuario:");
        String ida = sc.nextLine();
        int id = Validaciones.validarTipoDatoInt(ida);
        if (id == 0) {
            System.out.println("solo se aceptan numeros");
            return;
        }
        for (int i = 0; i < bancoActual.getClientes().size(); i++) {
            if (bancoActual.getClientes().get(i).getId() == id) {
                bancoActual.getClientes().remove(i);
                System.out.println("cliente eliminado");
                return;
            }
        }
        System.out.println("Cliente no encontrado");
    }



    public static void agregarEmpleados(){
        Scanner sc = new Scanner(System.in);
        String opcion;
        int op;
        int edad;
        boolean edadValida;

        do{
            System.out.println("Que tipo de empleado?");
            System.out.println("1. Cajero");
            System.out.println("2. SubGerente");
            System.out.println("3. Atencion al Cliente");
            opcion = sc.nextLine();
            op = Validaciones.validarTipoDatoInt(opcion);

            if(op==0){
                System.out.println("No se aceptan caracteres");
            }
            else{
                System.out.println("Usuario:");
                String usuario = sc.nextLine();
                System.out.println("Contraseña:");
                String contrasena = sc.nextLine();
                System.out.println("Nombre:");
                String nombres = sc.nextLine();
                System.out.println("Apellidos:");
                String apellidos = sc.nextLine();
                System.out.println("Direccion:");
                String direccion = sc.nextLine();
                System.out.println("Telefono:");
                String telefono = sc.nextLine();
                System.out.println("Email:");
                String email = sc.nextLine();
                do{
                    System.out.println("Edad:");
                    String edadStr = sc.nextLine();
                    edad = Validaciones.validarTipoDatoInt(edadStr);
                    edadValida = Validaciones.validarEdad(edad);
                }while(!edadValida);
                System.out.println("CURP:");
                String CURP = sc.nextLine();
                System.out.println("RFC:");
                String RFC = sc.nextLine();

                int nuevoId = bancoActual.getEmpleados().size() + 1;

                if(op == 1){
                    Empleados nuevoCajero = new Cajero(contrasena, usuario, nombres, apellidos, direccion, telefono, email, edad, CURP, RFC, nuevoId);
                    bancoActual.getEmpleados().add(nuevoCajero);
                }
                else if(op == 2){
                    Empleados nuevoSubGerente = new SubGerente(contrasena, usuario, nombres, apellidos, direccion, telefono, email, edad, CURP, RFC, nuevoId);
                    bancoActual.getEmpleados().add(nuevoSubGerente);
                }
                else if(op == 3){
                    Empleados nuevoAtencion = new AtencionAlCliente(contrasena, usuario, nombres, apellidos, direccion, telefono, email, edad, CURP, RFC, nuevoId);
                    bancoActual.getEmpleados().add(nuevoAtencion);
                }
                System.out.println("Empleado agregado exitosamente");
                return;
            }
        }while(true);
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
        for(int i = 0; i <  bancoActual.getEmpleados().size(); i++){
            if ( bancoActual.getEmpleados().get(i).getId() == id &&  bancoActual.getEmpleados().get(i).getTipoEmpleado() != TipoEmpleado.gerente ) {
                bancoActual.getEmpleados().remove(i);
                System.out.println("cliente retirado");
                return;
            }
        }
        System.out.println("Cliente no encontrado");
    }

    public static void verCliente(){
        for(Clientes cliente : bancoActual.getClientes()){
            System.out.println(cliente.getNombres() + " " + cliente.getApellidos());
            for(CuentaBancaria cuentaBancaria : cliente.getCuentaBancaria()){
                System.out.println("1- " + cuentaBancaria.getNumeroCuenta());
            }
        }
    }

    public static void verEmpleados(){
        for(Empleados empleado : bancoActual.getEmpleados()){
            System.out.println(empleado.getNombres() + " " + empleado.getApellidos());
        }
    }

    public static void desbloquearTarjeta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Numero de cuenta:");
        String cuenta = sc.nextLine();
        for(Clientes cliente : bancoActual.getClientes()){
            for (CuentaBancaria cuentaBancaria : cliente.getCuentaBancaria()){
                if(cuentaBancaria.getNumeroCuenta().equals(cuenta) && cuentaBancaria.getEstado() == Estado.Bloqueado){
                    cuentaBancaria.setEstado(Estado.Activo);
                }
            }
     }
    }
}