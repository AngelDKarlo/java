package Auxiliares;

import Principales.Clientes;
import Principales.Historial;

import java.util.ArrayList;

import static Auxiliares.ConstruccionDeCuentas.*;

public class GenerarHistorial {

    private static int id =0;

    public static void darFolio(String transaccion, double monto) {
        //Generacion de los datos para el folio dependiendo de los datos de usuario
        //Ver qué tipo de transaccion es y poner los datos correspondientes}

        id++;

        Historial historial = new Historial(transaccion,monto,clienteActual,clienteRecibe,id);
        ArrayList<Historial> historialcliente = cuentaActual.getHistorial();
        historialcliente.add(historial);

        System.out.println("******************Folio***********************");
        System.out.println("Nombre: " + clienteActual.getNombres());
        System.out.println("Banco: " + cuentaActual.getBancos().getNombreBanco());
        if(tarjetaActual != null){
            System.out.println("Numero de Tarjeta: " + tarjetaActual.getNumeroTarjeta());
        }
        System.out.println("Numero de folio: " + id);
        System.out.println("Transaccion: " + transaccion);
        if(transaccion.equals("Transferencia Interbancaria") || transaccion.equals("Transferencia")){
            System.out.println("Nombre del destinatario: " + clienteRecibe.getNombres() + " " + clienteRecibe.getApellidos());
            System.out.println("Numero de su cuenta: " + cuentaRecibe.getNumeroCuenta());
        }
        System.out.println("Monto: " + monto);
        System.out.println("*********************************************");
    }
}
