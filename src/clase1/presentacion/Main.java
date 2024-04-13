package clase1.presentacion;

import clase1.logica.LCliente;
import clase1.logica.LDirecciones;
import clase1.clases.Cliente;
import clase1.clases.Direcciones;
import clase1.clases.Hijos;

import java.util.Scanner;

public class Main {
    public static Cliente objCliente = new Cliente();
    public static LCliente objLCliente = new LCliente();
    public static Direcciones objDirecciones = new Direcciones();
    public static LDirecciones objLDirecciones = new LDirecciones();
    public static Hijos objHijos = new Hijos();

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese cedula");
        String Aux = entrada.nextLine();
        objCliente.setCedula(Aux);
        //objCliente.getDirecciones().setCalle1(Aux);
        System.out.println("ingrese nombres");
        Aux = entrada.nextLine();
        objCliente.setNombre(Aux);
        System.out.println("ingres apellidos");
        Aux = entrada.nextLine();
        objCliente.setApellido(Aux);
        if (objLCliente.validarCedula(objCliente)) {
            System.out.println("Ingrese calle 1");
            Aux = entrada.nextLine();
            objDirecciones.setCalle1(Aux);
            System.out.println("Ingrese calle 2");
            Aux = entrada.nextLine();
            objDirecciones.setCalle2(Aux);
            objCliente.setDirecciones(objDirecciones);
            if(objLDirecciones.validarCalles(objCliente)){
                System.out.println("Cuantos hijos quiere ingresar");
                Aux = entrada.nextLine();
                int nHijos = Integer.parseInt(Aux);
                for (int i = 0; i < nHijos; i++) {
                    objHijos = new Hijos();
                    System.out.println("Ingrese nombre del hijo:");
                    Aux = entrada.nextLine();
                    objHijos.setNombre(Aux);
                    System.out.println("Ingrese edad del hijo:");
                    Aux = entrada.nextLine();
                    objHijos.setEdad(Integer.parseInt(Aux));
                    objCliente.getHijos().add(objHijos);
                }
                System.out.println(objCliente.toString());
                System.out.println(objDirecciones.toString());
            }
        }
        else
            System.out.println("error en la cedula");
    }


}