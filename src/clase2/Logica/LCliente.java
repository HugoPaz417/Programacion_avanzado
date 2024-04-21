package clase2.Logica;

import clase2.BDatos.BDCliente;
import clase2.Clases.Cliente;
import clase2.Clases.Direcciones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LCliente {
    public static Cliente objCliente = new Cliente();
    static BDCliente objBDCliente = new BDCliente();
    public void ingresarCliente (Cliente objCliente) throws SQLException, ClassNotFoundException {
        objBDCliente.InsertarCliente(objCliente);
    }
    public static void BuscarCliente(Cliente objCliente) throws ClassNotFoundException, SQLException {
        ResultSet rs = objBDCliente.RecuperarCliente(objCliente);
        while (rs.next()){
            objCliente.setIdClie(rs.getInt(1));
            objCliente.setNombres(rs.getString(3));
            objCliente.setApellidos(rs.getString(4));
        }
        rs.close();
    }
    public static void AcualizarUsuario(Cliente objCliente)
        throws ClassNotFoundException, SQLException{
        objBDCliente.ActualizarCliente(objCliente);
    }

    public void ListarClientes(ArrayList<Cliente> ArrayClientes)
            throws ClassNotFoundException, SQLException {
        ResultSet rs = objBDCliente.RecuperarTodosClientes(objCliente);
        while (rs.next()){
            objCliente = new Cliente();
            objCliente.setIdClie(rs.getInt(1));
            objCliente.setCedula(rs.getString(2));
            objCliente.setNombres(rs.getString(3));
            objCliente.setApellidos(rs.getString(4));
        }
        rs.close();
    }

    public void IngresarDireccion(Cliente objCliente)
        throws ClassNotFoundException, SQLException {
        objBDCliente.InsertarDireccion(objCliente);

    }
}
