package tarea1.logica;

import tarea1.clases.DireccionEntrega;

public class LDirecciones {
    public static boolean validarCalles(DireccionEntrega objDireccionEntrega) {
        if (objDireccionEntrega.getCalle1().equals(objDireccionEntrega.getCalle2())) {
            return false;
        }
        return true;
    }
}