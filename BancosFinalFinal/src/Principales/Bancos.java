package Principales;

import Principales.Empleados.Empleados;

import java.util.ArrayList;

public class  Bancos {
    private String nombreBanco;
    private String numSucursales;
    private ArrayList<Clientes> clientes;
    private ArrayList<Empleados> empleados;
    private ArrayList<ClienteMoral>  clientesMorales;


    public Bancos(String nombreBanco, String numSucursales, ArrayList<Clientes> clientes,  ArrayList<Empleados> empleados, ArrayList<ClienteMoral> clientesMorales) {
        this.nombreBanco = nombreBanco;
        this.numSucursales = numSucursales;
        this.clientes = clientes;
        this.empleados = empleados;
        this.clientesMorales = clientesMorales;
    }

    //Getters
    public String getNombreBanco() {
        return nombreBanco;
    }
    public String getNumSucursales() {
        return numSucursales;
    }
    public ArrayList<Clientes> getClientes() {
        return clientes;
    }
    public ArrayList<Empleados> getEmpleados() {
        return empleados;
    }
    public ArrayList<ClienteMoral> getClientesMorales() {
        return clientesMorales;
    }

    //setters
    public void setNumSucursales(String numSucursales) {
        this.numSucursales = numSucursales;
    }
    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }
    public void setClientes(ArrayList<Clientes> clientes) {
        this.clientes = clientes;
    }
    public void setEmpleados(ArrayList<Empleados> empleados) {
        this.empleados = empleados;
    }
    public void setClientesMorales(ArrayList<ClienteMoral> clientesMorales) {
        this.clientesMorales = clientesMorales;
    }
}
