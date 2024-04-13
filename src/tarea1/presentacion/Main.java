package tarea1.presentacion;

import tarea1.clases.Cliente;
import tarea1.clases.DireccionEntrega;
import tarea1.clases.Estado;
import tarea1.clases.Paquete;
import tarea1.logica.LCliente;
import tarea1.logica.LPaquete;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static Cliente objCliente = new Cliente();
    public static DireccionEntrega objDireccionEntrega = new DireccionEntrega();
    public static Estado objEstado = new Estado();
    public static Paquete objPaquete = new Paquete();
    public static LPaquete objLPaquete = new LPaquete();
    public static LCliente objLCliente = new LCliente();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Aux;
        double Aux2;
        Boolean Aux3 = false;
        System.out.println("Bienvenido");
        while (Aux3==false) {
            System.out.println("Seleccione una de las opciones:");
            System.out.println("1. Crear paquete");
            System.out.println("2. Ver estado de paquete");
            System.out.println("3. Crear cuenta");
            System.out.println("4. Salir");
            switch (scanner.nextInt()) {
                case 1:
                {
                    scanner.nextLine();
                    System.out.println("Introduzca su numero de cedula para continuar:");
                    System.out.println("Ingresar datos de paquete:"); //Solicita datos y los inserta directamente
                    System.out.println("Peso:");
                    objPaquete.setPeso(scanner.nextDouble());
                    System.out.println("Largo:");
                    objPaquete.setLargo(scanner.nextDouble());
                    System.out.println("Ancho:");
                    objPaquete.setAncho(scanner.nextDouble());
                    scanner.nextLine(); //Limpiar buffer
                    System.out.println("Ingrese una pequeña descripción de lo que es el paquete:");
                    objPaquete.setDescripcion(scanner.nextLine());
                    objEstado.setFecha(LocalDate.now());
                    System.out.println(objEstado.getFecha());
                    objPaquete.setCodigo(objLPaquete.crearCodigo(objEstado)); //Crea y muestra el codigo del paquete
                    System.out.println("Paquete creado");
                    System.out.println("Datos ingresados, tu codigo de paquete es:");
                    System.out.println(objPaquete.getCodigo());
                    System.out.println("¿Desea realizar otra accion? Pulse S");
                    if (!scanner.nextLine().toUpperCase().equals("S"))
                        Aux3= true;
                        break;
                }
                case 2:
                {
                    scanner.nextLine();
                    System.out.println("Introduzca el codigo de su paquete:");
                    Aux = scanner.nextLine();


                    System.out.println("¿Desea realizar otra accion? Pulse S");
                    if (!scanner.nextLine().toUpperCase().equals("S"))
                        Aux3= true;

                    break;
                }
                case 3:
                {
                    scanner.nextLine();
                    System.out.println("Introducir los siguientes datos:");
                    while (!Aux3){
                        System.out.println("Cedula:");
                        Aux = scanner.next();
                        objCliente.setCedula(Aux);
                        if (LCliente.validarCedula(objCliente)){
                            System.out.println("Cedula agregada correctamente.");
                            Aux3 = true;
                        }
                        else {
                            System.out.println("La cedula ingresada no es válida");
                            Aux3 = false;
                        }
                    }
                    System.out.println("SOLO nombres:");
                    objCliente.setNombres(scanner.nextLine());
                    System.out.println("SOLO apellidos:");
                    objCliente.setApellidos(scanner.nextLine());
                    while (Aux3==false) {
                        System.out.println("Email:");
                        Aux = scanner.nextLine();
                        if (LCliente.correoValido(objCliente)) {
                            objCliente.getEmail().add(Aux);
                            System.out.println("Correo agregado correctamente.");
                            Aux3 = true;
                        } else {
                            System.out.println("El correo ingresado no es válido o ya está registrado. Por favor, ingresa uno diferente.");
                            Aux3 = false;
                        }

                    }
                    System.out.println("¿Desea realizar otra accion? Pulse S");
                    if (!scanner.nextLine().toUpperCase().equals("S"))
                        Aux3= true;
                    break;

                }
                case 4:
                    Aux3= true;
                    break;
            }
        }
    }
}
