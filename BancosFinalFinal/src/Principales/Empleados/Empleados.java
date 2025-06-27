package Principales.Empleados;

import Auxiliares.Enums.TipoEmpleado;
import Principales.Usuarios;



public abstract class Empleados extends Usuarios{
    private TipoEmpleado tipoEmpleado;
    
    public Empleados(String contrasena, String usuario, String nombres, String apellidos, String direccion, String telefono, String email, int edad,  String CURP, String RFC, TipoEmpleado tipoEmpleado, int id) {
        super(nombres, apellidos, direccion, telefono, email, edad, CURP, RFC, id, contrasena, usuario);
        this.tipoEmpleado = tipoEmpleado;
    }

    public abstract void mostrarMenu();


    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }
    

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
}
