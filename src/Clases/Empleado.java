package Clases;

public class Empleado extends Persona{
    String ciudad;

    public Empleado(String cedula, String nombres, String apellidos, String mail, String ciudad) {
        super(cedula, nombres, apellidos, mail);
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "ciudad='" + ciudad + '\'' +
                ", cedula='" + cedula + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

}
