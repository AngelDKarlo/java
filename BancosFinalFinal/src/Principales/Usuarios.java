package Principales;

import java.time.LocalDate;

public class Usuarios {
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String email;
    private int edad;
    private String CURP;
    private String RFC;
    private int id;

    public Usuarios(String nombres, String apellidos, String direccion, String telefono, String email, int edad,  String CURP, String RFC, int id) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.edad = edad;
        this.CURP = CURP;
        this.RFC = RFC;
        this.id = id;
    }

    //getters
    public String getNombres() {
        return nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getEmail() {
        return email;
    }
    public int getEdad() {
        return edad;
    }
    public String getCURP() {
        return CURP;
    }
    public String getRFC() {
        return RFC;
    }
    public int getId() {
        return id;
    }

    //Setters
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setCURP(String CURP) {
        this.CURP = CURP;
    }
    public void setRFC(String RFC) {
        this.RFC = RFC;
    }
    public void setId(int id) {
        this.id = id;
    }
}
