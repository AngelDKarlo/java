package Principales.Empleados;

import Auxiliares.Enums.TipoEmpleado;
import Principales.Usuarios;

import java.lang.invoke.StringConcatFactory;

public abstract class Empleados extends Usuarios{
    private String contrasena;
    private String usuario;
    private TipoEmpleado tipoEmpleado;
    
    public Empleados(String contrasena, String usuario, String nombres, String apellidos, String direccion, String telefono, String email, int edad,  String CURP, String RFC, TipoEmpleado tipoEmpleado, int id) {
        super(nombres, apellidos, direccion, telefono, email, edad, CURP, RFC, id);
        this.contrasena = contrasena;
        this.usuario = usuario;
    }

    public abstract void mostrarMenu();

    public String getContrasena() {
        return contrasena;
    }
    public String getUsuario() {
        return usuario;
    }
    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
}
