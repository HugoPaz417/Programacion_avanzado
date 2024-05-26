package Clases;

public class Paquete {
    String idpaq;
    String codigo;
    String descripcion;
    double peso;
    double alto;
    double ancho;
    Estado estado;
    public Paquete(){}

    public Paquete(String idpaq, String codigo, String descripcion, double peso, double alto, double ancho, Estado estado) {
        this.idpaq = idpaq;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.peso = peso;
        this.alto = alto;
        this.ancho = ancho;
        this.estado = estado;
    }

    public String getIdpaq() {
        return idpaq;
    }

    public void setIdpaq(String idpaq) {
        this.idpaq = idpaq;
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

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "idpaq='" + idpaq + '\'' +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", peso=" + peso +
                ", alto=" + alto +
                ", ancho=" + ancho +
                ", estado=" + estado +
                '}';
    }
}
