package clase1.logica;

import clase1.clases.Cliente;

import java.util.regex.Pattern;

public class LCliente {
    public static boolean validarCedula(Cliente objCliente) {
        String regex = "[0-9]{10}";

        // Compila la expresión regular en un patrón
        Pattern pattern = Pattern.compile(regex);

        // Usa el patrón para verificar si el String coincide con la expresión regular
        return pattern.matcher(objCliente.getCedula()).matches();
    }
}