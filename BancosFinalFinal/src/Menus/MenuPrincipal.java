package Menus;

import Auxiliares.Validaciones;

import java.util.Scanner;
import static Auxiliares.ConstruccionDeCuentas.*;


public class MenuPrincipal {

    public void menuP() {
        MenuClientes menuC = new MenuClientes();
        MenuEmpleados menuE = new MenuEmpleados();

        tarjetas.add(TDebito);
        tarjetas.add(TCredito);
        cuentaCorriente.setTarjetas(tarjetas);
        cuentaMalibran.add(cuentaCorriente);
        cuentaMalibran.add(cuentaInversion);
        Malibran.setCuenta(cuentaMalibran);
        clientes.add(Malibran);

        tarjetas2.add(TDebitoEmpresa);
        cuentaNomina.setTarjetas(tarjetas2);
        cuentajesus.add(cuentaNomina);
        Jesus.setCuenta(cuentajesus);
        clientes.add(Jesus);


        tarjetas3.add(tarjetaEmpresa);
        cuentaEmpresa.setTarjetas(tarjetas3);
        empresas.add(Discord);


        empleados.add(gerente);
        empleados.add(subgerente);
        empleados.add(cajero);
        empleados.add(atencionAlCliente);



        Scanner sc = new Scanner(System.in);
        String opcion;
        int op;
        do{
            System.out.println("***********************************");
            System.out.println("Bienvenido");
            System.out.println("Como que rol deseas ingresar?");
            System.out.println("1. Cliente");
            System.out.println("2. Empleado");
            System.out.println("3. Salir");
            System.out.println("***********************************");
            opcion = sc.nextLine();
            op = Validaciones.validarTipoDatoInt(opcion);

            switch (op) {
                case 1:
                    menuC.inicioSesion();
                    break;
                case 2:
                    menuE.menuInicioSesionEmpleados();
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("No se aceptan caracteres");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while(op != 3);
    }
}
