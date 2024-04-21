package clase2.Clases;

public class Direcciones {
    int idDir;
    String Calle1;
    String Calle2;

    public Direcciones() {
    }

    public Direcciones(int idDir, String calle1, String calle2) {
        this.idDir = idDir;
        Calle1 = calle1;
        Calle2 = calle2;
    }

    public int getIdDir() {
        return idDir;
    }

    public void setIdDir(int idDir) {
        this.idDir = idDir;
    }

    public String getCalle1() {
        return Calle1;
    }

    public void setCalle1(String calle1) {
        Calle1 = calle1;
    }

    public String getCalle2() {
        return Calle2;
    }

    public void setCalle2(String calle2) {
        Calle2 = calle2;
    }

    @Override
    public String toString() {
        return "Direcciones{" +
                "IdDir=" + idDir +
                ", Calle1='" + Calle1 + '\'' +
                ", Calle2='" + Calle2 + '\'' +
                '}';
    }
}
