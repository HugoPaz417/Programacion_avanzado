package tarea1.logica;

import tarea1.clases.Estado;
import java.util.Random;

public class LPaquete {
    static Random random = new Random();
    public static String crearCodigo (Estado estado){
        return String.format("%02d%d%02d%d%02d%d",
                estado.getFecha().getDayOfMonth(), random.nextInt(10),
                estado.getFecha().getMonthValue(), random.nextInt(10),
                estado.getFecha().getYear(), random.nextInt(10));
    }
}
