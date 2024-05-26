package Clases;

public class Repartidor extends Empleado{
    int zona;
    Empleado empleado;

    public Repartidor(String cedula, String nombres, String apellidos, String mail, String ciudad, int zona, Empleado empleado) {
        super(cedula, nombres, apellidos, mail, ciudad);
        this.zona = zona;
        this.empleado = empleado;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Repartidor{" +
                "zona=" + zona +
                ", empleado=" + empleado +
                ", ciudad='" + ciudad + '\'' +
                ", cedula='" + cedula + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    //Void para cambiar estados de paquete
    void HacerActual(Cliente cliente){

    }
}
