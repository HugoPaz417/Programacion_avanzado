package Logica;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import BDatos.BDPaquete;
import Clases.Persona;

public class LPersona {
    BDPaquete objBDPaquete = new BDPaquete();
    public static boolean validarCedula(Persona objPersona) {
        Pattern pattern = Pattern.compile("[0-9]{10}");
        return pattern.matcher(objPersona.getCedula()).matches();
    }
    public boolean validarCorreo(Persona objPersona) {String patron = "^[a-zA-Z0-9]+[\\._]?[a-zA-Z0-9]+[@]\\w+[.]\\w{2,3}$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(objPersona.getMail());
        return matcher.matches();
    }

}
