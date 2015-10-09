/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades.numeric;

import java.util.Random;

/**
 *
 * @author Leo
 */
public class Numeric {
    
    /**
     *
     * @param min Numero minimo a ser generado
     * @param max Numero maximo a ser generado
     * @return  un numero aleatorio entre los rangos min y max
     */
    public static int generarNumeroAleatorio(int min, int max) {
        Random rdm = new Random();
        return rdm.nextInt(max - min + 1) + min;
    }


    
}
