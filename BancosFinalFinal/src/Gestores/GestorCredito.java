package Gestores;

import Auxiliares.Enums.EstadoTarjeta;
import Auxiliares.PeticionCredito;
import Auxiliares.Validaciones;
import Principales.Clientes;
import Principales.CuentaBancaria.CuentaBancaria;
import Principales.TipoTarjetas.TCredito;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorCredito {
    private static GestorCredito instance;

    private static volatile ArrayList<PeticionCredito> peticionPendientes;

    private GestorCredito() {
        peticionPendientes = new ArrayList<>();
    }

    public static GestorCredito getInstance() {
        if (instance == null) {
            synchronized (GestorCredito.class) {
                instance = new GestorCredito();
            }
        }
        return instance;
    }

    public void agregarPeticionCredito(PeticionCredito peticionCredito) {
        peticionPendientes.add(peticionCredito);
    }

    public ArrayList<PeticionCredito> obtenerPeticionesPendientes() {
        return new ArrayList<>(peticionPendientes);
    }

    public void aprobarPeticion(int id) {
        for (PeticionCredito peticionCredito : peticionPendientes) {
            if (peticionCredito.getId() == id) {
                Clientes clientes = peticionCredito.getClienteSolicitante();

                for (CuentaBancaria cuenta : clientes.getCuentaBancaria()) {

                    if (cuenta.getTarjetas().contains(peticionCredito.getTarjetaCredito())) {
                        cuenta.setSaldo(cuenta.getSaldo() + peticionCredito.getCredito());

                        if (peticionCredito.getTarjetaCredito() instanceof TCredito credito) {
                            credito.setEstadoT(EstadoTarjeta.Aceptado);
                            credito.setDineroPagado(credito.getDineroPagado() + peticionCredito.getCredito());
                        }

                        peticionPendientes.remove(peticionCredito);

                        System.out.println("Credito aceptado");
                        return;
                    }
                }
            }
        }
    }

    public void rechazarPeticion(int id) {

        for (PeticionCredito peticionCredito : peticionPendientes) {
            if (peticionCredito.getId() == id) {
                if(peticionCredito.getTarjetaCredito() instanceof TCredito credito){
                    credito.setEstadoT(EstadoTarjeta.Rechazado);
                }
                peticionPendientes.remove(peticionCredito);
                System.out.println("Credito rechazado");
                return;
            }
        }

    }

    public void verCreditos(){
        Scanner sc = new Scanner(System.in);

        for (PeticionCredito peticionCredito : peticionPendientes) {
            System.out.println("***********************************");
            System.out.println("Credito: " + peticionCredito.getCredito());
            System.out.println("Cliente: " + peticionCredito.getClienteSolicitante());
            System.out.println("Tarjeta: " + peticionCredito.getTarjetaCredito());
            System.out.println("Fecha: " + peticionCredito.getFecha());
            System.out.println("id: " + peticionCredito.getId());
            System.out.println("***********************************\n");
        }

        System.out.println("Que haras?");
        System.out.println("1. Rechazar credito");
        System.out.println("2. Aceptar credito");
        System.out.println("3. Salir");
        String opcion = sc.nextLine();
        int op = Validaciones.validarTipoDatoInt(opcion);
        switch (op) {
            case 1:
                System.out.println("Cual es el id del credito?");
                int idRechazar = Validaciones.validarTipoDatoInt(sc.nextLine());
                rechazarPeticion(idRechazar);
                break;
            case 2:
                System.out.println("Cual es el id del credito?");
                int idAprobar = Validaciones.validarTipoDatoInt(sc.nextLine());
                aprobarPeticion(idAprobar);
                break;
        }
    }

}
