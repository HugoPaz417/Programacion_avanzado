package tarea1.clases;

public class Paquete {
    int idPaq;
    String codigo;
    String descripcion;
    double peso;
    double largo;
    double ancho;

    public Paquete() {
    }

    public Paquete(int idPaq, String codigo, String descripcion, double peso, double largo, double ancho) {
        this.idPaq = idPaq;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.peso = peso;
        this.largo = largo;
        this.ancho = ancho;
    }

    public int getIdPaq() {
        return idPaq;
    }

    public void setIdPaq(int idPaq) {
        this.idPaq = idPaq;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "idPaq=" + idPaq +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", peso=" + peso +
                ", largo=" + largo +
                ", ancho=" + ancho +
                '}';
    }
}
