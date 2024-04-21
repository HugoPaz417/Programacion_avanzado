package clase2.BDatos;

import clase2.Clases.Cliente;
import clase2.Clases.Direcciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDCliente {
    Conexiones BLcon = new Conexiones();
    Cliente objCliente = new Cliente();
    Direcciones objDirecciones = new Direcciones();

    public int InsertarCliente(Cliente objCliente) throws SQLException, ClassNotFoundException {
        String Sentencia = "Insert into Clientes (Cedula, Nombres, Apellidos)" +
                "values (?,?,?)";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        ps.setString(1, objCliente.getCedula());
        ps.setString(2, objCliente.getNombres());
        ps.setString(3, objCliente.getApellidos());
        return ps.executeUpdate(); //1 si se inserta -- 0 si no inserta
    }

    public ResultSet RecuperarCliente(Cliente objCliente) throws ClassNotFoundException, SQLException {
        String Sentencia = "SELECT * FROM Clientes where cedula = ?";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        ps.setString(1, objCliente.getCedula());
        return ps.executeQuery();
    }

    public int ActualizarCliente(Cliente objCLiente)
            throws ClassNotFoundException, SQLException {
        String Sentencia = "UPDATE Clientes set Nombres = ?, Apellidos = ?" +
                "where cedula = ?";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        ps.setString(3, objCliente.getCedula());
        ps.setString(1, objCliente.getNombres());
        ps.setString(2, objCliente.getApellidos());
        return ps.executeUpdate(); //1 si se inserta -- 0 si no inserta
    }

    public ResultSet RecuperarTodosClientes(Cliente objCliente) throws SQLException, ClassNotFoundException {
        String Sentencia = "SELECT * FROM Clientes";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        return ps.executeQuery();
    }

    public int InsertarDireccion(Cliente objCliente) throws SQLException, ClassNotFoundException {
        String Sentencia = "Insert into Direcciones (IdDir, Calle1, Calle2, IdClie)" +
                "values (0,?,?,?)";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        ps.setString(1, objCliente.getDirecciones().getCalle1());
        ps.setString(2, objCliente.getDirecciones().getCalle2());
        ps.setInt(3, objCliente.getIdClie());
        return ps.executeUpdate(); //1 si se inserta -- 0 si no inserta    }
    }
}