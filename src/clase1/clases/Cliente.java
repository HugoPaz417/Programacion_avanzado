package clase1.clases;

import java.util.ArrayList;

public class Cliente {
    String Cedula;
    String Nombre;
    String Apellido;
    Direcciones direcciones;
    ArrayList<Hijos> hijos;

    public Cliente() {
//        hijos = new ArrayList<>();
    }
    public Cliente(String cedula, String nombre, String apellido, Direcciones direcciones) {
        Cedula = cedula;
        Nombre = nombre;
        Apellido = apellido;
        this.direcciones = direcciones;
        hijos = new ArrayList<>();
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Direcciones getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(Direcciones direcciones) {
        this.direcciones = direcciones;
    }

    public ArrayList<Hijos> getHijos() {
        return hijos;
    }

    public void setHijos(Hijos hijo) {
        hijos.add(hijo);
    }

}