package BDatos;

import Clases.Cliente;
import Clases.Direccion;
import Clases.Persona;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDCliente {
    Persona objPersona = new Persona();
    Conexiones BLcon = new Conexiones();
    public int InsertarPersona(Persona objPersona) throws SQLException, ClassNotFoundException {
        String Sentencia = "INSERT INTO Personas (Cedula, Nombres, Apellidos, email) VALUES (?,?,?,?)";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        ps.setString(1, objPersona.getCedula());
        ps.setString(2, objPersona.getNombres());
        ps.setString(3, objPersona.getApellidos());
        ps.setString(4, objPersona.getMail());
        return ps.executeUpdate(); // 1 si se inserta, 0 si no se inserta
    }
    public int InsertarCliente(Cliente objCliente) throws SQLException, ClassNotFoundException {
        // Primero insertamos la Persona
        int result = InsertarPersona(objPersona);
        if (result == 1) {
            String Sentencia = "INSERT INTO Clientes (Cedula, Celular, Direccion) VALUES (?,?,?)";
            PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
            ps.setString(1, objCliente.getCedula());
            ps.setString(2, objCliente.getCelular());
            ps.setString(3, objCliente.getDireccion().toString()); // Modifica según cómo almacenes la dirección
            return ps.executeUpdate(); // 1 si se inserta, 0 si no se inserta
        } else {
            return 0; // No se insertó la Persona
        }
    }
    public ResultSet RecuperarCliente(Cliente objCliente) throws ClassNotFoundException, SQLException {
        String Sentencia = "SELECT * FROM cliente where cedula = ?";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        ps.setString(1, objCliente.getCedula());
        return ps.executeQuery();
    }
    public int ActualizarCliente(Cliente objCliente) throws ClassNotFoundException, SQLException {
        String Sentencia = "UPDATE cliente SET mail = ? WHERE cedula = ?";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        ps.setString(1, objCliente.getMail());
        ps.setString(2, objCliente.getCedula());
        return ps.executeUpdate();
    }

    public int EliminarCliente(Cliente objCliente) throws SQLException, ClassNotFoundException {
        String Sentencia = "DELETE FROM cliente WHERE Cedula = ?";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        ps.setString(1, objCliente.getCedula());
        return ps.executeUpdate();
    }
    public int ActualizarDireccion(Direccion objDireccion) throws ClassNotFoundException, SQLException {
        String Sentencia = "UPDATE direccion SET calle1 = ?, calle2 = ?, referencia = ? WHERE codigo = ?";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        ps.setString(1, objDireccion.getCalle1());
        ps.setString(2, objDireccion.getCalle2());
        ps.setString(3, objDireccion.getReferencia());
        ps.setString(4, objDireccion.getCodigo()); // Usamos el código de la dirección
        return ps.executeUpdate();
    }
}