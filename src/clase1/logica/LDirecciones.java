package clase1.logica;

import clase1.clases.Cliente;

public class LDirecciones {
    public static boolean validarCalles(Cliente objCliente) {
        if (objCliente.getDirecciones().getCalle1().equals(objCliente.getDirecciones().getCalle2())) {
            return false;
        }
     return true;
    }
}
