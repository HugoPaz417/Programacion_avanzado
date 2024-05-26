package Clases;

import java.util.Date;

public class Entrega {
    String codigo;
    Date fecha;
    String observacion;
    Cliente cliente;
    Empleado empleado;
    Paquete paquete;

    public Entrega(String codigo, Date fecha, String observacion, Cliente cliente, Empleado empleado, Paquete paquete) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.observacion = observacion;
        this.cliente = cliente;
        this.empleado = empleado;
        this.paquete = paquete;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    @Override
    public String toString() {
        return "Entrega{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", observacion='" + observacion + '\'' +
                ", cliente=" + cliente +
                ", empleado=" + empleado +
                ", paquete=" + paquete +
                '}';
    }
}
