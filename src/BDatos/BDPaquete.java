package BDatos;

import Clases.Estado;
import Clases.Paquete;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDPaquete {
    Conexiones BLcon = new Conexiones();
    public void InsertarPaquete(Paquete objPaquete)
            throws SQLException, ClassNotFoundException{
        String Sentencia = "Insert into Paquete (codigo, descripcion, peso, alto, ancho)"+
                "values (?,?,?,?,?)";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        ps.setString(1, objPaquete.getCodigo());
        ps.setString(2,objPaquete.getDescripcion());
        ps.setDouble(3,objPaquete.getPeso());
        ps.setDouble(4,objPaquete.getAlto());
        ps.setDouble(5,objPaquete.getAncho());
    }

    public ResultSet RecuperarPaquete(Paquete objPaquete) throws ClassNotFoundException, SQLException{
        String Sentencia = "SELECT * FROM Clientes where codigo = ?";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        ps.setString(1, objPaquete.getCodigo());
        return ps.executeQuery();
    }

    public void ActualizarPaquete(Estado objEstado) throws ClassNotFoundException, SQLException{
        String Sentencia = "UPDATE Estado set Estado = ?" +
                "where idEst = ?";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        ps.setString(1, objEstado.getEstado());
    }
}
