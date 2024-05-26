package Logica;

import BDatos.BDCliente;
import BDatos.BDPaquete;
import Clases.Estado;
import Clases.Paquete;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
public class LPaquete {
    static BDCliente objBDCliente = new BDCliente();
    static BDPaquete objBDPaquete = new BDPaquete();
    static Random random = new Random();
    public static String crearCodigo (Estado estado){
        return String.format("%02d%d%02d%d%02d%d",
                estado.getFecha().getDayOfYear(), random.nextInt(10),
                estado.getFecha().getMonth(), random.nextInt(10),
                estado.getFecha().getYear(), random.nextInt(10));
    }

    public void BuscarPaquete(Paquete objPaquete) throws ClassNotFoundException, SQLException {
        ResultSet rs = objBDPaquete.RecuperarPaquete(objPaquete);
        while (rs.next()){
            objPaquete.setIdpaq(rs.getString(1));
            objPaquete.setPeso(rs.getDouble(2));
            objPaquete.setAncho(rs.getDouble(3));
            objPaquete.setAlto(rs.getDouble(4));
            objPaquete.setDescripcion(rs.getString(5));
        }
        rs.close();
    }

    public void ActualizarEstadoPaquete(Paquete objPaquete)  throws ClassNotFoundException, SQLException{
        objBDPaquete.ActualizarPaquete(objPaquete.getEstado());
    }

    public void ingresarPaquete(Paquete objPaquete) throws SQLException, ClassNotFoundException {
        objBDPaquete.InsertarPaquete(objPaquete);
    }
}
