package tarea1.presentacion;

import tarea1.clases.Cliente;
import tarea1.clases.DireccionEntrega;
import tarea1.clases.Estado;
import tarea1.clases.Paquete;
import tarea1.logica.LCliente;
import tarea1.logica.LDirecciones;
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
    public static LDirecciones objLDirecciones = new LDirecciones();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Aux;
        String contrasenia = "1234";
        Boolean Aux3 = false;
        System.out.println("Bienvenido");
        while (Aux3 == false) {
            System.out.println("Seleccione una de las opciones:");
            System.out.println("1. Crear paquete");
            System.out.println("2. Ver estado de paquete");
            System.out.println("3. Crear cuenta");
            System.out.println("4. Salir");
            System.out.println("5. Actualizar estado de paquete (empleado)");
            switch (scanner.nextInt()) {
                case 1: {
                    scanner.nextLine();
                    System.out.println("Introduzca su numero de cedula para continuar:");
                    if (objCliente.getCedula() == null) {
                        System.out.println("Por favor, cree una cuenta primero.");
                        break;
                    }
                    System.out.println("Ingresar datos de paquete:");
                    System.out.println("Peso:");
                    objPaquete.setPeso(scanner.nextDouble());
                    scanner.nextLine(); // Limpiar el buffer después de nextDouble()
                    System.out.println("Largo:");
                    objPaquete.setLargo(scanner.nextDouble());
                    scanner.nextLine(); // Limpiar el buffer después de nextDouble()
                    System.out.println("Ancho:");
                    objPaquete.setAncho(scanner.nextDouble());
                    scanner.nextLine(); // Limpiar el buffer después de nextDouble()
                    System.out.println("Ingrese una pequeña descripción de lo que es el paquete:");
                    objPaquete.setDescripcion(scanner.nextLine());
                    objEstado.setFecha(LocalDate.now());
                    System.out.println("¿Desea usar las direcciones registradas?");
                    System.out.println("S/N");
                    Aux = scanner.next(); // Cambiado de Aux a String
                    if (Aux.toUpperCase().equals("S")) {
                        System.out.println("Las direcciones serán:");
                        System.out.println("Calle 1: " + objDireccionEntrega.getCalle1());
                        System.out.println("Calle 2: " + objDireccionEntrega.getCalle2());
                        System.out.println("Referencia: " + objDireccionEntrega.getReferencia());
                    } else {
                        System.out.println("Ingrese sus direcciones:");
                        System.out.println("Calle 1:");
                        scanner.nextLine(); // Limpiar el buffer antes de leer la próxima línea
                        objDireccionEntrega.setCalle1(scanner.nextLine());
                        System.out.println("Calle 2:");
                        objDireccionEntrega.setCalle2(scanner.nextLine());
                        System.out.println("Referencia:");
                        objDireccionEntrega.setReferencia(scanner.nextLine());
                        if (objLDirecciones.validarCalles(objDireccionEntrega)) {
                            System.out.println("Direcciones correctas");
                        } else {
                            // Manejar el caso donde la dirección no es válida
                        }
                    }
                    System.out.println(objEstado.getFecha());
                    objPaquete.setCodigo(objLPaquete.crearCodigo(objEstado));
                    System.out.println("Paquete creado");
                    System.out.println("Datos ingresados, tu codigo de paquete es:");
                    System.out.println(objPaquete.getCodigo());
                    objEstado.setEstado("Creado");
                    System.out.println("¿Desea realizar otra accion? Pulse S");
                    Aux = scanner.next();
                    if (!Aux.toUpperCase().equals("S"))
                        Aux3 = true;
                    break;
                }

                case 2: {
                    scanner.nextLine();
                    System.out.println("Introduzca el codigo de su paquete:");
                    Aux = scanner.nextLine();
                    if (Aux.equals(objPaquete.getCodigo())) {
                        System.out.println("Fecha de creacion:");
                        System.out.println(objEstado.getFecha());
                        System.out.println("Estado:");
                        System.out.println(objEstado.getEstado());
                        System.out.println("¿Desea realizar otra accion? Pulse S");
                        Aux = scanner.next();
                        if (!Aux.toUpperCase().equals("S"))
                            Aux3 = true;
                        break;
                    }
                    else
                        System.out.println("Codigo incorrecto");
                }

                case 3: {
                    scanner.nextLine();
                    System.out.println("Introducir los siguientes datos:");
                    System.out.println("Ingrese SOLO nombres");
                    objCliente.setNombres(scanner.nextLine());
                    System.out.println("Ingrese SOLO Apellidos");
                    objCliente.setApellidos(scanner.nextLine());
                    while (!Aux3) {
                        System.out.println("Cedula:");
                        objCliente.setCedula(scanner.nextLine());
                        if (LCliente.validarCedula(objCliente)) {
                            System.out.println("Cedula agregada correctamente.");
                            Aux3 = true;
                        } else
                            Aux3 = false;
                    }
                    while(!Aux3) {
                        System.out.println("Ingrese su correo electronico");
                        objCliente.getEmail().add(scanner.nextLine());
                        if (objLCliente.correoValido(objCliente)) {
                            System.out.println("Correo agregado correctamente");
                            Aux3 = true;
                        } else {
                            System.out.println("Correo no valido");
                            objCliente.getEmail().remove(objCliente.getEmail().size() - 1);
                        }
                    }
                    System.out.println("¿Desea realizar otra accion? Pulse S");
                    Aux = scanner.next();
                    if (!Aux.toUpperCase().equals("S"))
                        Aux3 = true;
                    break;
                }

                case 4: {
                    Aux3 = true;
                    break;
                }
                case 5:
                {
                    scanner.nextLine(); //Limpiar buffer
                    System.out.println("Ingrese la contraseña");
                    Aux = scanner.nextLine();
                    if (Aux == contrasenia){
                        System.out.println("Ingrese el codigo de paquete para actualizar el estado:");
                        Aux = scanner.nextLine();
                        if (objPaquete.getCodigo().equals(Aux)){
                            System.out.println("Escriba el estado actual del paquete:");
                            System.out.println("Despachado");
                            System.out.println("Entregado");
                            Aux = scanner.nextLine();
                            if (Aux.toUpperCase().equals("Despachado") || Aux.toUpperCase().equals("Entregado")){
                                objEstado.setEstado(Aux);
                            }
                        }
                    }
                    else
                        System.out.println("Contraseña incorrecta");

                    System.out.println("¿Desea realizar otra accion? Pulse S");
                    Aux = scanner.next();
                    if (!Aux.toUpperCase().equals("S"))
                        Aux3 = true;
                    break;
                }
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }
}