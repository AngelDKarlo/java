package Auxiliares;

import Auxiliares.Enums.Estado;
import Auxiliares.Enums.EstadoTarjeta;
import Auxiliares.Enums.Permisos;
import Auxiliares.Enums.TipoTarjeta;
import Principales.Bancos;
import Principales.ClienteMoral;
import Principales.Clientes;
import Principales.CuentaBancaria.*;
import Principales.Empleados.*;
import Principales.TipoTarjetas.TCredito;
import Principales.TipoTarjetas.TDebito;
import Principales.TipoTarjetas.TDebitoEmpresa;
import Principales.TipoTarjetas.Tarjeta;

import java.util.ArrayList;

public class ConstruccionDeCuentas {

    public static Tarjeta TDebito = new TDebito("1234567891234567", Estado.Activo, 4321, TipoTarjeta.Debito, 0);
    public static Tarjeta TCredito = new TCredito("9876543211234567", Estado.Activo, 1234, TipoTarjeta.Credito, 0, 50000, true, EstadoTarjeta.NoAccion, 0);

    public static Bancos BBVA = new Bancos("BBVA", "2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    public static Bancos BANAMEX = new Bancos("BANAMEX", "2",  new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    public static CuentaBancaria cuentaCorriente = new CuentaCorriente("12345678", "1234567891234", Estado.Activo, new ArrayList<>(), new ArrayList<>(), 500, "1234", 0);
    public static CuentaBancaria cuentaInversion = new CuentaInversion("87654321", "4321987654321", Estado.Activo, new ArrayList<>(), 1000,  "4321", 0, new ArrayList<>());

    public static Clientes Malibran = new Clientes(new ArrayList<>(), "Felipe Gamaliel", "Malibran Gonzalez", "En el bosque", "83412345678", "2430594@upv.edu.mx", 50, "efnonasdbiusac2213123", "12sdaadeafniovion", 1, "malibranSistematico", "malibran");

    public static Clientes Osama = new Clientes(new ArrayList<>(), "Ozama", "Malibran Gonzalez", "En el bosque", "8349876543", "2430257@upv.edu.mx", 16, "efnonasdbiusacvsdj12", "12sdaadeafn123ion", 3, "ozamapass", "ozama");
    public static Tarjeta Thijo = new TDebito("5432167890123456", Estado.Activo, 7890, TipoTarjeta.Debito, 0);
    public static CuentaBancaria cuentaHijo = new CuentaMenorDeEdad("1235678901234", "1234567973452", Estado.Activo, new ArrayList<>(), new ArrayList<>(), 1000, "7654", 0, Malibran);

    public static Tarjeta tarjetaAhorro = new TDebito("1111222233334444", Estado.Activo, 5555, TipoTarjeta.Debito, 0);
    public static CuentaBancaria cuentaAhorro = new CuentaAhorro("11112222", "1111222233334444", Estado.Activo, new ArrayList<>(), new ArrayList<>(), 15000, "5555", 0);
    public static Clientes Jack = new Clientes(new ArrayList<>(), "Jack", "Bacon", "En el mar", "5551234567", "jackz@email.com", 35, "ROML850615MDFXXX01", "ROML850615ABC", 4, "123", "jack");

    public static Tarjeta tarjetaEstudiantil = new TDebito("2222333344445555", Estado.Activo, 6666, TipoTarjeta.Debito, 0);
    public static CuentaBancaria cuentaEstudiantil = new CuentaEstudiantil("22223333", "2222333344445555", Estado.Activo, new ArrayList<>(), new ArrayList<>(), 2500, "6666", 0);
    public static Clientes sofi= new Clientes(new ArrayList<>(), "Sofi", "Malibran", "en la ciuadad", "5559876543", "sofi@gmail.com", 20, "MEGC030215HDFXXX02", "MEGC030215DEF", 5, "432", "sofi");

    public static ArrayList<CuentaBancaria> cuentaMalibran = new ArrayList<>();
    public static ArrayList<CuentaBancaria> cuentaOsama = new ArrayList<>();
    public static ArrayList<CuentaBancaria> cuentajesus = new ArrayList<>();
    public static ArrayList<CuentaBancaria> cuentaMaria = new ArrayList<>();
    public static ArrayList<CuentaBancaria> cuentaCarlos = new ArrayList<>();

    public static ArrayList<Clientes> clientesBBVA = new ArrayList<>();
    public static ArrayList<Clientes> clientesBanamex = new ArrayList<>();

    public static ArrayList<Tarjeta> tarjetas = new ArrayList<>();
    public static ArrayList<Tarjeta> tarjetas2 = new ArrayList<>();
    public static ArrayList<Tarjeta> tarjetas3 = new ArrayList<>();
    public static ArrayList<Tarjeta> tarjetasHijo = new ArrayList<>();
    public static ArrayList<Tarjeta> tarjetasAhorro = new ArrayList<>();
    public static ArrayList<Tarjeta> tarjetasEstudiantil = new ArrayList<>();

    public static ArrayList<Empleados> empleadosBBVA = new ArrayList<>();
    public static ArrayList<Empleados> empleadosBanamex = new ArrayList<>();
    public static ArrayList<ClienteMoral> empresasBBVA = new ArrayList<>();
    public static ArrayList<ClienteMoral> empresasBanamex = new ArrayList<>();
    public static ArrayList<Bancos> bancos = new ArrayList<>();
    public static ArrayList<Clientes> clientesDiscord = new ArrayList<>();

    public static Tarjeta TDebitoEmpresa= new TDebitoEmpresa("1234567891234567", Estado.Activo, 4321, TipoTarjeta.Debito, 0, 10000, Permisos.Basico);
    public static CuentaBancaria cuentaNomina = new CuentaNomina("09876543", "7654321891234", Estado.Activo, new ArrayList<>(), new ArrayList<>(),  500, "9876", 0);
    public static Clientes Jesus = new Clientes(new ArrayList<>(), "Jesus Juarez", "Ramirez", "En el mar", "83412345678", "2330192@upv.edu.mx", 49, "efnonasdbiusac2213123", "12sdaadeafniovion", 2, "contraseña", "jesus");

    public static Tarjeta tarjetaEmpresa = new TDebito("0987654321123456", Estado.Activo, 4321, TipoTarjeta.Debito, 0);
    public static CuentaBancaria cuentaEmpresa = new CuentaEmpresa("98765432", "2345678987654", Estado.Activo, new ArrayList<>(), new ArrayList<>(), 1000000, "5432", 0, new ArrayList<>());
    public static ClienteMoral Discord = new ClienteMoral("Discord", "Cerca", "ewui23bui3bu21", cuentaEmpresa, "12345", "Discord", new ArrayList<>());

    public static Empleados gerente = new Gerente("zote", "Gerente", "Angel", "Enciso Garcen", "nose", "1982368792163", "123@gmalil.com", 12, "ABCD1234DFGHI", "asbusaudnusad", 1);
    public static Empleados cajero = new Cajero("12345", "Cajero", "Angel", "Enciso Garcen", "nose", "1982368792163", "123@gmalil.com", 12, "ABCD1234DFGHI", "asbusaudnusad", 2);
    public static Empleados subgerente = new SubGerente("56789", "SubGerente", "Angel", "Enciso Garcen", "nose", "1982368792163", "123@gmalil.com", 12, "ABCD1234DFGHI", "asbusaudnusad", 3);
    public static Empleados atencionAlCliente = new AtencionAlCliente("09876", "AtencionAlCliente", "Angel", "Enciso Garcen", "nose", "1982368792163", "123@gmalil.com", 12, "ABCD1234DFGHI", "asbusaudnusad", 4);

    public static Bancos bancoActual;
    public static CuentaBancaria cuentaActual;
    public static Clientes clienteActual;
    public static Tarjeta tarjetaActual;
    public static ClienteMoral clienteMoralActual;
    public static Empleados empleadoAcctual;

    public static CuentaBancaria cuentaRecibe;
    public static Clientes clienteRecibe;

    public static void inicializarDatos() {
        tarjetas.add(TDebito);
        tarjetas.add(TCredito);
        cuentaCorriente.setTarjetas(tarjetas);

        cuentaMalibran.add(cuentaCorriente);
        cuentaMalibran.add(cuentaInversion);
        Malibran.setCuenta(cuentaMalibran);

        tarjetasHijo.add(Thijo);
        cuentaHijo.setTarjetas(tarjetasHijo);
        cuentaOsama.add(cuentaHijo);
        Osama.setCuenta(cuentaOsama);

        tarjetasAhorro.add(tarjetaAhorro);
        cuentaAhorro.setTarjetas(tarjetasAhorro);
        cuentaMaria.add(cuentaAhorro);
        Jack.setCuenta(cuentaMaria);

        tarjetasEstudiantil.add(tarjetaEstudiantil);
        cuentaEstudiantil.setTarjetas(tarjetasEstudiantil);
        cuentaCarlos.add(cuentaEstudiantil);
        sofi.setCuenta(cuentaCarlos);

        tarjetas2.add(TDebitoEmpresa);
        cuentaNomina.setTarjetas(tarjetas2);
        cuentajesus.add(cuentaNomina);
        Jesus.setCuenta(cuentajesus);

        tarjetas3.add(tarjetaEmpresa);
        cuentaEmpresa.setTarjetas(tarjetas3);

        clientesBBVA.add(Malibran);
        clientesBBVA.add(Osama);
        clientesBBVA.add(Jack);
        clientesBBVA.add(sofi);

        clientesBanamex.add(Jesus);

        empleadosBBVA.add(gerente);
        empleadosBBVA.add(subgerente);
        empleadosBBVA.add(cajero);
        empleadosBBVA.add(atencionAlCliente);

        empresasBanamex.add(Discord);
        clientesDiscord.add(Jesus);
        Discord.setEmpleados(clientesDiscord);

        BBVA.setClientes(clientesBBVA);
        BBVA.setEmpleados(empleadosBBVA);

        BANAMEX.setClientes(clientesBanamex);
        BANAMEX.setEmpleados(empleadosBBVA);
        BANAMEX.setClientesMorales(empresasBanamex);

        bancos.add(null);
        bancos.add(BANAMEX);
        bancos.add(BBVA);
    }
}