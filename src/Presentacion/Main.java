package Presentacion;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import Clases.*;
import Logica.LCliente;
import Logica.LPaquete;
import Logica.LPersona;
public class Main {
    public static Persona objPersona = new Persona();
    public static LPersona objLPersona = new LPersona();
    public static Cliente objCliente = new Cliente();
    public static Estado objEstado = new Estado();
    public static Paquete objPaquete = new Paquete();
    public static LPaquete objLPaquete = new LPaquete();
    public static LCliente objLCliente = new LCliente();
    static int auxInt;
    static String Aux;
    static boolean auxBoolean;
    static Scanner sc = new Scanner(System.in);
    static String contrasenia = "1234";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Bienvenido");
        while (!auxBoolean){
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear cuenta (cliente nuevo)");
            System.out.println("2. Actualizar correo de cuenta");
            System.out.println("3. Eliminar cuenta");
            System.out.println("4. Crear un paquete");
            System.out.println("5. Verificar estado de un paquete"); //Hacer xd
            System.out.println("6. Verificar multiples estados de paquetes"); //Hacer xd
            System.out.println("7. Salir");
            System.out.println("8. Actualizar estado de paquete (Repartidor)");
            switch (auxInt = sc.nextInt()){
                case 1:
                    IngresarCliente();
                    break;
                case 2:
                    actualizarCliente();
                    break;
                case 3:
                    eliminarCliente();
                    break;
                case 4:
                    ingresarPaquete();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    auxBoolean = true;
                    break;
                case 8:
                    cambiarEstadoPaquete();
                    break;
            }
        }
    }
    //Cliente
    private static void buscarCliente() throws ClassNotFoundException, SQLException{
        Cliente objCliente = new Cliente();
        LCliente objLCliente = new LCliente();
        sc.nextLine();
        System.out.println("Ingrese la cedula");
        String campo = sc.nextLine();
        objCliente.setCedula(campo);
        LCliente.BuscarCliente(objCliente);
        if (objCliente.getIdClie() != 0) {
            System.out.println(objCliente);
            auxBoolean = true;
        }else
            System.out.println("No existe un cliente con esa cedula");
    }
    private static void IngresarCliente() throws ClassNotFoundException, SQLException {
        Cliente objCliente = new Cliente();
        LCliente objLCliente = new LCliente();
        LPersona objLPersona = new LPersona(); // Asumiendo que tienes esta clase para las validaciones
        boolean auxBoolean = false;

        System.out.println("Introducir los siguientes datos:");
        sc.nextLine(); // Consume the leftover newline

        System.out.println("Ingrese SOLO nombres");
        objCliente.setNombres(sc.nextLine());

        System.out.println("Ingrese SOLO Apellidos");
        objCliente.setApellidos(sc.nextLine());

        // Validar la cédula
        while (!auxBoolean) {
            System.out.println("Cedula:");
            objCliente.setCedula(sc.nextLine());
            if (LPersona.validarCedula(objCliente)) {
                System.out.println("Cedula agregada correctamente.");
                auxBoolean = true;
            } else {
                System.out.println("Cedula no valida");
            }
        }

        // Validar el correo electrónico
        auxBoolean = true; // Reiniciar para la validación del correo
        while (auxBoolean) {
            System.out.println("Ingrese su correo electronico");
            objCliente.setMail(sc.nextLine());
            if (objLPersona.validarCorreo(objCliente)) {
                System.out.println("Correo agregado correctamente");
                auxBoolean = false;
            } else {
                System.out.println("Correo no valido");
            }
        }
        while (!auxBoolean){
            // Ingresar el celular
            System.out.println("Ingrese su celular, debe tener 10 números");
            objCliente.setCelular(sc.nextLine());
            if (LCliente.validarCelular(objCliente)){
                System.out.println("Número de celular agregado correctamente");
                auxBoolean = true;
            }
        }
        // Validar y capturar la dirección
        while (auxBoolean) {
            System.out.println("Ingrese sus direcciones:");
            System.out.println("Calle 1:");
            sc.nextLine(); // Limpiar el buffer antes de leer la próxima línea
            objCliente.getDireccion().setCalle1(sc.nextLine());
            System.out.println("Calle 2:");
            objCliente.getDireccion().setCalle2(sc.nextLine());
            System.out.println("Referencia:");
            objCliente.getDireccion().setReferencia(sc.nextLine());
            if (LCliente.validarCalles(objCliente)) {
                System.out.println("Direcciones correctas");
                auxBoolean = false;
            } else
                System.out.println("Las calles deben ser distintas, ingrese de nuevo los datos");
        }

        // Insertar el cliente en la base de datos
        objLCliente.ingresarCliente(objCliente);
        System.out.println("Cliente ingresado correctamente.");
    }
    private static void actualizarCliente() throws SQLException, ClassNotFoundException {
        while (auxBoolean) {
            System.out.println("Ingrese su correo electronico");
            objCliente.setMail(sc.nextLine());
            if (objLPersona.validarCorreo(objCliente)) {
                LCliente.ActualizarCliente(objCliente);
                System.out.println("Correo agregado correctamente");
                auxBoolean = false;
            } else {
                System.out.println("Correo no valido");
            }
        }
    }
    private static void eliminarCliente() {
        System.out.println("Ingrese la cedula");
        String cedula = sc.nextLine();

        try {
            objCliente.setCedula(cedula);
            LCliente.BuscarCliente(objCliente);

            if (objCliente.getIdClie() != 0) {
                System.out.println(objCliente.toString());
                auxBoolean = true;
                LCliente.EliminarCliente(objCliente);
                System.out.println("Cliente eliminado correctamente.");
            } else {
                System.out.println("No existe un cliente con esa cedula.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al eliminar el cliente: " + e.getMessage());
        }
    }
    //Paquete
    private static void ingresarPaquete() throws SQLException, ClassNotFoundException {
        buscarCliente();
        if (auxBoolean) {
            System.out.println("Ingresar datos de paquete:");
            System.out.println("Peso:");
            objPaquete.setPeso(sc.nextDouble());
            sc.nextLine(); // Limpiar el buffer después de nextDouble()
            System.out.println("Alto:");
            objPaquete.setAlto(sc.nextDouble());
            sc.nextLine(); // Limpiar el buffer después de nextDouble()
            System.out.println("Ancho:");
            objPaquete.setAncho(sc.nextDouble());
            sc.nextLine(); // Limpiar el buffer después de nextDouble()
            System.out.println("Ingrese una pequeña descripción de lo que es el paquete:");
            objPaquete.setDescripcion(sc.nextLine());
            objEstado.setFecha(LocalDate.now());
            System.out.println("¿Desea usar las direcciones registradas?");
            System.out.println("S/N");
            Aux = sc.next();
            if (Aux.equalsIgnoreCase("S")) {
                System.out.println("Las direcciones serán:");
                System.out.println("Calle 1: " + objCliente.getDireccion().getCalle1());
                System.out.println("Calle 2: " + objCliente.getDireccion().getCalle2());
                System.out.println("Referencia: " + objCliente.getDireccion().getReferencia());
            } else {
                while (!LCliente.validarCalles(objCliente)) {
                    System.out.println("Ingrese sus direcciones:");
                    System.out.println("Calle 1:");
                    sc.nextLine(); // Limpiar el buffer antes de leer la próxima línea
                    objCliente.getDireccion().setCalle1(sc.nextLine());
                    System.out.println("Calle 2:");
                    objCliente.getDireccion().setCalle2(sc.nextLine());
                    System.out.println("Referencia:");
                    objCliente.getDireccion().setReferencia(sc.nextLine());
                    if (LCliente.validarCalles(objCliente)) {
                        System.out.println("Direcciones correctas");
                    } else {
                        System.out.println("Las calles deben ser distintas, ingrese de nuevo los datos");
                    }
                }
            }
            System.out.println(objEstado.getFecha());
            objPaquete.setCodigo(LPaquete.crearCodigo(objEstado));
            System.out.println("Paquete creado");
            System.out.println("Datos ingresados, tu codigo de paquete es:");
            System.out.println(objPaquete.getCodigo());
            objEstado.setEstado("Creado");
            objLPaquete.ingresarPaquete(objPaquete);
            auxBoolean = false;
        }
        else
            System.out.println("Cedula no registrada, primero crear una cuenta");
    }
    private static void verEstadoPaquete() throws ClassNotFoundException, SQLException {
        LCliente objLCliente = new LCliente();
        Cliente objCliente = new Cliente();
        Paquete objPaquete = new Paquete();
        System.out.println("Ingrese el codigo del paquete");
        objPaquete.setCodigo(sc.nextLine());
        objLPaquete.BuscarPaquete(objPaquete);
        if (objPaquete.getIdpaq() != null) {
            System.out.println(objPaquete);
        } else
            System.out.println("Paquete no encontrado");
    }
    private static void cambiarEstadoPaquete() throws ClassNotFoundException, SQLException {
        sc.nextLine(); //Limpiar buffer
        System.out.println("Ingrese la contraseña");
        if (sc.nextLine().equals(contrasenia)) {
            verEstadoPaquete();
            System.out.println("Ingrese el estado acutual");
            System.out.println("Despachado");
            System.out.println("Entregado");
            Aux = sc.nextLine();
            if (Aux.toUpperCase().equals("Despachado") || Aux.toUpperCase().equals("Entregado")) {
                objEstado.setEstado(Aux);
                objLPaquete.ActualizarEstadoPaquete(objPaquete);
            }
        }
    }
}