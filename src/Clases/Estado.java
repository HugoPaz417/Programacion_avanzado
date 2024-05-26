package Clases;

import java.time.LocalDate;
import java.util.Date;

public class Estado {
    int tipo;
    String estado;
    LocalDate fecha;
    String observacion;
    public Estado(){}
    public Estado(int tipo, String estado, LocalDate fecha, String observacion) {
        this.tipo = tipo;
        this.estado = estado;
        this.fecha = fecha;
        this.observacion = observacion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "tipo=" + tipo +
                ", estado='" + estado + '\'' +
                ", fecha=" + fecha +
                ", observacion='" + observacion + '\'' +
                '}';
    }
}
