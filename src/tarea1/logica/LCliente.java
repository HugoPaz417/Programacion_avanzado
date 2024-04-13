package tarea1.logica;

import tarea1.clases.Cliente;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LCliente {
    public static boolean validarCedula(Cliente objCliente) {
        // Compila la expresión regular en un patrón
        Pattern pattern = Pattern.compile("[0-9]{10}");

        // Usa el patrón para verificar si el String coincide con la expresión regular
        return pattern.matcher(objCliente.getCedula()).matches();
    }

    public static boolean correoValido(Cliente objCliente) {
        Set<String> correosUnicos = new HashSet<>(objCliente.getEmail());
        if (correosUnicos.size() != objCliente.getEmail().size()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        for (String correo : objCliente.getEmail()) {
            Matcher matcher = pattern.matcher(correo);
            if (!matcher.matches()) {
                return false;
            }
        }
        return true;
    }
}