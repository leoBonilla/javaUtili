/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades.rut;

/**
 *
 * @author Leo
 */
public class Rut {

/**
 * 
 * @param rut String
 * @return boolean 
 * Devuelve un valor booleano true si el rut es valido false si no lo es
 */
    public static boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut = cleanRut(rut);
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
            char dv = copyVerificatorDigit(rut);
            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
            System.out.println("Ha ocurrido un error de formato"+ e.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al procesar el rut");
        }
        return validacion;
    }
    
    /**
     *
     * @param rut String
     * @return String 
     * Devuelve el rut sin los puntos y guion
     */
    public static String cleanRut(String rut){
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            return  rut.replace("-", "");
    }
    
    /**
     *
     * @param rut String
     * @return char
     * devuelve el ultimo caracter del rut ingresado correspondiente
     * al digito verificador
     */
    public static char copyVerificatorDigit(String rut){
       return rut.charAt(rut.length() - 1);
    }

}
