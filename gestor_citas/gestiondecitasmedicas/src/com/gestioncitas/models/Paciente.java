package com.gestioncitas.models;

import java.util.Date;

/**
 * Modelo para un Paciente
 */
public class Paciente {
    private String id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String email;
    private Date fechaNacimiento;
    private String direccion;
    
    // Constructor vacío
    public Paciente() {
    }
    
    // Constructor con parámetros
    public Paciente(String id, String nombre, String apellido, String cedula, 
                   String telefono, String email, Date fechaNacimiento, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }
    
    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}