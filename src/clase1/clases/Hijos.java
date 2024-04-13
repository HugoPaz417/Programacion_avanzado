package clase1.clases;

public class Hijos {
    String nombre;
    int edad;

    public Hijos() {
    }

    public Hijos(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Hijos{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
