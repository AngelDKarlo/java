package Auxiliares;

import Auxiliares.Enums.Estado;
import Auxiliares.Enums.EstadoTarjeta;
import Auxiliares.Enums.Permisos;
import Auxiliares.Enums.TipoTarjeta;
import Principales.Bancos;
import Principales.ClienteMoral;
import Principales.Clientes;
import Principales.CuentaBancaria.*;
import Principales.TipoTarjetas.TCredito;
import Principales.TipoTarjetas.TDebito;
import Principales.TipoTarjetas.TDebitoEmpresa;
import Principales.TipoTarjetas.Tarjeta;

import java.util.ArrayList;

public class ConstruccionDeCuentas {

    //todo: Cuentas de Malibran

    public static Tarjeta TDebito = new TDebito("1234567891234567", Estado.Activo, 4321, TipoTarjeta.Debito, 0);
    public static Tarjeta TCredito = new TCredito("9876543211234567", Estado.Activo, 1234, TipoTarjeta.Credito, 0, 50000, true, EstadoTarjeta.NoAccion, 0);

    public static Bancos BBVA = new Bancos("BBVA", "2");
    public static Bancos BANAMEX = new Bancos("BANAMEX", "2");

    public static CuentaBancaria cuentaCorriente = new CuentaCorriente("12345678", "1234567891234", Estado.Activo, new ArrayList<>(), new ArrayList<>(), BBVA, 500, "1234", 0);
    public static CuentaBancaria cuentaInversion = new CuentaInversion("87654321", "4321987654321", Estado.Activo, new ArrayList<>(), BBVA, 1000,  "4321", 0, new ArrayList<>());

    public static Clientes Malibran = new Clientes(new ArrayList<>(), "Felipe Gamaliel", "Malibran Gonzalez", "En el bosque", "83412345678", "2430594@upv.edu.mx", 50, "efnonasdbiusac2213123", "12sdaadeafniovion");

    public static ArrayList<CuentaBancaria> cuentaMalibran = new ArrayList<>();
    public static ArrayList<CuentaBancaria> cuentajesus = new ArrayList<>();
    public static ArrayList<Clientes> clientes = new ArrayList<>();
    public static ArrayList<Clientes> clientesEmpresa = new ArrayList<>();
    public static ArrayList<Tarjeta> tarjetas = new ArrayList<>();
    public static ArrayList<Tarjeta> tarjetas2 = new ArrayList<>();

    //todo: Empleado del cliente moral
    public static Tarjeta TDebitoEmpresa= new TDebitoEmpresa("1234567891234567", Estado.Activo, 4321, TipoTarjeta.Debito, 0, 10000, Permisos.Basico);

    public static CuentaBancaria cuentaNomina = new CuentaNomina("09876543", "7654321891234", Estado.Activo, new ArrayList<>(), new ArrayList<>(), BANAMEX, 500, "9876", 0);

    public static Clientes Jesus = new Clientes(new ArrayList<>(), "Jesus Juarez", "Ramirez", "En el mar", "83412345678", "2330192@upv.edu.mx", 49, "efnonasdbiusac2213123", "12sdaadeafniovion");

    //todo: Cliente moral
    public static ClienteMoral Discord = new ClienteMoral("Discord", "Cerca", "ewui23bui3bu21");

    public static CuentaBancaria cuentaEmpresa = new CuentaEmpresa("98765432", "2345678987654", Estado.Activo, new ArrayList<>(), new ArrayList<>(), BANAMEX, 1000000, "5432", 0, new ArrayList<>(), Discord);

    //Cliente activo
    public static CuentaBancaria cuentaActual;
    public static Clientes clienteActual;
    public static Tarjeta tarjetaActual;

    //Cliente que recibe dinero
    public static CuentaBancaria cuentaRecibe;
    public static Clientes clienteRecibe;
    public static Tarjeta tarjetaRecibe;
}
