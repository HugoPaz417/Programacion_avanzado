package clase2.Clases;

public class Cliente {
    int idClie;
    String Cedula;
    String Nombres;
    String Apellidos;
    Direcciones direcciones;

    public Cliente() {
    }

    public Cliente(int idClie, String cedula, String nombres, String apellidos, Direcciones direcciones) {
        this.idClie = idClie;
        Cedula = cedula;
        Nombres = nombres;
        Apellidos = apellidos;
        this.direcciones = direcciones;

    }

    public int getIdClie() {
        return idClie;
    }

    public void setIdClie(int idClie) {
        this.idClie = idClie;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public Direcciones getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(Direcciones direcciones) {
        this.direcciones = direcciones;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idClie=" + idClie +
                ", Cedula='" + Cedula + '\'' +
                ", Nombres='" + Nombres + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                '}';
    }
}
