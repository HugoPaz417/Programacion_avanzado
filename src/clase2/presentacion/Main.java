package clase2.presentacion;

import clase2.Clases.Cliente;
import clase2.Clases.Direcciones;
import clase2.Logica.LCliente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Cliente objCliente = new Cliente();
    static LCliente objLCliente = new LCliente();
    static Scanner aux = new Scanner(System.in);
    static Direcciones objDirecciones = new Direcciones();
    static ArrayList <Cliente> ArrayClientes = new ArrayList<Cliente>();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        String aux;
        do {
            System.out.println("Ingresar Cliente <1>");
            System.out.println("Buscar un cliente <2>");
            System.out.println("Actualizar un cliente <3>");
            System.out.println("Listar clientes <4>");
            System.out.println("Agregar direccion <5>");
            System.out.println("Salir            <6>");
            aux = sc.nextLine();
            op = Integer.parseInt(aux);
            switch (op){
                case 1:
                    IngresarCliente();
                    break;
                case 2:
                    BuscarCliente();
                    break;
                case 3:
                    ActualizarCliente();
                    break;
                case 4:
                    ListarCLientes();
                    break;
                case 5:
                    AgregarDireccion();
                    break;
                default:
                    throw new AssertionError();

            }
        } while (op != 6);
    }
    private static void IngresarCliente() throws ClassNotFoundException, SQLException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese cedula");
        String Aux = entrada.nextLine();
        objCliente.setCedula(Aux);
        System.out.println("ingrese nombres");
        Aux = entrada.nextLine();
        objCliente.setNombres(Aux);
        System.out.println("ingres apellidos");
        Aux = entrada.nextLine();
        objCliente.setApellidos(Aux);
        objLCliente.ingresarCliente(objCliente);
    }

    private static void ActualizarCliente()
            throws ClassNotFoundException, SQLException{
        Scanner entrada = new Scanner(System.in);
        Cliente objCliente = new Cliente();
        LCliente objLCliente = new LCliente();
        String Aux;
        BuscarCliente();
        System.out.println("Ingrese los nuevos datos");
        System.out.println("ingrese nombres");
        Aux = entrada.nextLine();
        objCliente.setNombres(Aux);
        System.out.println("ingres apellidos");
        Aux = entrada.nextLine();
        objCliente.setApellidos(Aux);
        objLCliente.AcualizarUsuario(objCliente);

    }
    private static void BuscarCliente()
        throws ClassNotFoundException, SQLException{
        Cliente objCliente = new Cliente();
        LCliente objLCliente = new LCliente();
        System.out.println("Ingrese la cedula");
        String campo = aux.nextLine();
        objCliente.setCedula(campo);
        objLCliente.BuscarCliente(objCliente);
        if (objCliente.getIdClie() != 0)
            System.out.println(objCliente.toString());
        else
            System.out.println("No existe un cliente con esa cedula");
    }

    private static void ListarCLientes() throws SQLException, ClassNotFoundException {
        objLCliente = new LCliente();
        objLCliente.ListarClientes(ArrayClientes);
        for (Cliente objCLAux : ArrayClientes){
            System.out.println(objCLAux.toString());
        }
    }
    private static void AgregarDireccion()
        throws SQLException, ClassNotFoundException{
        Cliente objCLiente = new Cliente();
        LCliente objLCliente = new LCliente();
        Direcciones objDirecciones = new Direcciones();
        BuscarCliente();
        String Aux;
        System.out.println("Ingrese la direccion");
        System.out.println("Ingrese la calle 1");
        Aux = aux.nextLine();
        objDirecciones.setCalle1(Aux);
        System.out.println("Ingrese la calle 2");
        Aux = aux.nextLine();
        objDirecciones.setCalle2(Aux);
        objCLiente.setDirecciones(objDirecciones);
        objLCliente.IngresarDireccion(objCLiente);
    }
}