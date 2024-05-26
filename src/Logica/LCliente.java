package Logica;

import BDatos.BDPaquete;
import Clases.Cliente;
import BDatos.BDCliente;
import Clases.Persona;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class LCliente {
    static BDCliente objBDCliente = new BDCliente();

    public void ingresarCliente(Cliente objCliente) throws SQLException, ClassNotFoundException {
        objBDCliente.InsertarCliente(objCliente);
    }
    public static void ActualizarCliente(Cliente objCliente) throws SQLException, ClassNotFoundException{
        objBDCliente.ActualizarCliente(objCliente);
    }
    public static void ActualizarDireccion(Cliente objCliente) throws SQLException, ClassNotFoundException{
        objBDCliente.ActualizarDireccion(objCliente.getDireccion());
    }
    public static void BuscarCliente(Cliente objCliente) throws ClassNotFoundException, SQLException {
        ResultSet rs = objBDCliente.RecuperarCliente(objCliente);
        while (rs.next()){
            objCliente.setCedula(rs.getString(1));
            objCliente.setNombres(rs.getString(3));
            objCliente.setApellidos(rs.getString(4));
        }
        rs.close();
    }
    public static void EliminarCliente(Cliente objCliente) throws ClassNotFoundException, SQLException{
        objBDCliente.EliminarCliente(objCliente);
    }
    public static boolean validarCalles(Cliente objCliente) {
        if (objCliente.getDireccion().getCalle1().equals(objCliente.getDireccion().getCalle2())) {
            return false;
        }
        return true;
    }
    public static boolean validarCelular(Cliente objCliente) {
        Pattern pattern = Pattern.compile("[0-9]{10}");
        return pattern.matcher(objCliente.getCedula()).matches();
    }
}
