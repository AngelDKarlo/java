package Principales.Empleados;

import Auxiliares.Enums.TipoEmpleado;
import Menus.MenuEmpleados;

public class AtencionAlCliente extends Empleados{
    public AtencionAlCliente(String contrasena, String usuario, String nombres, String apellidos, String direccion, String telefono, String email, int edad,  String CURP, String RFC, int id) {
        super(contrasena, usuario, nombres, apellidos, direccion, telefono, email, edad, CURP, RFC, TipoEmpleado.atencionAlCliente, id);
    }

    @Override
    public void mostrarMenu(){
        MenuEmpleados menuEmpleados  = new MenuEmpleados();
        menuEmpleados.menuAtencionAlCliente();
    }
}
