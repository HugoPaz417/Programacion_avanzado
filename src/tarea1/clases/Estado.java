package tarea1.clases;

import java.time.LocalDate;

public class Estado {
    int idEst;
    String estado;
    LocalDate fecha;

    public Estado() {
    }

    public Estado(int idEst, String estado, LocalDate fecha) {
        this.idEst = idEst;
        this.estado = estado;
        this.fecha = fecha;
    }

    public int getIdEst() {
        return idEst;
    }

    public void setIdEst(int idEst) {
        this.idEst = idEst;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "idEst=" + idEst +
                ", estado='" + estado + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
