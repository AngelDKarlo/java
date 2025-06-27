package Menus;

import Auxiliares.ConstruccionDeCuentas;
import Auxiliares.Validaciones;

import java.util.Scanner;
import static Auxiliares.ConstruccionDeCuentas.*;


public class MenuPrincipal {

    public void menuP() {
        MenuClientes menuC = new MenuClientes();
        MenuEmpleados menuE = new MenuEmpleados();

        ConstruccionDeCuentas.inicializarDatos();

        Scanner sc = new Scanner(System.in);
        String opcion;
        int op;

        menuBanco();

        do {
            System.out.println("A donde iras?");
            System.out.println("1. Entrar al banco");
            System.out.println("2. Ir al cajero");
            System.out.println("3. Salir");
            opcion = sc.nextLine();
            op = Validaciones.validarTipoDatoInt(opcion);

            switch (op) {
                case 1:
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
                    break;
                case 2:
                    menuE.menuCajero();
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("Opcion no valida");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        }while(op != 3);




    }

    public void menuBanco(){
        Scanner sc = new Scanner(System.in);
        String opcion;
        int op;

        do{
            System.out.println("A que banco estas ingresando?");
            for (int i = 1; i < bancos.size(); i++) {
                System.out.println(i + " " + bancos.get(i).getNombreBanco());
            }
            System.out.println("0. salir");
            opcion = sc.nextLine();
            op = Validaciones.validarTipoDatoInt(opcion);
            if(op >= 1 && bancos.size() > op){
                bancoActual =  bancos.get(op);
                break;
            }
            else {
                System.out.println("Opcion no valida");
            }
        }while(op != 0);
    }
}
