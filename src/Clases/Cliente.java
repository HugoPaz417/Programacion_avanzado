package Clases;

public class Cliente extends Persona{
    int idClie;
    String celular;
    Direccion direccion;
    public Cliente(){}
    public Cliente(String cedula, String nombres, String apellidos, String mail, String celular, int idClie, Direccion direccion) {
        super(cedula, nombres, apellidos, mail);
        this.celular = celular;
        this.direccion = direccion;
        this.idClie = idClie;
    }

    public int getIdClie() {
        return idClie;
    }

    public void setIdClie(int idClie) {
        this.idClie = idClie;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idClie=" + idClie +
                ", celular='" + celular + '\'' +
                ", direccion=" + direccion +
                ", cedula='" + cedula + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}