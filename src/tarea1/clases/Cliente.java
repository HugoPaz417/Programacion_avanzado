package tarea1.clases;

import java.util.ArrayList;

public class Cliente {
    int IdClie;
    String Cedula;
    String Nombres;
    String Apellidos;
    ArrayList <String> email;

    public Cliente() {
        email = new ArrayList<>();
    }

    public Cliente(int idClie, String cedula, String nombres, String apellidos, ArrayList<String> email) {
        IdClie = idClie;
        Cedula = cedula;
        Nombres = nombres;
        Apellidos = apellidos;
        this.email = email;
    }

    public int getIdClie() {
        return IdClie;
    }

    public void setIdClie(int idClie) {
        this.IdClie = idClie;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        this.Cedula = cedula;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        this.Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        this.Apellidos = apellidos;
    }

    public ArrayList<String> getEmail() {
        return email;
    }

    public void setListaCorreos(ArrayList<String> newList) {
        email = newList;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idClie=" + IdClie +
                ", cedula='" + Cedula + '\'' +
                ", nombres='" + Nombres + '\'' +
                ", apellidos='" + Apellidos + '\'' +
                ", email=" + email +
                '}';
    }
}
