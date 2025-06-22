package Controladores;

import Auxiliares.Validaciones;

import java.util.Scanner;
import static Auxiliares.ConstruccionDeCuentas.*;


public class MenuPrincipal {

    public void menuP() {
        MenuClientes menuC = new MenuClientes();

        tarjetas.add(TDebito);
        tarjetas.add(TCredito);
        cuentaCorriente.setTarjetas(tarjetas);
        cuentaMalibran.add(cuentaCorriente);
        cuentaMalibran.add(cuentaInversion);
        Malibran.setCuenta(cuentaMalibran);
        clientes.add(Malibran);

        Scanner sc = new Scanner(System.in);
        String opcion;
        int op;
        System.out.println("***********************************");
        System.out.println("Bienvenido");
        System.out.println("Como que rol deseas ingresar?");
        System.out.println("1. Cliente");
        System.out.println("2. Cajero");
        System.out.println("3. Atencion al cliente");
        System.out.println("4. Gerente");
        System.out.println("5. SubGerente");
        System.out.println("6. Salir");
        System.out.println("***********************************");
        opcion = sc.nextLine();
        op = Validaciones.validarTipoDatoInt(opcion);

        switch (op) {
            case 1:
                menuC.inicioSesion();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 0:
                System.out.println("No se aceptan caracteres");
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }


    }
}
