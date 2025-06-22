package Gestores;

import Auxiliares.Enums.EstadoInversion;
import Auxiliares.GenerarHistorial;
import Auxiliares.Validaciones;
import Principales.CuentaBancaria.CuentaInversion;
import Principales.Inversion;

import java.util.ArrayList;
import java.util.Scanner;

import static Auxiliares.ConstruccionDeCuentas.*;

public class GestorInverciones {

    public static void calcularInversiones(Inversion inversion) {
        double monto = inversion.getMonto();
        double icr = inversion.getIcr();
        double interesMensual = (inversion.getIntereses() * icr) / 12;
        double plazos = inversion.getPlazos();
        int mesActual = inversion.getMeses();
        int mesestotales = (int)plazos;

        if(mesActual>=mesestotales){
            inversion.setEstadoInversion(EstadoInversion.Acabada);
            return;
        }

        double nuevoMonto = monto * (1 + interesMensual);
        inversion.setMonto(nuevoMonto);

        inversion.setMeses(mesActual + 1);
    }

    public static void nuevaInversion() {
        Scanner sc = new Scanner(System.in);
        String opcion;
        int op;
        double Intereses;
        double icr;
        int plazo;
        double monto;
        ciclo:
        do{
            System.out.println("Que tipo de inversion sera?");
            System.out.println("1. Bajo riesgo");
            System.out.println("2. Medio riesgo");
            System.out.println("3. Alto riesgo");
            opcion = sc.nextLine();
            op = Validaciones.validarTipoDatoInt(opcion);
            switch(op){
                case 1:
                    Intereses = 0.02;
                    icr = 0.16;
                    break ciclo;
                case 2:
                    Intereses = 0.04;
                    icr = 0.16;
                    break ciclo;
                case 3:
                    Intereses = 0.08;
                    icr = 0.16;
                    break ciclo;
                default:
                    System.out.println("Opcion no valida");
            }
        }while(true);

        boolean esValido;
        do{
            System.out.println("Cuanto dinero vas a invertir?");
            String m = sc.nextLine();
            System.out.println("A que plazo?");
            String p = sc.nextLine();
            plazo = Validaciones.validarTipoDatoInt(p);
            monto =  Validaciones.validarTipoDatoDouble(m);
            esValido = Validaciones.validarMonto(monto);
            if (plazo == 0){
                System.out.println("No se permiten caracteres o 0");
                esValido = false;
            }
        }while(!esValido);

        Inversion nuevaInversion = new Inversion(Intereses,icr , monto, plazo, 0);

        if(cuentaActual instanceof CuentaInversion cuentaInversion){
            cuentaInversion.agregarInversion(nuevaInversion);
            cuentaInversion.setSaldo(cuentaInversion.getSaldo() - monto);
        }
    }

    public static void retirarInversion() {
        Scanner sc = new Scanner(System.in);
        if(cuentaActual instanceof CuentaInversion cuentaInversion){
            ArrayList<Inversion> inversiones = cuentaInversion.getInversionesActuales();
            if (inversiones.isEmpty()){
                System.out.println("No tinees inversiones activas");

            }
            else {
                System.out.println("Inversiones disponibles:");
                for (int  i = 0; i < inversiones.size(); i++) {
                    Inversion Inv = inversiones.get(i);
                    System.out.println((i+1) + ". Monto: " +  Inv.getMonto() + " Plazo: " + Inv.getPlazos() + " Meses" + " Estado: " + Inv.getEstadoInversion());
                }

                System.out.println("Que inversion deseas retirar? (por numero)");
                String opcion = sc.nextLine();
                int op = Validaciones.validarTipoDatoInt(opcion) - 1;

                if(op >= 0 && op < inversiones.size()){
                    Inversion inversionRetirada = inversiones.get(op);

                    double SaldoAnterior = cuentaActual.getSaldo();
                    double montoRetirado = inversionRetirada.getMonto();

                    if(cuentaInversion.getHiloInversion() != null && cuentaInversion.getHiloInversion().getCorriendo()){
                        cuentaInversion.getHiloInversion().setCorriendo(false);
                        try{
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    double nuevoSaldo = SaldoAnterior + montoRetirado;
                    cuentaActual.setSaldo(nuevoSaldo);

                    cuentaInversion.quitarInversion(inversionRetirada);

                    if (cuentaInversion.getHiloInversion() != null){
                        cuentaInversion.getHiloInversion().setCorriendo(true);
                    }

                    GenerarHistorial.darFolio("Retiro de inversion", montoRetirado);
                }
                else{
                    System.out.println("opcion invalida");
                }
            }
        }
    }

    public static void mostrarInversiones(){
        System.out.println("Inversiones disponibles:");
        if (cuentaActual instanceof CuentaInversion cuentaInversion){
            ArrayList<Inversion> inversiones = cuentaInversion.getInversionesActuales();
            for (int  i = 0; i < inversiones.size(); i++) {
                Inversion Inv = inversiones.get(i);
                System.out.println((i+1) + ". Monto: " +  Inv.getMonto() + " Plazo: " + Inv.getPlazos() + " Meses");
            }
        }
    }

}
